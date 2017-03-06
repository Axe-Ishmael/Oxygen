package com.example.oxygen;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Neirong extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neirong);
		ActionBar actionBar = getActionBar();  
	    actionBar.setDisplayHomeAsUpEnabled(true);
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
