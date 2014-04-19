package com.learnedmonk.math.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.learnedmonk.math.R;


public class MainActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState,true);
		setContentView(R.layout.main_layout);
		
	}
	
	public void practice(View v){
	//	Intent intent = new Intent(this, TablesActivity.class);
	//  startActivity(intent);
		View _v = findViewById(R.id.practice_tabs);
		View _lt = findViewById(R.id.level_tabs);
		_lt.setVisibility(View.GONE);
		if(_v.getVisibility()==View.GONE)
			_v.setVisibility(View.VISIBLE);
		else
			_v.setVisibility(View.GONE);
	}
	
	public void quiz(View v){
	//	Intent intent = new Intent(this, QuizTimerActivity.class);
	//  startActivity(intent);
		View _lt = findViewById(R.id.level_tabs);
		View _pt = findViewById(R.id.practice_tabs);
		_pt.setVisibility(View.GONE);
		if(_lt.getVisibility()==View.GONE)
			_lt.setVisibility(View.VISIBLE);
		else
			_lt.setVisibility(View.GONE);
	}
	
	public void practiceAction(View v){
		Intent intent =null;
		String tag = (String) v.getTag();
		if(tag.equals("TAB")){
			intent = new Intent(this, TablesActivity.class);
		}else if(tag.equals("SQCUB")){
			intent = new Intent(this, PowersActivity.class);
		}
		if(intent!=null)
			startActivity(intent);
	}
	public void quizAction(View v){
		Intent intent =null;
		String tag = (String) v.getTag();
		
		if(true){
			intent = new Intent(this, QuizTimerActivity.class);
			
		}
		if(intent!=null)
			startActivity(intent);
	}
	
	
	
	public void onBackPressed() {
		showConfirmBox("Do you want to Exit", " Please Confirm", new OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				finish();
				
			}
		}, null);
	}
	
	

}
