package sectionThreee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayUsingJsonObject {
	
	@Test(enabled = false)
	void test01(){
//		https://reqres.in/api/users
		
//		{
//		    "name": "morpheus",
//		    "job": "leader"
//			"salery": 23500,
//			"age": 24
//		}
		
		JSONObject userData1 = new JSONObject();
		userData1.put("name", "Ajay");
		userData1.put("job", "QA");
		userData1.put("salery",23500);
		userData1.put("age", 24);
		
		JSONObject userData2 = new JSONObject();
		userData2.put("name", "Andrew");
		userData2.put("job", "OutOfMatrix");
		userData2.put("salery","Infinite");
		userData2.put("age", 35);
		
		JSONObject userData3 = new JSONObject();
		userData3.put("name", "Tristian");
		userData3.put("job", "OutOfMatrix");
		userData3.put("salery","Infinite");
		userData3.put("age", 34);
		
		JSONArray jsonArrayforUser = new JSONArray();
		jsonArrayforUser.add(userData1);
		jsonArrayforUser.add(userData2);
		jsonArrayforUser.add(userData3);
		
		Response response = RestAssured.given().baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(jsonArrayforUser).post();
		
		response.prettyPrint();
		
		
	}
	
	@Test
	
	void test02() {
		
		
		Map<String, Object> userData1 = new HashMap<String, Object>();
		userData1.put("name", "Ajay");
		userData1.put("job", "QA");
		userData1.put("salery",23500);
		userData1.put("age", 24);
		
		Map<String, Object> userData2 = new HashMap<String, Object>();
		userData2.put("name", "Andrew");
		userData2.put("job", "OutOfMatrix");
		userData2.put("salery","Infinite");
		userData2.put("age", 35);
		
		Map<String, Object> userData3 = new HashMap<String, Object>();
		userData3.put("name", "Tristian");
		userData3.put("job", "OutOfMatrix");
		userData3.put("salery","Infinite");
		userData3.put("age", 34);
		
		
	   List<Map<String,Object>> arrayForUserData = new ArrayList<Map<String, Object>>();
	
	
	   arrayForUserData.add(userData1);
	   arrayForUserData.add(userData2);
	   arrayForUserData.add(userData3);
		
		Response response = RestAssured.given().baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(arrayForUserData).post();
		
		response.prettyPrint();
		
		
	}

}
