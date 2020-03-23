package com.portfolio.rest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.portfolio.CategoryInfo;
import com.portfolio.Constants;
import com.portfolio.PortfolioConfig;
import com.portfolio.PortfolioUtils;
import com.portfolio.RecommendChangesResponse;
import com.portfolio.RecommendPortfolioResponse;
import com.portfolio.Transaction;

/*
 * Portfolio Advisor
 * 
 * Provides REST endpoints for the following actions
 * 
 * o recommendPortfolio - Returns the fund allocation for each category in percent for the specified portfolio number.
 *                        Implemented by the method getPortfolio
 * 
 * o recommendChanges   - Returns the transactions required to match the specidfied portfolio.
 *                        Implemented by the method getPortfolioChanges
 */
@Path("/")
public class PortfolioAdvisor {

	private PortfolioConfig portfolioConfig;
	private static final Logger logger = LogManager.getLogger("PortfolioAdvisor");

	/*
	 * PortfolioAdvisor
	 * 
	 * Initializes portfolios and category names based on a JSON file. 
	 */
	public PortfolioAdvisor() throws Exception {	
		logger.info("Starting PortfolioAdvisor");
		String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader()
					.getResource(Constants.PORFOLIO_DEFINITION_FILE).toURI())));
		} catch (Exception e) {
			logger.fatal("Failed to initialize PortfolioAdvisor");
			throw (e);
		}
		
	    portfolioConfig = new Gson().fromJson(json, PortfolioConfig.class);
	}

	/*
	 * getPortfolio
	 * 
	 * o Recommend an ideal portfolio 
	 * 		input:  ​A client provides the advisor his/her risk preference (1 being very 
	 * 				risk averse, and 10 being insensitive to risk). 
	 * 		output: Return to the client the recommended portfolio based on his/her risk preference 
	 * 
	 * 		Method: GET
	 * 		URI: 	/recommendPortfolio/{risk-preference}
	 * 
	 * 		Returns: A JSON object describing the portfolio for the specifed risk preference.
	 * 
	 */
	@GET
	@Path("/" + Constants.REQ_REC_PORTFOLIO + "/{risk-level}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPortfolio(@PathParam("risk-level") int riskLevel) {
		logger.debug("getPortfolio -- entered: riskLevel: " + riskLevel);

		if (!isRiskLevelValid(riskLevel)) {
			logger.error("getPortfolio: NOT FOUND");
			return Response.status(Response.Status.NOT_FOUND).entity("Portfolio is not found").build();
		}
		
		riskLevel--;	// adjust to be 0 based index
		
		String details = "Recommended portfolio based on risk level";
		RecommendPortfolioResponse resp = new RecommendPortfolioResponse(details, portfolioConfig.getPortfolio(riskLevel));
		Gson gson = new Gson();
		String json = gson.toJson(resp);
		logger.debug("getPortfolio -- exit OK: body: " + json);
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}

	/*
	 * getPortfolioChanges
	 * 
	 * o Recommend changes to a user’s actual portfolio 
	 * 		input:  A client tells the advisor a risk level and how much money they currently have 
	 *              allocated to each of the 5 investment categories. This is requested in $ (not a %) 
	 * 
	 * 		output: If the user's current allocation is not ideal for their risk level as displayed in 
	 *              response from getPortfolio, recommend an allocation transference to correspond with 
	 *              suggested allocation.
	 * 
	 * 		Method: GET
	 * 		URI: 	/recommendChanges/{risk-preference}/{category1}/{category2}/{category3}/{category4}/{category5}/
	 * 
	 * 		Returns: A JSON object describing the transactions required to match the specified portfolio.
	 * 
	 */
	@GET
	@Path("/" + Constants.REQ_REC_CHANGES + "/{risk-level}" + "/{category1}" + "/{category2}" + "/{category3}"
			+ "/{category4}" + "/{category5}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPortfolioChanges(@PathParam("risk-level") int riskLevel, @PathParam("category1") double category1,
			@PathParam("category2") double category2, @PathParam("category3") double category3,
			@PathParam("category4") double category4, @PathParam("category5") double category5) {
		logger.debug("getPortfolioChanges -- entered: riskLevel: " + riskLevel + ", category funds: " +
			category1 + ", " + category2 + ", " + category3 + ", " + category4 + ", " + category5);

		if (!isRiskLevelValid(riskLevel)) {
			logger.error("getPortfolioChanges: NOT FOUND");
			return Response.status(Response.Status.NOT_FOUND).entity("Portfolio is not found").build();
		}

		riskLevel--;	// adjust to be 0 based index

		double totalFunds = 0.0;
		double[] categoryFunds = new double[Constants.NUM_CATEGORIES];
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		boolean allocationCorrect = false;
		categoryFunds[0] = category1;
		categoryFunds[1] = category2;
		categoryFunds[2] = category3;
		categoryFunds[3] = category4;
		categoryFunds[4] = category5;

		if (!areCategoryFundsValid(categoryFunds)) {
			String info = "Negative category fund values are not supported";
			logger.error("getPortfolioChanges: BAD_REQUEST, " + info);
			return Response.status(Response.Status.BAD_REQUEST).entity(info).build();
		}
		
		for (int i = 0; i < categoryFunds.length; i++) {
			totalFunds += categoryFunds[i];
		}
		
		totalFunds = PortfolioUtils.roundValue(totalFunds);
		if (totalFunds <= 0) {
			String info = "No funds were provided";
			logger.error("getPortfolioChanges: BAD_REQUEST, " + info);
			return Response.status(Response.Status.BAD_REQUEST).entity(info).build();
		}

		// Examine category to determine if current allocation is within (+/-) the allowed deviation.
		// Determine value required to get category within range.
		CategoryInfo[] info = new CategoryInfo[5];

		while (!allocationCorrect) {
			allocationCorrect = PortfolioUtils.determineAllocation(portfolioConfig.getPortfolio(riskLevel), 
									totalFunds, categoryFunds, info);

			if (!allocationCorrect) {
				Transaction t = PortfolioUtils.adjustAllocation(portfolioConfig.getCategoryNames(), categoryFunds, info);
				transactions.add(t);
			}
		}

		String details = "Recommended portfolio transactions";
		RecommendChangesResponse resp = new RecommendChangesResponse(details, transactions);
		Gson gson = new Gson();
		String json = gson.toJson(resp);
		logger.debug("getPortfolioChanges -- exit OK: body: " + json);
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	/*
	 * isRiskLevelValid
	 * 
	 * Validates that risk level is within the valid range
	 */
	private boolean isRiskLevelValid(int riskLevel) {
		if ((riskLevel <= 0) || riskLevel > portfolioConfig.getPortfolios().length) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * areCategoryFundsValid
	 * 
	 * Validates that each of the category values is a non negative value
	 */
	private boolean areCategoryFundsValid(double[] categoryFunds) {
		boolean valid = true;
		for (int i = 0; i < categoryFunds.length; i++) {
			if (categoryFunds[i] < 0) {
				valid = false;
			}
		}

		return valid;
	}

}