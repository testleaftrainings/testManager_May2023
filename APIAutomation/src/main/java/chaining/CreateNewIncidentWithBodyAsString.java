package chaining;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateNewIncidentWithBodyAsString extends BaseClass {
	
	@Test
	public void runCreateIncident() {
					
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
		
		JsonPath jsonPath = response.jsonPath();
		
		sysId = jsonPath.get("result.sys_id");
		
		
		

	}

}
