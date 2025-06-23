package API.Payload;

import java.util.List;

public class createminiclubgetset {
	
	private String club_name;
	private String club_details;
	private int club_access;
	private int club_type;
	private List<String> global_tags;
	private List<String> new_tags;
	private List<String> club_members;
	private List<String> club_moderators;
	
	
	
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	
	public String getClub_details() {
		return club_details;
	}
	public void setClub_details(String club_details) {
		this.club_details = club_details;
	}
	public int getClub_access() {
		return club_access;
	}
	public void setClub_access(int club_access) {
		this.club_access = club_access;
	}
	public int getClub_type() {
		return club_type;
	}
	public void setClub_type(int club_type) {
		this.club_type = club_type;
	}
	public List<String> getGlobal_tags() {
		return global_tags;
	}
	public void setGlobal_tags(List<String> global_tags) {
		this.global_tags = global_tags;
	}
	public List<String> getNew_tags() {
		return new_tags;
	}
	public void setNew_tags(List<String> new_tags) {
		this.new_tags = new_tags;
	}
	public List<String> getClub_members() {
		return club_members;
	}
	public void setClub_members(List<String> club_members) {
		this.club_members = club_members;
	}
	public List<String> getClub_moderators() {
		return club_moderators;
	}
	public void setClub_moderators(List<String> club_moderators) {
		this.club_moderators = club_moderators;
	}
	
	
	
	

}
