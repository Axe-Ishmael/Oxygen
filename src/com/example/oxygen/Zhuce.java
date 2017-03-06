package com.example.oxygen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Zhuce extends Activity{

	private Button zcbutton;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhuce);
		zcbutton = (Button)findViewById(R.id.zhuce_button); 
		zcbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Zhuce.this, "×¢²á³É¹¦", Toast.LENGTH_SHORT).show();
				intent = new Intent(Zhuce.this,MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
