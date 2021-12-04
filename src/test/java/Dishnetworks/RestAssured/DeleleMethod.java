package Dishnetworks.RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DeleleMethod {
	@Test
	public void test2() {
		JSONObject req=new JSONObject();
		

		given().
		body(req.toJSONString()).when().delete("https://reqres.in/api/users").then().statusCode(204).log().all();
	}
}
