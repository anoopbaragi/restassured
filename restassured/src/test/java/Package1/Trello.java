package Package1;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Trello 
{
	public String URL = "https://trello.com";
	public String id;
	
	
	@Test(enabled = false)
	public void getboards()
	{

		String str ="/b/8TfbcSLx/anoop";
		Response response =given().queryParam("key", "e631104c0216ba9b11b1c3e90acd23f0")
				.queryParam("token", "ATTAc993ee3ee7bc23d88fc493c837fa4c992197d597c1376a5e96b0e8d8d97a830eCF60B6CA")
				.header("Content-Type","application/json").when()
				.get("https://trello.com/"+str).then().extract().response();
		

		System.out.println(response.getBody());
	}
	@Test(enabled = true)
	public void createboards()
	{
		String str ="/1/boards/";
		Response response =given().queryParam("name", "MYSURU")
				.queryParam("key", "e631104c0216ba9b11b1c3e90acd23f0")
				.queryParam("token", "ATTAc993ee3ee7bc23d88fc493c837fa4c992197d597c1376a5e96b0e8d8d97a830eCF60B6CA")
				.header("Content-Type","application/json").when()
				.post("https://trello.com"+str).then().extract().response();
		JsonPath jp = new JsonPath(response.asString());
		 id = jp.get("id");
		 System.out.println(id);
		 System.out.println(response);
		System.out.println(response.getBody());
	}
	
	@Test(enabled = false)
	public void delete_boards() 
	{ 
		Response response=given().queryParam("key", "e631104c0216ba9b11b1c3e90acd23f0")
				.queryParam("token", "ATTAc993ee3ee7bc23d88fc493c837fa4c992197d597c1376a5e96b0e8d8d97a830eCF60B6CA")
				.header("content-Type","application/json")
				.when().delete("https://trello.com/1/boards/"+id).then().extract().response();
		System.out.println(response.getBody());
		
	}
	@Test(enabled = true)
	 public void update_Board()
	{	
		//String str ="/1/boards/+id";
		Response response =given().queryParam("name", "MYSURU5555")
				.queryParam("key", "e631104c0216ba9b11b1c3e90acd23f0")
				.queryParam("token", "ATTAc993ee3ee7bc23d88fc493c837fa4c992197d597c1376a5e96b0e8d8d97a830eCF60B6CA")
				.header("Content-Type","application/json")
				.when().put("https://trello.com/1/boards/"+id).then().extract().response();
				System.out.println(response.getBody());
	 }
}
