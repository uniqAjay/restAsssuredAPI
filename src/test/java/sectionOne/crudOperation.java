package sectionOne;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class crudOperation {
	
// @Test	
// void testPostRequest(){
//		
//	System.out.println("Executing Post Request");
//	RestAssured.baseURI = "https://reqres.in/api/users";
//	
//	JSONObject jsonData =  new JSONObject();
//	jsonData.put("new","realWorld");
//	jsonData.put("job", "QA");
//	
//	RestAssured.given()
//	.header("content-type","application/json")
//	.contentType(ContentType.JSON)
//	.body(jsonData.toJSONString())
//	.when()
//	.post()
//	.then()
//	.statusCode(201)
//	.log().all();
//	 
//	 
//	}

// @Test
// void tesetPutRequest() {
////	 id: 624
//	 
//	 System.out.println("Executing Post Request");
//		RestAssured.baseURI = "https://reqres.in/api/users/228";
//		
//		JSONObject jsonData =  new JSONObject();
//		jsonData.put("name","Ajay");
//		jsonData.put("job", "insideTheMatrix");
//		
//		RestAssured.given()
//	    .header("content-type","application/json")
//		.contentType(ContentType.JSON)
//		.body(jsonData.toJSONString())
//		.when()
//		.put()
//		.then()
//		.statusCode(200)
//		.log().all();
// }
 
// @Test
// void testPatchRequest() {
//
//	 System.out.println("Executing patch Request");
//		RestAssured.baseURI = "https://reqres.in/api/users/228";
//		
//		JSONObject jsonData =  new JSONObject();
//		jsonData.put("name","Andrew");
//		jsonData.put("job", "outofMatrix");
//		
//		RestAssured.given().header("content-type","application/json")
//		  .contentType(ContentType.JSON)
//		  .body(jsonData.toJSONString())
//		.when()
//		  .patch()
//		.then()
//		   .statusCode(200)
//	       .log().all();
// }
 
 @Test
 void testDeleteRequest() {

	 System.out.println("Executing Delete Request");
		RestAssured.baseURI = "https://reqres.in/api/users/228";
		
//		JSONObject jsonData =  new JSONObject();
//		jsonData.put("name","Andrew");
//		jsonData.put("job", "outofMatrix");
		
		RestAssured.given().header("content-type","application/json")
		  .contentType(ContentType.JSON)
//		  .body(jsonData.toJSONString())
		.when()
		  .delete()
		.then()
		   .statusCode(204)
	       .log().all();
	 
 }
	 
 }

