package API.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.auth.AUTH;

import Login_access.login_token_access;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class member_Endpoints {
	
	public static Response list_members(int page_number, int page_Size)
	{
		Response response = given()
		.auth().oauth2(login_token_access.token)
		.accept(ContentType.JSON)
		.queryParam("page_num", page_number)
		.queryParam("page_size", page_Size)
		
		.when()
			.get(api_Routes.Get_list_member);
		
		return response;
		
	}
	
	
	public static Response view_members(int ID)	
	{
		Response response = given()
		.auth().oauth2(login_token_access.token)
		.accept(ContentType.JSON)
		.queryParam("id", ID)
		
		.when()
			.get(api_Routes.Get_view_member);
		
		return response;
		
	}

}
