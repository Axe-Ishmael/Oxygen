package com.example.oxygen;

import com.king.photo.activity.Fabu;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Publish extends Activity implements OnClickListener{

	private StudentFragment studentFragment;
	private SaleFragment saleFragment;
	private MyspaceFragment myspaceFragment;
	
	private View studentLayout;
	private View saleLayout;
	private View myspaceLayout;
	
	private ImageView studentImage;
	private ImageView saleImage;
	private ImageView myspaceImage;
	
	private TextView studentText;
	private TextView saleText;
	private TextView myspaceText;
	
	private FragmentManager fragmentManager;
	
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.publish_tab);
		//ActionBar actionBar = getActionBar();  
	    //actionBar.setDisplayHomeAsUpEnabled(true);
		initViews();
		fragmentManager = getFragmentManager();
		setTabSelection(0);
	}
	
	private void initViews(){
		studentLayout = findViewById(R.id.student_layout);
		saleLayout = findViewById(R.id.sale_layout);
		myspaceLayout = findViewById(R.id.myspace_layout);
		studentImage = (ImageView)findViewById(R.id.student_image);
		saleImage = (ImageView)findViewById(R.id.sale_image);
		myspaceImage =(ImageView)findViewById(R.id.myspace_image);
		studentText = (TextView)findViewById(R.id.student_text);
		saleText = (TextView)findViewById(R.id.sale_text);
		myspaceText = (TextView)findViewById(R.id.myspace_text);
		
		studentLayout.setOnClickListener(this);
		saleLayout.setOnClickListener(this);
		myspaceLayout.setOnClickListener(this);
	}
	
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.student_layout:
			setTabSelection(0);
			break;
		case R.id.sale_layout:
			setTabSelection(1);
			break;
		case R.id.myspace_layout:
			setTabSelection(2);
			break;

		default:
			break;
		}
		
	}
	
	private void setTabSelection(int index){
		clearSelection();
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		hideFragments(transaction);
		
		switch (index) {
		case 0:
			studentImage.setImageResource(R.drawable.student_selected);
			studentText.setTextColor(Color.WHITE);
			if(studentFragment == null){
				studentFragment = new StudentFragment();
				transaction.add(R.id.content, studentFragment);
			}else{
				transaction.show(studentFragment);
			}
			break;
		case 1:
			saleImage.setImageResource(R.drawable.sale_selected);
			saleText.setTextColor(Color.WHITE);
			if(saleFragment == null){
				saleFragment = new SaleFragment();
				transaction.add(R.id.content, saleFragment);
			}else{
				transaction.show(saleFragment);
			}
			break;
		case 2:
			myspaceImage.setImageResource(R.drawable.myspace_selected);
			myspaceText.setTextColor(Color.WHITE);
			if(myspaceFragment == null){
				myspaceFragment = new MyspaceFragment();
				transaction.add(R.id.content, myspaceFragment);
			}else{
				transaction.show(myspaceFragment);
			}
			break;

		default:
			break;
		}
		transaction.commit();
	}
	
	private void clearSelection(){
		studentImage.setImageResource(R.drawable.student_unselected);
		studentText.setTextColor(Color.parseColor("#82858b"));
		saleImage.setImageResource(R.drawable.sale_unselected);
		saleText.setTextColor(Color.parseColor("#82858b"));
		myspaceImage.setImageResource(R.drawable.myspace_unselected);
		myspaceText.setTextColor(Color.parseColor("#82858b"));
	}
	
	private void hideFragments(FragmentTransaction transaction){
		if(studentFragment != null){
			transaction.hide(studentFragment);
		}
		
		if(saleFragment != null){
			transaction.hide(saleFragment);
		}
		
		if(myspaceFragment != null){
			transaction.hide(myspaceFragment);
		}
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
	    case R.id.fabu_actionbar:
	    	intent = new Intent(Publish.this,Fabu.class);
	    	startActivity(intent);
	        return true;  
	   default:
		   return super.onOptionsItemSelected(item);
	    }  
	
}
	
}
