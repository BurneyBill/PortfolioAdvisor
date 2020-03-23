package com.portfolio.rest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.ws.rs.core.Response;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.portfolio.Constants;
import com.portfolio.RecommendPortfolioResponse;

/*
 * TestPortfolioAdvisor
 * 
 * JUnit test cases.
 * 
 */
public class TestPortfolioAdvisor {

	PortfolioAdvisor advisor;
	
//	public TestPortfolioAdvisor() {
//		
//	}
//	
	@BeforeEach
	void setUp() throws Exception {
		advisor = new PortfolioAdvisor();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test_getPortfolio_0() {
		 Response resp = advisor.getPortfolio(0);
		 
		 if (resp.getStatus() != Response.Status.NOT_FOUND.getStatusCode()) {
			 fail("Expected request to fail");
		 }
	}

	@Test
	void test_getPortfolio_1() {
		 Response resp = advisor.getPortfolio(1);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_1: response: " + json);
		 
		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_2() {
		 Response resp = advisor.getPortfolio(2);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_2: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_3() {
		 Response resp = advisor.getPortfolio(3);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_3: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_4() {
		 Response resp = advisor.getPortfolio(4);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_4: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_5() {
		 Response resp = advisor.getPortfolio(5);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_5: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_6() {
		 Response resp = advisor.getPortfolio(6);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_6: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_7() {
		 Response resp = advisor.getPortfolio(7);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_7: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_8() {
		 Response resp = advisor.getPortfolio(8);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_8: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_9() {
		 Response resp = advisor.getPortfolio(9);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_9: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_10() {
		 Response resp = advisor.getPortfolio(10);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolio_10: response: " + json);

		 validatePortfolioResult(json);
	}

	@Test
	void test_getPortfolio_negative() {
		 Response resp = advisor.getPortfolio(-1);
		 
		 if (resp.getStatus() != Response.Status.NOT_FOUND.getStatusCode()) {
			 fail("Expected request to fail");
		 }
	}
	
	@Test
	void test_getPortfolio_invalid_riskLevel() {
		 Response resp = advisor.getPortfolio(11);
		 
		 if (resp.getStatus() != Response.Status.NOT_FOUND.getStatusCode()) {
			 fail("Expected request to fail");
		 }
	}

	/* ****** */
	
	@Test
	void test_getPortfolioChanges_1() {
		 Response resp = advisor.getPortfolioChanges(1, 900.0, 1.0, 2.0, 3.0, 4.0);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_1: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges_2() {
		 Response resp = advisor.getPortfolioChanges(2, 1.0, 0.0, 0.0, 0.0, 0.0);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_2: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges_3() {
		 Response resp = advisor.getPortfolioChanges(3, 100.0, 0.0, 0.0, 0.0, 1.0);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_3: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges4() {
		 Response resp = advisor.getPortfolioChanges(4, 0.0, 0.0, 1.0, 0.0, 0.0);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_4: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges_5() {
		 Response resp = advisor.getPortfolioChanges(5, 999.0, 998.0, 997.0, 996.0, 995.0);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_5: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges_6() {
		 Response resp = advisor.getPortfolioChanges(6, 100123.0, 100123.0, 100123.0, 100123.0, 100123.0);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_6: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges_7() {
		 Response resp = advisor.getPortfolioChanges(7, 10000.0, 0.0, 20000.1, 1234560.0, 0.0);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_7: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges_8() {
		 Response resp = advisor.getPortfolioChanges(8, 10.0, 11.1, 12.2, 13.3, 14.4);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_8: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges_9() {
		 Response resp = advisor.getPortfolioChanges(9, 100.50, 0.0, 100.0, 0.0, 50.1);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_9: response: " + json);
	}

	@Test
	void test_getPortfolioChanges_10() {
		 Response resp = advisor.getPortfolioChanges(10, 100.0, 0.0, 0.0, 0.0, 0.0);
		 assertTrue(resp.getStatus() == Response.Status.OK.getStatusCode());
		 
		 String json = (String) resp.getEntity();
		 System.out.println("test_getPortfolioChanges_10: response: " + json);
	}
	
	@Test
	void test_getPortfolioChanges_0() {
		 Response resp = advisor.getPortfolioChanges(0, 100.0, 0.0, 0.0, 0.0, 0.0);
		 
		 if (resp.getStatus() != Response.Status.NOT_FOUND.getStatusCode()) {
			 fail("Expected request to fail");
		 }
	}

	@Test
	void test_getPortfolioChanges_negative() {
		 Response resp = advisor.getPortfolioChanges(-1, 100.0, 0.0, 0.0, 0.0, 0.0);
		 
		 if (resp.getStatus() != Response.Status.NOT_FOUND.getStatusCode()) {
			 fail("Expected request to fail");
		 }
	}

	@Test
	void test_getPortfolioChanges_invalid_riskLevel() {
		 Response resp = advisor.getPortfolioChanges(11, 100.0, 0.0, 0.0, 0.0, 0.0);
		 
		 if (resp.getStatus() != Response.Status.NOT_FOUND.getStatusCode()) {
			 fail("Expected request to fail");
		 }
	}
	
	@Test
	void test_getPortfolioChanges_no_funds() {
		 Response resp = advisor.getPortfolioChanges(4, 0.0, 0.0, 0.0, 0.0, 0.0);
		 
		 if (resp.getStatus() != Response.Status.BAD_REQUEST.getStatusCode()) {
			 fail("Expected request to fail");
		 }
	}

	/*
	 * validatePortfolioResult
	 * 
	 * Validate that portfolio percentages add up to 100
	 * 
	 */
	@Ignore
	void validatePortfolioResult (String json) {
		 RecommendPortfolioResponse data = new Gson().fromJson(json, RecommendPortfolioResponse.class);
		 if ((data.getPortfolio().getPortfolioNumber() < 1) || (data.getPortfolio().getPortfolioNumber() > 10)) {
			 fail("Portfolio number is out of range");
		 }
		 
		 int totalPercent = 0;
		 for (int i = 0; i < Constants.NUM_CATEGORIES; i++) {
			 totalPercent += data.getPortfolio().getCategory(i).getValue();
		 }
		 if (totalPercent != 100) {
			 fail("Portfolio total percentage is invalid");
		 }
	}
}
