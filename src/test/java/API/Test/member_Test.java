package API.Test;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import API.Payload.member_role_GetSet;
import API.endpoints.member_Endpoints;
import Login_access.login_token_access;
import io.restassured.response.Response;

public class member_Test extends login_token_access {
	
	member_role_GetSet member_role;
	int Member_id;
	
	
	public void Postmember_role()
	{
		member_role = new member_role_GetSet();
		member_role.setMember_id(211);
		member_role.setRole_ids(Arrays.asList());
	}

	
	
	@Test(priority = 1)
	public void Testlistofmember()
	{
		Response response = member_Endpoints.list_members(1, 10);
		response.then().log().all();
		
		JSONObject json = new JSONObject(response.asString());
		JSONArray JsonArrayData = json.getJSONObject("details").getJSONArray("details");
		Member_id = JsonArrayData.getJSONObject(1).getInt("member_id");
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority = 2)
	public void Testviewmember()
	{
		Response response = member_Endpoints.view_members(Member_id);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
	}
}
