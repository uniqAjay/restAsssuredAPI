package sectionTwo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class diserializationJsonDemo {
	
	@Test
  public void test01() {
	  
	 RequestSpecification reqSpec = RestAssured.given();
	 
	 reqSpec.baseUri("https://reqres.in");
	 reqSpec.basePath("/api/users");
	 
	 JSONObject jsonData = new JSONObject();
	 jsonData.put("name","Andrew");
	 jsonData.put("job","QA");
	 
	 ResponseBody responseBody= reqSpec.contentType(ContentType.JSON).body(jsonData.toJSONString()).post().getBody();
	 
	  System.out.println(responseBody.asString());
	 
	 JSONPostRequestResponse jsonToObject = responseBody.as(JSONPostRequestResponse.class);
	 
	 Assert.assertEquals(jsonToObject.name, "Andrew", "Not Found ");
	 Assert.assertEquals(jsonToObject.job, "QA", "Not Found ");
	 
	 
	 
	 
	 
	 
  }
	

}
