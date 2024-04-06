package sectionOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class validateJsonResponseBody {
//	https://reqres.in/api/users?page=2
	
	@Test
	void testCase01() {
		
//		Get request specification reference
		RequestSpecification requestSpec = RestAssured.given();
		
//		Specify baseURI and basePath
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users?page=2");
		
//		Perform get request
		Response response = requestSpec.get();
		
//		Get Response body
		ResponseBody responseBody = response.getBody();
		
//		Store Response body in string
		String responseString = responseBody.asString();
	 
//		Print reponse body in console
		System.out.println("Response Body :" + responseString);
		
//		Compare Expected Result
		Assert.assertEquals(responseString.contains("George"), true,"What you looking for is not in ResponseBody");
		
//		Find exact path
//		x.data[4].first_name
		
		JsonPath jsonPathView =  responseBody.jsonPath();
		String firstName = jsonPathView.get("data[4].first_name");
		
//		System.out.println(fitstName);
		
		Assert.assertEquals(firstName, "Charles","Sorry dude what you are searchihg for is not found so fuccckkk youuu");
		
		
		
		
		
		
		

		
		
	}

}
