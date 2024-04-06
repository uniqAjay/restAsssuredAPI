package sectionOne;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authorizationBearerToken {

//	https://gorest.co.in/public/v2/users
	@Test
	public void bearerTocken1() {
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://gorest.co.in");
		reqSpec.basePath("/public/v2/users");
		
		
//		Stored bearer token in string 
		String authToken = "Bearer 68d3481f69573add3000b4f988730e42ff5e16ffaf9fd3ce9199dcf942de3103";
		
		
//		created request body 
		JSONObject payload = new JSONObject();
		payload.put("name","Uniq");
		payload.put("gender","male");
		payload.put("email","realWorld@mail.com");
		payload.put("status","Active");
		
//		Adding header to the request
		
		reqSpec.headers("Authorization", authToken).contentType(ContentType.JSON).body(payload.toJSONString());
		
		Response response = reqSpec.post();
		
		System.out.println("Request Body " + response.getBody().asString());
		
		
	}
}
