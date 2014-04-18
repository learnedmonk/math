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
	
	public void onClick(View v){
		Intent intent = new Intent(this, TablesActivity.class);
	    startActivity(intent);
	}
	
	public void quiz(View v){
		Intent intent = new Intent(this, QuizTimerActivity.class);
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
