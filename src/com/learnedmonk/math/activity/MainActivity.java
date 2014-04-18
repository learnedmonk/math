package com.learnedmonk.math.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.learnedmonk.math.R;


public class MainActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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

}
