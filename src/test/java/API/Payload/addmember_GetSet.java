package API.Payload;

import java.util.List;

public class addmember_GetSet
{
	
	private int mini_club_id;
	private List<String> club_members;
	
	
	public int getMini_club_id() {
		return mini_club_id;
	}
	public void setMini_club_id(int mini_club_id) {
		this.mini_club_id = mini_club_id;
	}
	public List<String> getClub_members() {
		return club_members;
	}
	public void setClub_members(List<String> club_members) {
		this.club_members = club_members;
	}
}
