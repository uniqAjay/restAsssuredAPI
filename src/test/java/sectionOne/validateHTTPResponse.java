package sectionOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class validateHTTPResponse {
//	https://reqres.in/api/users?page=2
	
	@Test(enabled = false)
	public void getSingleUser() {
		
		baseURI = "https://reqres.in/api/users/2";
		
//		Get request specification of the request 
		RequestSpecification requestSpec = given();
		
//		call get method
		Response response = requestSpec.get();
		
//		Get response code 
		int statusCode =  response.getStatusCode();
		
//		validate the status code
		Assert.assertEquals(statusCode, 200," Incorrect status code returned");
		
		String statusLine = response.getStatusLine();
		
//		System.out.println(statusLine);
//		Validate statusLine
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Incorrect status Line returned");
		
	}
	
	@Test(enabled = false)
	void getSingleUserValidatableResponse() {
		
		baseURI = "https://reqres.in/api/users/2";
		
//		Get request specification of the request 
		RequestSpecification requestSpec = given();
		
//		call get method
		Response response = requestSpec.get();
		
		ValidatableResponse validate = response.then();
		
//		status code
		validate.statusCode(200);
		
//		status line
		validate.statusLine("HTTP/1.1 200 OK");
	}
	
	@Test
	void getSingleUserBDD() {
	
		
	 given()
	 
	 
	 .when()
	 	.get("https://reqres.in/api/users/2")
	 
	 .then()
	 	.statusCode(200)
	 	.statusLine("HTTP/1.1 200 OK");
	
	}

}


