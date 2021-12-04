package Dishnetworks.RestAssured;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutMethod {
@Test
public void test2() {
	JSONObject req=new JSONObject();
	req.put("name", "prema");
	req.put("job", "business analyst");
	System.out.println(req);
	System.out.println(req.toString());
	given().
	body(req.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200);
}
}
