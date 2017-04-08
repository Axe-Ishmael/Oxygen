package com.example.oxygen;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import BmobBean.MyUser;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	private EditText username_ed,userpassword_ed;
	private Button  login;
	private Intent intent;
	private Intent intent2;
	private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "24212c11f594d21b0b47faa0da0652de");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        username_ed = (EditText)findViewById(R.id.username_ed);
        userpassword_ed = (EditText)findViewById(R.id.userpassword_ed);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(mFadeListener);
        textView = (TextView)findViewById(R.id.zhuce);
        textView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				// TODO Auto-generated method stub
				intent2  = new Intent(MainActivity.this,Zhuce.class);
	            startActivity(intent2); 
				Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
			}
		});
    }
    
   
    
    private OnClickListener mFadeListener = new OnClickListener() {  
        public void onClick(View v) {
        	String username = username_ed.getText().toString();
        	String userpassword = userpassword_ed.getText().toString();
        	if(username.equals("")||userpassword.equals(""))
        	{
        		Toast.makeText(MainActivity.this, "请输入用户名和密码", 1000).show();
        	}
        	MyUser user = new MyUser();
        	user.setUsername(username);
        	user.setPassword(userpassword);
        	user.login(new SaveListener<MyUser>() {

				@Override
				public void done(MyUser arg0, BmobException arg1) {
					// TODO Auto-generated method stub
					if(arg1 == null ){
						Toast.makeText(MainActivity.this, "成功登陆", 1000).show();
						intent  = new Intent(MainActivity.this,Publish.class);
			            startActivity(intent);  
			            overridePendingTransition(R.anim.fade, R.anim.hold);  
					}else{
						Toast.makeText(MainActivity.this, "登录失败", 1000).show();
					}
				}
			});
        	
        	/*
        	intent  = new Intent(MainActivity.this,Publish.class);
            startActivity(intent);  
            overridePendingTransition(R.anim.fade, R.anim.hold);  
            */
        }  
    };  
    
   
    

}
