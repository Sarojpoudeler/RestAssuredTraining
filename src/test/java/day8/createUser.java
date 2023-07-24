package day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class createUser {

	
	@Test
	void test_createUser(ITestContext context)
	{
		Faker faker= new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "aff088651bc622c65df2cc32d83456f4f2af2a0e7bfa3dce51f8208fbe3ab0e0";
		
		 int id = given()
		 	.headers("Authorization","Bearer "+bearerToken)
		 	.contentType("application/json")
		 	.body(data.toString())
		
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		 
		 System.out.println("generated id is :"+id);
		 
		 context.setAttribute("user_id", id);  // it will make id make availabe to other class
		 //context.getSuite().setAttribute("user_id", id);  //suite level variable
				
		
	}
	
}
