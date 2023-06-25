package mocking;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LearnToCreateStub {
	
	/*
	 * @BeforeMethod public void sampleStub() {
	 * stubFor(get("/api/now/table/incident") .willReturn(aResponse()
	 * .withStatus(200) .withHeader("Accept", "application/json")
	 * .withBody("{\"number\":\"INC0000060\",\"sys_id\": \"1c741bd70b2322007518478d83673af3\",short_description\":\"from stub\"}"
	 * ))); }
	 */

	@Test
	public void runGetIncidents() {
		
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		//RestAssured.authentication = RestAssured.basic("admin", "India@123");

		// Step3: Build the request to be placed
		Response response = RestAssured
				.given().log().all()
				.when()
				.get();
		
		response.prettyPrint();
	}
}
