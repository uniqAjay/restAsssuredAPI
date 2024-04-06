package sectionOne;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authorizationAPIKey {
	
	@Test
	public void authAPIKey() {
//		https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		
		
		
		RequestSpecification reqSpec = RestAssured.given();
		String APIKey = "8ce45afdba16b6fc3b4232978616089d";
		
		reqSpec.baseUri("https://api.openweathermap.org");
		reqSpec.basePath("/data/2.5/weather");
		reqSpec.queryParam("q", "pune").queryParam("appid", APIKey);
		
		Response response = reqSpec.get();
		
		System.out.println(response.getBody().asString());
		
		
	}

}

