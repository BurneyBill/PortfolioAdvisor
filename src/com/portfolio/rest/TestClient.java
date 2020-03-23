package com.portfolio.rest;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

import com.portfolio.Constants;

/*
 * TestClient
 * 
 * Client application to test REST endpoints.
 * 
 */
public class TestClient {

	private static final String webServiceURI = "http://localhost:8080/PortfolioAdvisor";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);

		// Send request to get portfolio based on risk
		webTarget = webTarget.path(Constants.WS_REST).path(Constants.REQ_REC_PORTFOLIO).path("1");
		Response resp = processRequest(webTarget);

		// Send request to get recommended changes to portfolio
		webTarget = client.target(serviceURI);
		webTarget = webTarget.path(Constants.WS_REST).path(Constants.REQ_REC_CHANGES).path("1").path("10").path("20").path("30").path("40").path("50");				
		resp = processRequest(webTarget);
	}

	/*
	 * processRequest
	 * 
	 * Send the request and process the response.
	 * 
	 */
	public static Response processRequest(WebTarget webTarget) {
		Response resp = webTarget.request().accept(MediaType.APPLICATION_JSON).get(Response.class);

		System.out.println(resp);
		if (resp == null) {
			System.out.println("Request failed, response object is null");
		}
		else {		
			if (resp.getStatus() == Response.Status.OK.getStatusCode()) {
				System.out.println("Request completed successfully");
				System.out.println(resp.readEntity(String.class));
			} 
			else {
				System.out.println("Request failed: status=" + resp.getStatus()
							+ ", reason=" + resp.getStatusInfo());
			}
		}

		return resp;
	}
}