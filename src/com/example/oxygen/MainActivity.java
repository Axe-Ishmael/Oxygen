package com.example.oxygen;

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
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	private Button  login;
	private Intent intent;
	private Intent intent2;
	private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
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
        	intent  = new Intent(MainActivity.this,Publish.class);
            startActivity(intent);  
            overridePendingTransition(R.anim.fade, R.anim.hold);  
        }  
    };  
    
   
    

}
