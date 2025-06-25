package API.Test;


import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import API.endpoints.miniclub_Endpoints;
import Login_access.login_token_access;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class miniclub_Test extends login_token_access {
	
	int clubId;
	
	
//	@Test(priority = 1)
	public void create_miniclub() throws JsonProcessingException
	{
		Response response = miniclub_Endpoints.createmininclub();
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);

	}
	
	@Test(priority = 2)
	public void list_miniclub()
	{
	      Response response = miniclub_Endpoints.listofminiclub(1, 10);
	      response.then().log().all();
	      
	        JSONObject json = new JSONObject(response.asString());
	        JSONArray jsonArraydata = json.getJSONObject("details").getJSONArray("data");
	        clubId = jsonArraydata.getJSONObject(0).getInt("id");
	        
	        
	      Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority = 3)
	public void get_miniclubdetails()
	{
		Response response = miniclub_Endpoints.miniclubdetails(clubId);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority = 4)
	public void update_miniclub() throws JsonProcessingException
	{
		Response response = miniclub_Endpoints.updateminiclub(clubId);
		response.then().log().all();
		
//		validation of response message using json path
		JsonPath jspath = response.jsonPath();
		String Message = jspath.getString("message");
		
		System.out.println("Message :- "+ Message);
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	

}
