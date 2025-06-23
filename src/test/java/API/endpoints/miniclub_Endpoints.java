package API.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import javax.management.InvalidApplicationException;

import API.Payload.createminiclubgetset;
import API.Payload.member_role_GetSet;
import Login_access.login_token_access;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class miniclub_Endpoints {
	
	public static Response createminiclub(createminiclubgetset payload)
	{
		System.out.println("Access token :- "+login_token_access.token);
		Response response	= given()
					 .auth().oauth2(login_token_access.token)
					 .accept(ContentType.JSON)
					 .body(payload)
					 	 
			.when()
				.post(api_Routes.create_miniclub);
			 
			return response;	
			 
	}

}


