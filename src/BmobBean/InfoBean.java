package BmobBean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class InfoBean extends BmobObject{

	private BmobFile picPath;
	private String info;
	private String uri;
	
	public InfoBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void InfoBean(String info,BmobFile file) {
		// TODO Auto-generated method stub

		this.info  = info;
		this.picPath = file;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public BmobFile getPicPath() {
		return picPath;
	}
	public void setPicPath(BmobFile picPath) {
		this.picPath = picPath;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
