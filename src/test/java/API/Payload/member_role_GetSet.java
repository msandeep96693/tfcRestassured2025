package API.Payload;

import java.util.List;

public class member_role_GetSet 
{
	private int member_id;
	private String role_ids;
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	public  String getRole_ids() {
		return role_ids;
	}
	public void setRole_ids( String role_ids) {
		this.role_ids = role_ids;
	}
}
	


