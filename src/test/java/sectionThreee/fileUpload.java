package sectionThreee;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class fileUpload {

	@Test
	void test01() {
//		https://httpbin.org/post
		
		File fileUpload = new File("C:\\Users\\ajayg\\OneDrive\\Desktop\\UniqueWorld.txt");
		
		RequestSpecification req = RestAssured.given();
		
		req.multiPart(fileUpload);
		
		req.baseUri("https://httpbin.org");
		req.basePath("/post");
		
		Response response = req.post();
		response.prettyPrint();
		
		
	}
	
	@Test
	void test02() {
//		https://httpbin.org/post
		
		File fileUpload = new File("C:\\Users\\ajayg\\OneDrive\\Desktop\\download.jpg");
		
		RequestSpecification req = RestAssured.given();
		
		req.multiPart(fileUpload);
		
		req.baseUri("https://petstore.swagger.io");
		req.basePath("/v2/pet/123/uploadImage");
		
		Response response = req.post();
		response.prettyPrint();
		
		
	}
}
