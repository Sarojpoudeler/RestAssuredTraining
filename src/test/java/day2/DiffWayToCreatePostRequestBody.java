package day2;


import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DiffWayToCreatePostRequestBody {
	

	//using hashmap
	//@Test(priority = 1)
	 void testPostUsingHashMap()
	{
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			
		
		.then()
			.statusCode(201)
			.body("name",equalTo("morpheus"))
			.body("job",equalTo("leader"))
			.log().all();
		
	
	}
	 
	 //using json method
	
	//@Test(priority = 1)
	 void testPostUsingJsonLibrary()
	{
		JSONObject data = new JSONObject();
		
		data.put("name", "saroj");
		data.put("job", "engineer");
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://reqres.in/api/users")
			
		
		.then()
			.statusCode(201)
			.body("name",equalTo("saroj"))
			.body("job",equalTo("engineer"))
			.log().all();
		
	
	}
	
	 //using pojo class
	//@Test(priority = 1)
	 void testPostUsingPOJO()
	{
		pojo_PostRequest data = new pojo_PostRequest();
		
		data.setName("saroj");
		data.setJob("developer");
		
		
		given()  
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			
		
		.then()
			.statusCode(201)
			.body("name",equalTo("saroj"))
			.body("job",equalTo("developer"))
			.log().all();
		
	
	}
	
	 //post request using external json file
	@Test(priority = 1)
	 void testPostUsingExternalJsonFile() throws FileNotFoundException
	{
		
		File f = new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://reqres.in/api/users")
			
		
		.then()
			.statusCode(201)
			.body("name",equalTo("saroj"))
			.body("job",equalTo("QA"))
			.log().all();
		
	
	}
	
	

}
