package Package1;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class RA 
{
	public String URL = "https://reqres.in/api/users?page=2";
	
	@Test(enabled = false)
	public void	test1()
	{
		Response rp = get(URL);
		int scode = rp.statusCode();
		Assert.assertEquals(scode, 201);
		//System.out.println();
		System.out.println(rp.time());
		System.out.println(rp.getBody());
	}
	
	@Test(enabled = false)
	public void test2()
	{
		given().get(URL).then().statusCode(200).body("data.id",equalTo(71)).log().all();
	}
	
	@Test(enabled = false)
	public void test3()
	{
		JSONObject js = new JSONObject();
		js.put("name", "Anoop");
		js.put("job", "SDET");
		//System.out.println(js.toJSONString());
		//System.out.println(js.toString());
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}
	@Test(enabled = false)
	public void test4()
	{
		JSONObject js = new JSONObject();
		js.put("name", "Anoop");
		js.put("job", "TL");
		//System.out.println(js.toJSONString());
		//System.out.println(js.toString());
		given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	@Test(enabled = true)
	public void test5()
	{
		//JSONObject js = new JSONObject();
		//js.put("name", "Anoop");
		//js.put("job", "TL");
		//System.out.println(js.toJSONString());
		//System.out.println(js.toString());
		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();	
	}
	@Test(enabled = false)
	public void test6()
	{
		//given().get("http://localhost:3000/users").then().statusCode(200).log().all();
		given().get("http://localhost:3000/users").then().statusCode(200).body("id",equalTo(4)).log().all();
	}
	@Test(enabled = false)
	public void test7()
	{
		JSONObject js = new JSONObject();
		baseURI="http://localhost:3000";
		js.put("id", "5");
		js.put("role", "SDTE");
		given().body(js.toJSONString()).when().post("/JOB_ROLE").then().statusCode(201).log().all();
	}
	
	@Test(enabled = false)
	public void test8()
	{
		JSONObject js = new JSONObject();
		js.put("id", "2");
		js.put("role","PM");
		//System.out.println(js.toJSONString());
		//System.out.println(js.toString());
		given().body(js.toJSONString()).when().put("http://localhost:3000/JOB_ROLE/2").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void test9()
	{
		given().delete("http://localhost:3000/JOB_ROLE/3").then().statusCode(200).log().all();	
	}
	
	}
