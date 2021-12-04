package Dishnetworks.RestAssured;


import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QueryParamDemo {
	
	@BeforeTest
	public void setup(){
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/comments";
	}

	/*
	 *This Test will show you all the comments on all the posts. 
	 */
	@Test(priority = 1)
	public void testAllComments(){
		Response response = given()
				.when()
				.get()
				.then().contentType("application/json")
				.extract()
				.response(); 
		String stringResponse = response.asString();
		System.out.println(stringResponse);
	}
	
	/*
	 *This Test will show you all the comments made only on postId 1. 
	 */
	@Test(priority = 1)
	public void testCommentsOnSinglePost(){
		Response response = given()
				.when()
				.queryParam("postId", "1")
				.get()
				.then().contentType("application/json")
				.extract()
				.response(); 
		
		System.out.println("=============================Beginning of TEST 2 =================================");
		String stringResponse = response.asString();
		System.out.println(stringResponse);
	}
}
