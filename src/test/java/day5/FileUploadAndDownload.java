package day5;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {
	
	//@Test(priority = 1)
	void singleFileUpload()
	{
		File myfile = new File("C:\\Users\\saroj.poudel\\Documents\\sample.pdf");
		given()
			.multiPart("file",myfile)  //form data
			.contentType("multipart/form-data")
		
		
		.when()
		  .post("https://api.escuelajs.co/api/v1/files/upload")
		
		
		.then()
		 .statusCode(201)
		 .log().all();
		
		
	}
	
	
	
	//@Test(priority = 2)
	void multipleFileUpload()
	{
		File myfile1 = new File("C:\\Users\\saroj.poudel\\Documents\\sample.pdf");
		File myfile2 = new File("C:\\Users\\saroj.poudel\\Documents\\dummy.pdf");
		given()
			.multiPart("files",myfile1)  //form data
			.multiPart("files",myfile2)
			.contentType("multipart/form-data")
		
		
		.when()
		  .post("https://api.escuelajs.co/api/v1/files/upload")  //user api which can upload multiple file
		
		
		.then()
		 .statusCode(201)
		 .log().all();
		
		
	}
	@Test(priority = 3)
	void fileDownload()
	{
		given()
			
		
		.when()
			.get("https://api.escuelajs.co/api/v1/files/597c.pdf")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
