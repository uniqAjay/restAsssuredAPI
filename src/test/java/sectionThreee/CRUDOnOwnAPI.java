package sectionThreee;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDOnOwnAPI {
	
	
	@Test(enabled = false)
	void testCase01() {
		
		RequestSpecification req = RestAssured.given();
		
		Response response = req.baseUri("http://localhost:3000/users").get();
		response.prettyPrint();
		
		
	}
	

	@Test(enabled = false)
	void testCase02() {
		
		RequestSpecification req = RestAssured.given();
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name","ken");
		jsonData.put("job","Racer");
		
		
		Response response = req.baseUri("http://localhost:3000/users")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString()).post();
		response.prettyPrint();
		
		
	}
	

	@Test
	void testCase03() {
		
		RequestSpecification req = RestAssured.given();
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name","Shelby");
		jsonData.put("job","Shelby-Motors");
		
		Response response = req.baseUri("http://localhost:3000/users")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString()).put("/03");
		 response.prettyPrint();
		
		
	}
	

	@Test
	void testCase04() {
		
		RequestSpecification req = RestAssured.given();
		
		Response response = req.baseUri("http://localhost:3000/users").delete("/1cc2");
		response.prettyPrint();
		
		Response response1 = req.baseUri("http://localhost:3000/users").get();
		response1.prettyPrint();
		
		
	}
	
	
	

}
