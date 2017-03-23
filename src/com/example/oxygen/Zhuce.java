package com.example.oxygen;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import BmobBean.MyUser;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Zhuce extends Activity{
	
	private static String Occupation,selectText;
	private EditText username_ed,userpassword_ed;
	private RadioGroup rdg;
	private RadioButton rbtn,rbtn_stu,rbtn_sal;	
	private Button zcbutton;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhuce);
		username_ed = (EditText)findViewById(R.id.usersname_zhuce);
		userpassword_ed = (EditText)findViewById(R.id.userspassword_zhuce);
		zcbutton = (Button)findViewById(R.id.zhuce_button); 
		rdg = (RadioGroup)findViewById(R.id.rgroup);
		rdg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				Occupation = selectRadioBtn();
			}
		});
		
		zcbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String user_name = username_ed.getText().toString();
				//Log.d("Username",user_name);
				String user_password = userpassword_ed.getText().toString();
				//Log.d("UserPassword",user_password);
				String occupation = Occupation;
				//Log.d("Occupation",occupation);
				if(user_name.equals("")||user_password.equals(""))
				{
					Toast.makeText(Zhuce.this, "请输入用户名和密码", 1000).show();
				}
					MyUser user = new MyUser();
					user.setUsername(user_name);
					user.setPassword(user_password);
					user.setOccupation(occupation);
					
					user.signUp(new SaveListener<MyUser>() {

						@Override
						public void done(MyUser arg0, BmobException arg1) {
							// TODO Auto-generated method stub
							if(arg1 == null){
								Toast.makeText(Zhuce.this, "注册成功", 1000).show();
								intent = new Intent(Zhuce.this,MainActivity.class);
								startActivity(intent);
							}
							else{
								Log.d("TAG",arg1.toString());
								Toast.makeText(Zhuce.this, "注册失败，请检查设置", 1000).show();
							}
						}
					});
			}
		});
	}
	
	 private String selectRadioBtn(){
		    rbtn = (RadioButton)findViewById(rdg.getCheckedRadioButtonId());
		    selectText = rbtn.getText().toString();
		    return selectText;
		    }
}
