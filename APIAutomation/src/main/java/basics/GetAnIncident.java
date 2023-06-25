package basics;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAnIncident {
	
	@Test
	public void runGetIncidents() {
		//Step1: Setup the endpoint
		RestAssured.baseURI ="https://dev128088.service-now.com/api/now/table/incident/1c741bd70b2322007518478d83673af3";
			
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
		.get();
		
		//to print response in console
		//response.prettyPrint();
		
		
		//to get data from response
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		JsonPath jsonPath = response.jsonPath();
		
		String number = jsonPath.get("result.number");
		
		System.out.println(number);
		
		
		

	}

}
