package sectionOne;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authTwoPointO {
//	https://api-m.sandbox.paypal.com/v1/oauth2/token
	
	
	static String access_token;
	@Test
	void getAccessToken(){
		
		String client_Id = "AX0GxkJN0yF83Xf6pXsJmIYshe9VOF72x57bWV0jGuLfUOkra0rydQAqWVJDKgWjgS5BLPb-KpaEDV8A";
	    String Secret_Key = "ECxiplgDB5FuEkPPNP9dpnbBIaIC50cbpw8IRASw0GtvweUAJbv3lj40ixRZSV9vHViLOwOuLROPzdwL";
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://api-m.sandbox.paypal.com");
		reqSpec.basePath("/v1/oauth2/token");
		
		Response response = reqSpec.auth().preemptive().basic(client_Id, Secret_Key).param("grant_type", "client_credentials").post();
		
		response.prettyPeek();
		
		access_token = response.getBody().path("access_token");
		
		System.out.println(access_token);
		
		
	}
	
	@Test
	void getInvoice(String access_token) {
//		https://api-m.sandbox.paypal.com/v1/invoicing/invoices?page=3&page_size=4&total_count_required=true
		
		Response response = RestAssured.given()
		.auth().oauth2(access_token)
		.queryParam("page", "3").queryParam("page_size", "4")
		.queryParam("total_count_required", "true")
		.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
		
		response.prettyPeek();
	}

}
