package Package1;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class RA 
{
	//public String baseurl = "https://simple-grocery-store-api.glitch.me";
	public String URL = "https://simple-grocery-store-api.glitch.me/status"; 
	public String URL1 = "https://simple-grocery-store-api.glitch.me/products"; 
	public String URL2 = "https://simple-grocery-store-api.glitch.me/products/:productId";
	static String cid;
	
	@Test(enabled = true)
	public void test1()
	{
		System.out.println("====================");
		given().get(URL).then().statusCode(200).log().all();
		System.out.println("====================");
	}
	@Test(enabled = true)
	public void test2()
	{
		given().get(URL1).then().statusCode(200).log().all();
		System.out.println("====================");
	}
	@Test(enabled = true)
	public void test3()
	{
		/*Response rep = given().queryParam("productId", 4643).header("Content-Type","application/json").when()
				.get("https://simple-grocery-store-api.glitch.me/products/:productId").then().log().all().extract().response();*/
		given().head("https://simple-grocery-store-api.glitch.me/products/4643").then().statusCode(200).log().all();
		System.out.println("====================");
	}
	@Test(enabled = true)
	public void test4()
	{
		/*Response rep = given().queryParam("productId", 4643).header("Content-Type","application/json").when()
				.get("https://simple-grocery-store-api.glitch.me/products/:productId").then().log().all().extract().response();*/
		Response response =	given().post("https://simple-grocery-store-api.glitch.me/carts").then().statusCode(201).log().all().extract().response();
		JsonPath jp = new JsonPath(response.asString());
		cid = jp.get("cartId");
		System.out.println("====================");
		//System.out.println(cid);
		 //System.out.println(response);
		//System.out.println(response.getBody());
	}
	
	@Test(enabled = true)
	public void test5()
	{
		given().get("https://simple-grocery-store-api.glitch.me/carts/"+cid).then().statusCode(200).log().all();
		System.out.println("====================");
	}
	@Test(enabled = true)
	public void test6()
	{
		JSONObject js = new JSONObject();
		js.put("productId", 4643);
		//given().contentType("application/json").request().param("productId", 4643).when().post("https://simple-grocery-store-api.glitch.me/carts/"+cid+"/items").then().log().all();
		given().body(js.toJSONString()).when().post("https://simple-grocery-store-api.glitch.me/carts/"+cid+"/items").then().statusCode(201).log().all();
	}
}
