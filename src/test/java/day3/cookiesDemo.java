package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookiesDemo {

	//@Test(priority = 1)
	void testCookies()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC","AUEFqZfL_LXJiMDHOBNIpUwxKaWRvSLK78xdfydd20Lmc3Qgykgb1vOVJA")
			.log().all();
		
		
	}
	
	@Test(priority = 2)
	void getCookiesInfo()
	{
		
		Response res =given()
		
		.when()
			.get("https://www.google.com/");
		
		//get single cookies info
		String cookie_value = res.getCookie("AEC");
		System.out.println("value of Cookie is --->"+cookie_value);
		
		//get all the cookies generated info
		Map<String,String>cookies_values = res.getCookies();
		
		//System.out.println(cookies_values.keySet());  //keyset give only keys
		
		for(String k:cookies_values.keySet())
		{
			String cookies_value = res.getCookie(k);
			System.out.println(k+"    " +cookies_value );
		}
				
		
		
	}
	
}
