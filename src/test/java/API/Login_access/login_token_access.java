package API.Login_access;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class login_token_access 
{
	public Response response;
	public static String token;
	
	@Test
	public static void Loginaccess_token()
	{
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("email", "admin@foundry.com");
		hashmap.put("password", "1234");
		hashmap.put("web3auth", "false");
		hashmap.put("referral_code", "string");
		hashmap.put("name", "string");
		hashmap.put("type_of_login", "string");
		hashmap.put("verifier", "string");
		hashmap.put("verifier_id", "string");
		hashmap.put("remember_me", "true");
		hashmap.put("bot_id", "0");
		hashmap.put("wallet_address", "string");
		
		Response response = given()
//					.contentType(ContentType.JSON)
					.contentType("application/json")
					.body(hashmap)
		
		.when()
			.post("https://tfc-api.tech-active.com/profile/login");
		
		response.then()
			.statusCode(200)
			.log().all();
			
			
			token = response.jsonPath().getString("details.access_token");
			System.out.println("Token :- "+token);
			
	}

	
	}
	



	
	
	
	