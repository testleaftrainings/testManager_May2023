package basics;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class VerifyGetIncident {
	
	@Test
	public void runGetIncidents() {
		//Step1: Setup the endpoint
		RestAssured.baseURI ="https://dev128088.service-now.com/api/now/table/incident";
			
		//Step2: Setup the authentication
		RestAssured.authentication = RestAssured.basic("admin", "India@123");
		
		
		//Step3: Build the request to be placed
		Response response = RestAssured
		.given()
		.log()
		.all()
		.queryParam("sysparm_fields", "number,sys_id,short_description")
		.queryParam("sysparm_limit", "3")
		.header("Accept","application/json")
		.when()
		.get("1c741bd70b2322007518478d83673af3")
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		
		response.prettyPrint();
		
		
		

	}

}
