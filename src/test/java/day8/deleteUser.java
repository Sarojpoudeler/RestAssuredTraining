package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser {
	
	@Test
	void test_deleteUser(ITestContext context)
	{
		
		int id = (Integer) context.getAttribute("user_id");
		//int id = (Integer) context.getSuite().getAttribute("user_id"); //suite level data fetching from create
		String bearerToken = "aff088651bc622c65df2cc32d83456f4f2af2a0e7bfa3dce51f8208fbe3ab0e0";
		
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
		
		
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(204)
			.log().all();
		
	}

}
