package sectionThreee;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.ResponseBody;

public class JSONObjectUsingJavaMap {
	
//	https://restful-booker.herokuapp.com/auth

@Test
	void getToken() {
		
		Map<String, String> userData = new HashMap<String, String>();
		userData.put("username", "admin");
		userData.put("password", "password123");
		
		ResponseBody responseBody =	RestAssured.given()
	 	.baseUri("https://restful-booker.herokuapp.com/auth")
		.contentType(ContentType.JSON)
		.body(userData).post().getBody();
		
		System.out.println(responseBody.asString());
		
		
	}

 void test02() {
	 
	 
 }
	

}
