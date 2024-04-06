package sectionOne;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class queryParameters {
//	https://reqres.in/api/users?page=2
	@Test
	public void testCase01() {
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		requestSpec.queryParam("page", "2");
		requestSpec.queryParam("id", "10");
		
		Response response =requestSpec.get();
		
	    ResponseBody responseBody =	response.getBody();
	
	
      JsonPath jsonPathView =	responseBody.jsonPath();
      String firstName = jsonPathView.get("data.first_name");
    
       
      Assert.assertEquals(firstName,"Byron","your result not found will get to you once we get");		
		
	}

}
