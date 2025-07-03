package API.endpoints;

public class api_Routes {
	
	
	public static String Base_URI = "https://tfc-api.tech-active.com";
	
	
	//------------------------------ Member API's  ----------------------------------------
 	
	public static String Get_list_member = Base_URI+"/members/list-members?page_num=1&page_size=10";
	public static String Get_view_member = Base_URI+"/members/view-member-profile?id=218";
	public static String update_member_role = Base_URI+"/members/update-member-role";
	
	// ----------------------------- Mini club ---------------------------------------------
	
	public static String create_miniclub = Base_URI+"/miniclub/create-mini-club";
	public static String list_miniclub = Base_URI+"/miniclub/list-miniclubs";
	public static String Get_miniclubdetails = Base_URI+"/miniclub/get-miniclub-detail";
	public static String update_miniclub = Base_URI+"/miniclub/update-miniclub";
	
	public static String remove_miniclub_member = Base_URI+"/miniclub/remove-mini-club-members";  // api fails
	
	
	public static String add_member = Base_URI+"/miniclub/add-members";  // api fails
	
	// ---------------------------- Incentives pending -----------------------------------------------
	
	public static String create_incentive = Base_URI+"/incentive/create-incentive";
	public static String list_incentives = Base_URI+"/incentive/list-incentive?page_num=1&page_size=10";
	public static String Get_incentivesDetails = Base_URI+"/incentive/get-incentive-detail?incentive_id=15";                                                                                    
	public static String update_incentives = Base_URI+"/incentive/update-incentive";
	public static String delete_incentives = Base_URI+"/incentive/delete-incentive?incentive_id=4342&is_expired=false";
	
	
	
	
	
	
	
	
	


}
