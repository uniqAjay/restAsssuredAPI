package sectionFour;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmpSerializationAndDesrilization {
	
	@Test
	public void classToJSONObeject() throws JsonProcessingException {
		
		POJOEmpClass emp = new POJOEmpClass();
		
		emp.setAge(22);
		emp.setFirstName("MrUniQ");
		emp.setLastName("RealWorlD");
		emp.setGender("male");
		emp.setSalary(23500);
		
		ObjectMapper mapObjects = new ObjectMapper();
		
		String empJSON = mapObjects.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
//		System.out.println(empJSON);
		
		RequestSpecification reqSpec = RestAssured.given();
		
		 Response response = reqSpec.baseUri("http://httpbin.org/post")
		.contentType(ContentType.JSON)
		.body(emp)
		.post();
		 
		System.out.println(response.prettyPrint());
		
		POJOEmpClass JSONToEmpObj = mapObjects.readValue( empJSON,POJOEmpClass.class );
		
		System.out.println(JSONToEmpObj.getFirstName());
		System.out.println(JSONToEmpObj.getLastName());
		
		
		
		
	}

}
