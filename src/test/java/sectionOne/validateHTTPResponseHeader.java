package sectionOne;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class validateHTTPResponseHeader {
	
//	https://reqres.in/api/users?page=2
	
	@Test
	public void getSingleUser() {
		
//		Get request specification
		RequestSpecification reqestSpec = RestAssured.given();
		
		
//		specify base uri
		reqestSpec.baseUri("https://reqres.in");
		reqestSpec.basePath("/api/users?page=2");
		
//		create get request
		Response response = reqestSpec.get();
		
//		validate response
		String contentType = response.getHeader("content-Type");
//		System.out.println(connection);
		
		Headers headers = response.getHeaders();
		
//		read all the response header attribute/keys and print their values
		
		for (Header header : headers) {
			 
			System.out.println(header.getName()+":"+ header.getValue());
							
						 
			}
			 
			
		    Assert.assertEquals(contentType,"application/json; charset=utf-8");
	
			 }
			
			
		}
		
		



