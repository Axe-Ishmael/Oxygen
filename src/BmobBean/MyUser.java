package BmobBean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

public class MyUser extends BmobUser{

	
	private String occupation;

	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
}
