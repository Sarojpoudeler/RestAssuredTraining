package day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authencitations {
	
	
	//@Test(priority = 1)
	void testBasicAuthentications()
	{
		given()
			.auth().basic("postman", "password")
		
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	
	//@Test(priority = 2)
	void testDigestAuthentications()
	{
		given()
			.auth().digest("postman", "password")
		
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	//@Test(priority = 3)
	void testPreemptiveAuthentications()
	{
		given()
			.auth().preemptive().basic("postman", "password")
		
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	//@Test(priority = 4)
	void testBearerTokenAuthentication()
	{
		
		String bearerToken = "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";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
		
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//@Test(priority = 5)
	void testOauth1Authentication()
	{
		
		given()
			.auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrate")
		
		.when()
		  .get("url")
		
		.then()
			.statusCode(200);
	}
	
	
	//@Test(priority = 6)
	void testOauth2Authentication()
	{
		
		given()
			.auth().oauth2("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")
		
		.when()
		  .get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 7)
	void testAPIKeyAuthentication()
	{
		
		given()
			.queryParam("appid", "eli0VGxVI4Ef1dBgM01E4MK1IwewvA1rcSlr") //appid is apikey
		
		.when()
		  .get("https://openweathermap.org/")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	

}
