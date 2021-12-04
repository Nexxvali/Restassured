package Dishnetworks.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
public class TestGetMethod {
	@Test(priority = 1)
	public void testStatuscode() {
		get("https://postman-echo.com/GET").then().statusCode(200);
	}
	@Test(priority = 2)
	public void testbody() {
		get("https://postman-echo.com/GET").then().assertThat()
		.body("headers.host", equalTo("postman-echo.com"));
	}
	@Test(priority = 3)
	public void testHeader() {
		get("https://postman-echo.com/GET").then()
		.header("Content-Encoding", "gzip");
	}

}
