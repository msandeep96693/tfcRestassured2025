package API.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Multipart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Login_access.login_token_access;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class miniclub_Endpoints {
	
	public static Response createmininclub() throws JsonProcessingException
	{
		
		List<Map<String, Object>> newTags = Arrays.asList(
			    new HashMap<String, Object>() {{
			        put("tag_name", "test");
			        put("is_selected", true);
			    }},
			    new HashMap<String, Object>() {{
			        put("tag_name", "Solana");
			        put("is_selected", true);
			    }}
			);
		
		Response response = given()
				.auth().oauth2(login_token_access.token)
				.accept(ContentType.JSON)
				.contentType(ContentType.MULTIPART)
				.multiPart("club_name", "Create miniclub")
				.multiPart("club_details" , "mini club details")
				.multiPart("club_access", "3")
				.multiPart("club_type", "1")
				.multiPart("global_tags" , "[1,2,3]")
				.multiPart("new_tags",new ObjectMapper().writeValueAsString(newTags))
				.multiPart("club_members", "[201,218]")  // stringified array
			    .multiPart("club_moderators", "[201,218]")
				
			    .when()
					.post(api_Routes.create_miniclub);
		
		return response;
	}
	
	public static Response listofminiclub(int pagenum, int pagesize)
	{
		Response response = given()
				.auth().oauth2(login_token_access.token)
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.queryParam("page_num", pagenum)
				.queryParam("page_size", pagesize)
				
			.when()
				.get(api_Routes.list_miniclub);
				
		return response;
		
	}
	
	public static Response miniclubdetails(int miniclubID)
	{
		Response response = given()
				.auth().oauth2(login_token_access.token)
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.queryParam("mini_club_id", miniclubID)
				
				.when()
					.get(api_Routes.Get_miniclubdetails);
				
		return response;
		
	}
	
	public static Response updateminiclub(int miniclubid) throws JsonProcessingException
	{
		List<Map<String, Object>> newTags2 = Arrays.asList(
			    new HashMap<String, Object>() {{
			        put("tag_name", "Modern");
			        put("is_selected", true);
			    }},
			    new HashMap<String, Object>() {{
			        put("tag_name", "miniclub");
			        put("is_selected", true);
			    }}
			);
		
		File imagefile = new File("/home/active34/photos/security.jpeg");
		File clubicon = new File("/home/active34/photos/happy.png");
		
		Response response = given()
				.auth().oauth2(login_token_access.token)
				.accept(ContentType.JSON)
				.contentType(ContentType.MULTIPART)
				.multiPart("mini_club_id",miniclubid)
				.multiPart("club_name","create miniclub")
				.multiPart("club_details","create miniclub details")
				.multiPart("club_access","1")
				.multiPart("club_type","2")
				.multiPart("global_tags","[1,2,3,13082,13083]")
				.multiPart("new_tags",new ObjectMapper().writeValueAsString(newTags2))
				.multiPart("club_members","[201,218]")
				.multiPart("club_moderators", "[201,218]")
				.multiPart("file", imagefile)
				.multiPart("miniclub_icon", clubicon)
				
			.when()
				.put(api_Routes.update_miniclub);
				
		return response;
		
	}

}


