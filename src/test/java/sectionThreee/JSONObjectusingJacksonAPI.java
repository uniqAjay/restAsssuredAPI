package sectionThreee;

import java.util.Iterator;
import java.util.Map.Entry;

import org.codehaus.groovy.ast.stmt.WhileStatement;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JSONObjectusingJacksonAPI {

	//	{
	//		  "firstName": "Amod",
	//		  "lastName": "Mahajan",
	//		  "age": 28,
	//		  "salary": 10000.56,
	//		  "isMarried": true,
	//		  "TechSkill": {
	//		    "Programming language": "Java",
	//		    "WebAutomation": "Selenium",
	//		    "API testing": "Rest Assured"
	//		  }
	//		}

	@Test
	void test01() {



		ObjectMapper objectMaper = new ObjectMapper();
		ObjectNode userDetails =  objectMaper.createObjectNode();
		userDetails.put("firstNme", "Prerna");
		userDetails.put("lastName", "Gupta");
		userDetails.put("age", 28);
		userDetails.put("salary", 10000.56);
		userDetails.put("IsMarried", false);

		ObjectNode techSkill =  objectMaper.createObjectNode();
		techSkill.put("Programming language", "Java");
		techSkill.put("WebAutomation", "Selenium");
		techSkill.put("API testing", "Rest Assured");

		userDetails.set("TechSkill", techSkill);

		try {
			String userDetailsAsString =  objectMaper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
			System.out.println(userDetailsAsString);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("-----------------Printing default value-------------------");
		System.out.println(userDetails.get("firstNme").asText());

		System.out.println("-----------------Printing Field-------------------");

		Iterator<String> fieldName = userDetails.fieldNames();

		while (fieldName.hasNext()) {
			System.out.println(fieldName.next());

		}

		System.out.println("--------------printing Elements----------------");

		Iterator<JsonNode> elementsValue =  userDetails.elements();

		while (elementsValue.hasNext()) {
			System.out.println(elementsValue.next());

		}

		System.out.println("--------------printing Fields----------------");
		Iterator<Entry<String, JsonNode>>fieldNames = userDetails.fields();

		while (fieldNames.hasNext()) {
			Entry<String, JsonNode> keyValues = fieldNames.next();

			System.out.println(keyValues.getKey() +":"+ keyValues.getValue());

		}

		
		Response response = RestAssured.given().baseUri("https://reqres.in/api/users")
				.contentType(ContentType.JSON)
				.body(userDetails).post();
				
				response.prettyPrint();
		




	}





}
