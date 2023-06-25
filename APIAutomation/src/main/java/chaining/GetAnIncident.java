package chaining;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAnIncident extends BaseClass{
	
	@Test
	public void runGetIncident() {
		Response response = RestAssured
		.given()
		.log()
		.all()
		.queryParam("sysparm_fields", "number,sys_id,short_description")
		.queryParam("sysparm_limit", "3")
		.header("Accept","application/json")
		.when()
		.get(sysId);
		
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
