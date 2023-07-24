package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class parsingJSONResponseData {
	
	//@Test(priority = 1)
	void testJsonResponse()
	{
		//Approach1
		
		
		given()
			.contentType("ContentType.JSON")
		
		
		.when()
			.get("http://localhost:3000/users")
		
		
		.then()
			.statusCode(200)
			.body("[1].address", equalTo("baneshowr"));
	}
	
	//@Test(priority = 2)
	void testJsonResponse1()
	{
		//Approach1
		
		
		Response res = given()
			.contentType("ContentType.JSON")
		
		
		.when()
			.get("http://localhost:3000/users");
		
		Assert.assertEquals(res.getStatusCode(),200); //validation 1
		Assert.assertEquals(res.getHeader("Content-Type"),"application/json; charset=utf-8");
		
		String address = res.jsonPath().get("[1].address").toString();
		Assert.assertEquals(address, "baneshowr");
		
	}
	
	//@Test(priority = 3)
	void testJsonResponseBodyData()
	{
		//Approach1
		
		
		Response res = given()
			.contentType(ContentType.JSON)
		
		
		.when()
			.get("http://localhost:3000/users");
		
		//json object class
		
		JSONObject jo = new JSONObject(res.asString());   //converting response to json object type
		
		
		for(int i=0;i<jo.getJSONArray("Students").length(); i++)
		{
			String bookTitle = jo.getJSONArray("Students").getJSONObject(i).get("address").toString();
			System.out.println(bookTitle);
		}
		
	}
	
	@Test(priority = 4)
	void testJsonResponseBodyData1()
	{
		//Approach1
		
		
		Response res = given()
			.contentType(ContentType.JSON)
		
		
		.when()
			.get("http://localhost:3000/users");
		
		//json object class
		
		JSONObject jo = new JSONObject(res.asString());   //converting response to json object type when response is response object
		
		boolean status = false;
		
		for(int i=0;i<jo.getJSONArray("Students").length(); i++)
		{
			String address = jo.getJSONArray("Students").getJSONObject(i).get("address").toString();
			if(address.equals("baneshowr"))
			{
				status = true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
		
	}

}
