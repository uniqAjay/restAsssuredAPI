package sectionOne;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authorization {
	@Test(enabled = false)
	
	void basicAuth() {
//		https://postman-echo.com/basic-auth
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://postman-echo.com");
		reqSpec.basePath("/basic-auth");
		
		Response response = reqSpec.auth().preemptive().basic("postman", "password").get();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		
		
	}
	
	@Test
	public void digestAuth() {
//		https://httpbin.org/digest-auth/undefined/Ajay/Ajay
 
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("digest-auth/undefined/Ajay/Ajay");
		
		Response response = reqSpec.auth().digest("Ajay", "Ajay").get();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		
	}

}
