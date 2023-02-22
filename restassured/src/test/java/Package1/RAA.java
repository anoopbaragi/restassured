package Package1;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class RAA 
{
public String url = "https://reqres.in/api/users?page=2";
	
	@Test (enabled = true)
	public void testcase1() 
	{
		Response rep = get(url);
		System.out.println(rep.statusCode());
		int statusCode= rep.statusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(rep.asString());
		System.out.println(rep.getBody());
	}
	
	
	@Test (enabled = true)
	public void testcase2() 
	{
		given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id",equalTo(2)).log().all();
	}
	
	@Test (enabled = true)
	public void testcase3() 
	{
		given().get("https://reqres.in/api/users/23").then().statusCode(404);
	}
	
	
	@Test (enabled = true)
	public void testcase4() 
	{
		given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
	}
	
	@Test (enabled = true)
	public void testcase5() 
	{
		given().get("https://reqres.in/api/unknown/2").then().statusCode(200).log().all();
	}
	
	@Test (enabled = true)
	public void testcase6() 
	{
		given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log().all();
	}
	
	
	@Test (enabled = true)
	public void testcase7() 
	{
		JSONObject js = new JSONObject();
		js.put("name", "ABCD");
		js.put("job", "Employee");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}
	
	@Test (enabled = true)
	public void testcase8() 
	{
		
		JSONObject js = new JSONObject();
		js.put("name", "EFG");
		js.put("job", "TESTER");
		given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	
	}
	
	@Test (enabled = true)
	public void testcase9()
	{
		JSONObject js = new JSONObject();
		js.put("name", "ABCD");
		js.put("job", "TL");
		given().body(js.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test (enabled = true)
	public void testcase10() 
	{
		given().when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
	
	@Test (enabled = true)
	public void testcase11()
	{
		JSONObject js = new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "pistol");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
	}
	@Test (enabled = true)
	public void testcase12()
	{
		JSONObject js = new JSONObject();
		js.put("email", "sydney@fife");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(400).log().all();
	}
	
	@Test(enabled = true)
 public void testcase13()
 {
		JSONObject js = new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "pistol");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(200).log().all();
		
 }
	@Test(enabled = true)
	 public void testcase14()
	 {
			JSONObject js = new JSONObject();
			js.put("email", "peter@klaven");
			given().body(js.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(400).log().all();
			
	 }
	
	@Test (enabled = true)
	public void testcase15() 
	{
		given().get("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();
	}
}
