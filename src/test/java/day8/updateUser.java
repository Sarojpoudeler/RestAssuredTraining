package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

public class updateUser {	
	
	@Test
	void test_updateUser(ITestContext context)
	{
		Faker faker= new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken = "aff088651bc622c65df2cc32d83456f4f2af2a0e7bfa3dce51f8208fbe3ab0e0";
		
		int id = (Integer) context.getAttribute("user_id");
		//int id = (Integer) context.getSuite().getAttribute("user_id"); //suite level data fetching from create
		
		given()
		 	.headers("Authorization","Bearer "+bearerToken)
		 	.contentType("application/json")
		 	.pathParam("id", id)
		 	.body(data.toString())
		
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
	
		 .then()
		 	.statusCode(200)
		 	.log().all();
	}

}
