package Dishnetworks.RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class patchmethod {
	@Test
	public void test2() {
		JSONObject req=new JSONObject();
		req.put("name", "prema");
		req.put("job", "business analyst");
		System.out.println(req);
		System.out.println(req.toString());
		given().
		body(req.toJSONString()).when().patch("https://reqres.in/api/users").then().statusCode(200);
	}
}
