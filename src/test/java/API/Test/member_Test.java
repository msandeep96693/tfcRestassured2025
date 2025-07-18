package API.Test;



import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import API.Login_access.login_token_access;
import API.Payload.member_role_GetSet;
import API.endpoints.member_Endpoints;
import io.restassured.response.Response;

public class member_Test extends login_token_access {
	
	public member_role_GetSet member_role;
	int Member_id;
	
	
	
	@Test(priority = 1)
	public void Testlistofmember()
	{
		Response response = member_Endpoints.list_members(1, 10);
		response.then().log().all();
		
		JSONObject json = new JSONObject(response.asString());
		JSONArray JsonArrayData = json.getJSONObject("details").getJSONArray("data");
		Member_id = JsonArrayData.getJSONObject(1).getInt("member_id");
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
//	@Test(priority = 2)
	public void Testviewmember()
	{
		Response response = member_Endpoints.view_members(Member_id);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
//	@Test(priority = 3)
	public void Testupdatemember()
	{
		member_role = new member_role_GetSet();
		member_role.setMember_id(229);
		member_role.setRole_ids("[2,3]");
		
		
		System.out.println("Payload data =="+ member_role);
		Response response = member_Endpoints.updatemember_role(member_role);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200, "Expected status 200 but got: " + response.getStatusCode());
	}
	
}
