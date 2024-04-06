package sectionThreee;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;


public class queryRequestSpecification {
//	https://reqres.in/api/users
	@Test
	void test01() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "QA");
		jsonData.put("job", "web Devloper");
		
		
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://reqres.in");
		req.basePath("/api/users");
		
		
		req.body(jsonData).contentType(ContentType.JSON).post();
		
		
//		 To retrive request Specification
		
		 QueryableRequestSpecification retriveReq = SpecificationQuerier.query(req);
		 
		 System.out.println(retriveReq.getBaseUri());
		 System.out.println(retriveReq.getBasePath());
		 System.out.println(retriveReq.getBody().toString());
		 
		 System.out.println("------------Request Header-------------");
		 
		 
		
		
	}
	

}
