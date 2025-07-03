package API.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import API.Login_access.login_token_access;
import API.Payload.addmember_GetSet;
import API.Utilities.MyListener;
import API.endpoints.miniclub_Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


@Listeners(MyListener.class)
public class miniclub_Test extends login_token_access {
	
	int clubId;
	int clubdetailId;
	JSONObject memberid;
	List<String> memberIdList;
	addmember_GetSet addmember;
	
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
	        clubId = jsonArraydata.getJSONObject(1).getInt("id");
//	        JSONObject firstDataObj = jsonArraydata.getJSONObject(0);
//	        JSONArray membersDataArray = firstDataObj.getJSONArray("members_data");
//	        
//	        memberIdList = new ArrayList<>();
//	        
//	        for(int i = 0; i < membersDataArray.length(); i++)
//	        {
//	        	JSONObject memberid = membersDataArray.getJSONObject(i);
//	        	 String member = memberid.getString("members_data");
//	        	 System.out.println("Member ID :- "+member.toString());
//	        	 
//	        	 memberIdList.add(member);
//	        	 
////	        	System.out.println("Member Id :-"+ i + " "+ memberid.toString());
//	        }
	        
	        
	      Assert.assertEquals(response.statusCode(), 200);
	}
	
//	@Test(priority = 3)
	public void get_miniclubdetails()
	{
	    
		Response response = miniclub_Endpoints.miniclubdetails(clubId);
		response.then().log().all();
		
		 JSONObject json = new JSONObject(response.asString());
		 clubdetailId = json.getJSONObject("details").getInt("id");
		 
		Assert.assertEquals(response.statusCode(), 200);
	}
	
//	@Test(priority = 4)
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
	
//	@Test(priority = 5)
	public void add_member()
	{
		System.out.println("CLUB ID 1:- "+ clubId);
		addmember = new addmember_GetSet();
		addmember.setMini_club_id(4452);
		addmember.setClub_members("[201,218,207]");
		
		Response response = miniclub_Endpoints.addmemberintominiclub(addmember);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
//	@Test(priority = 6)
	public void remove_miniclubmember()
	{
     	Response response = miniclub_Endpoints.removeminiclubmembers();
     	response.then().log().all();
     	
     	Assert.assertEquals(response.statusCode(), 200);
	}
	

}
