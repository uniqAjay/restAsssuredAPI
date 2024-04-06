package sectionOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class firstGetRequest {
//	https://reqres.in/api/users?page=2?
	@Test
	void testcase01() {
		System.out.println("Executing testCase 01");
		Response res = get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println("Status code " + res.getStatusCode());
		
	}

//	This code is from session 03
	 
	@Test
	void testcase02() {
		
		System.out.println("Executing testCase 02");
		Response res1 = get("https://reqres.in/api/users?page=2");
		System.out.println("Response code " + res1.getStatusCode() );
		System.out.println("Response body " + res1.getBody().asString());
		System.out.println("Response Time " + res1.getTime());
		System.out.println("Response Header " + res1.getHeader("content-Type"));

		int statusCode = res1.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	
	@Test
	void testcase03() {
		
		System.out.println("Executing tesetCase 03 ");
		baseURI= "https://reqres.in/api/users?page=2";
		given()
		.queryParam("page", "2")
		.when()
		.get().then().statusCode(200);
	}
}
