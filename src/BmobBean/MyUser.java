package BmobBean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

public class MyUser extends BmobUser{

	//private String user_name;
	//private String user_password;
	private String occupation;

	/*
	public String getUsername() {
		return user_name;
	}
	public void setUsername(String username) {
		this.user_name = username;
	}
	public String getUserpassword() {
		return user_password;
	}
	public void setPassword(String userpassword) {
		this.user_password = userpassword;
	}
	*/
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
}
