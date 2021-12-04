package Dishnetworks.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.simple.*;
public class PostMethod {
	
	
	@Test
	public void testPOST(){
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com/";
		RequestSpecification request=RestAssured.given();
		JSONObject map=new JSONObject();
		map.put("userId", "2");
		map.put("id", "19");
		map.put("title", "this is projectdebug.com");
		map.put("body", "this is REST-Assured Tutorial");
		request.body(map.toJSONString());
		Response response=request.post("/posts");
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		System.out.println(response.body());
		assertEquals(statuscode, 201);

	}
}
