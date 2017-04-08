package com.example.oxygen;

import cn.bmob.v3.BmobUser;
import BmobBean.MyUser;
import android.app.Fragment;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class MyspaceFragment extends Fragment{

	private MyUser userinfo;
	private TextView username_tx;
	private TextView occupation_tx;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View myspaceLayout = inflater.inflate(R.layout.myspace_layout,container,false);
		userinfo = BmobUser.getCurrentUser(MyUser.class);
		username_tx = (TextView)myspaceLayout.findViewById(R.id.My_username);
		occupation_tx = (TextView)myspaceLayout.findViewById(R.id.My_occupation);
		username_tx.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
		username_tx.getPaint().setAntiAlias(true);
		username_tx.setText((String)BmobUser.getObjectByKey("username"));
		
		occupation_tx.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
		occupation_tx.getPaint().setAntiAlias(true);
		occupation_tx.setText((String)BmobUser.getObjectByKey("occupation"));
		
		return myspaceLayout;
	}
}
