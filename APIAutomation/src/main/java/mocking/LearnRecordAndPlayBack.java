package mocking;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LearnRecordAndPlayBack {
	
	

	@Test
	public void runGetIncidents() {
		
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "India@123");

		// Step3: Build the request to be placed
		Response response = RestAssured
				.given().log().all()
				.header("Content-Type","application/json")
				.queryParam("sysparm_fields", "sys_id,number")
				.when()
				.post();
		
		response.prettyPrint();
	}
}
