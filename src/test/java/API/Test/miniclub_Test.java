package API.Test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import API.Payload.createminiclubgetset;
import API.endpoints.miniclub_Endpoints;
import Login_access.login_token_access;
import io.restassured.response.Response;

public class miniclub_Test extends login_token_access {
	
	createminiclubgetset miniclub;
	
	
	public void Postcreate_miniclub() 
	{
		miniclub = new createminiclubgetset();
		miniclub.setClub_name("Create mini club");
		miniclub.setClub_details("Mini club details");
		miniclub.setClub_access(3);
		miniclub.setClub_type(1);
		miniclub.setGlobal_tags(Arrays.asList());
		miniclub.setNew_tags(Arrays.asList());
		miniclub.setClub_members(Arrays.asList());
		miniclub.setClub_moderators(Arrays.asList());
		
	}
	
	@Test
	public void create_miniclub()
	{
		Response response = miniclub_Endpoints.createminiclub(miniclub);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	

}
