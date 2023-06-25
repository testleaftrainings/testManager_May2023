package chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass {
	
	public static String sysId;
	
	@BeforeMethod
	public void preCondition() {
		RestAssured.baseURI ="https://dev128088.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "India@123");

	}

}
