package Dishnetworks.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {

	@Test
	public void GetresponseBody()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://reqres.in/";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET);

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

	}

	@Test
	public void Getstatuscode()
	{
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);

		// Get the status code from the Response. In case of 
		// a successfull interaction with the web service, we
		// should get a status code of 200.
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
	
	@Test
	public void GetInvalidResponse()
	{
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/78789798798");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
	@Test
	public void GetStatusLine()
	{
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		
		// Get the status line from the Response and store it in a variable called statusLine
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
	}
	
	//mahortas
	@Test
	public void ValidateResponseBody()
	{
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		System.out.println("Response Body is: " + body.asString());

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.toLowerCase().contains("description") /*Expected value*/, true /*Actual Value*/, "Response body contains description");
	}
	
	
}