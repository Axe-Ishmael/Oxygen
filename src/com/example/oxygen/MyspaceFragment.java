package com.example.oxygen;

import android.app.Fragment;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class MyspaceFragment extends Fragment{

	private TextView username_tx;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View myspaceLayout = inflater.inflate(R.layout.myspace_layout,container,false);
		username_tx = (TextView)myspaceLayout.findViewById(R.id.My_username);
		username_tx.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
		username_tx.getPaint().setAntiAlias(true);
		username_tx.setText("Fxxk.....");
		return myspaceLayout;
	}
}
