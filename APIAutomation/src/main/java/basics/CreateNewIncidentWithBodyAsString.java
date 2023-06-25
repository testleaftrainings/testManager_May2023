package basics;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateNewIncidentWithBodyAsString {
	
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
		.header("Content-Type","application/json")
		.body("{\"category\":\"software\",\"short_description\":\"Created using RestAssured\"}")
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(201)
		.extract()
		.response();
		
		//to print response in console
		response.prettyPrint();
		
		
		
		
		
		

	}

}
