package com.example.oxygen;

import com.squareup.picasso.Picasso;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Neirong extends Activity{

	private ImageView imageview;
	private TextView textview;
	private String contnetText;
	private Uri imageUri;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neirong);
		ActionBar actionBar = getActionBar();  
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    imageview = (ImageView)findViewById(R.id.nr_pic);
	    textview = (TextView)findViewById(R.id.nr_text);
	    Intent intent  =getIntent();
	    contnetText = intent.getStringExtra("ContentText");
	    imageUri = Uri.parse(intent.getStringExtra("ImageUri"));
	    textview.setText(contnetText);
	    Picasso.with(Neirong.this).load(imageUri).config(Bitmap.Config.RGB_565).into(imageview);
	   // imageview.setPivotX(imageview.getWidth()/2);
	    //imageview.setPivotY(imageview.getPivotY()/2);
	   // imageview.setRotation(90);//设置图像的旋转
	    
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.actionbar_overflow, menu);
    	return super.onCreateOptionsMenu(menu);
    	
    };
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	 switch (item.getItemId()) {  
    	    case android.R.id.home:  
    	        finish();  
    	        return true;  
    	   default:
    		   return super.onOptionsItemSelected(item);
    	    }  
    	
    }
}
