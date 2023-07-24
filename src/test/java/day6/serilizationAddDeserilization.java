package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import day2.pojo_PostRequest;

public class serilizationAddDeserilization {

	
	//Pojo to Json (serilization process)
	@Test
	void convertPOjo2Json() throws JsonProcessingException
	{
		//created java object using pojo class
		pojo_PostRequest data = new pojo_PostRequest();
		
		data.setName("saroj");
		data.setJob("developer");
		
		//convert java object to json object(serilization)
		ObjectMapper objMapper = new ObjectMapper();
		String jsondata = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);
		
		
	}
	
	//Pojo to Json (serilization process)
		@Test
		void convertJson2Pojo() throws JsonProcessingException
		{
			String jsondata = "{\r\n"
					+ "  \"name\" : \"saroj\",\r\n"
					+ "  \"job\" : \"developer\"\r\n"
					+ "}";
					
					
		//convert json data to pojo object
		ObjectMapper objMapper = new ObjectMapper();
		pojo_PostRequest userpojo =	objMapper.readValue(jsondata, pojo_PostRequest.class);
			
		System.out.println("Name:"+userpojo.getName());
		
		System.out.println("Job:"+userpojo.getJob());
		
			
		}
	
	
}
