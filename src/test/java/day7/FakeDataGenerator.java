package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
	
	@Test
	void testGenerateDummyData()
	{
		
		Faker faker = new Faker();
		
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String username = faker.name().username();
		String password =faker.internet().password();
		
		String email = faker.internet().safeEmailAddress();
		
		System.out.println("first-name:"+firstname);
		System.out.println("last-name:"+lastname);
		System.out.println("user-name:"+username);
		System.out.println("password:"+password);
		System.out.println("email"+email);
		
		
	}

}
