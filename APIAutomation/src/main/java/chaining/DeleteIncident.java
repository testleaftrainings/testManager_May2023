package chaining;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident extends BaseClass{
	
	@Test
	public void runGetIncident() {
		Response response = RestAssured
		.given()
		.log()
		.all()
		.when()
		.delete(sysId)
		.then()
		.assertThat()
		.statusCode(204)
		.extract()
		.response();
		

	}

}
