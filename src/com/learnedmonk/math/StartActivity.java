package com.learnedmonk.math;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class StartActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		
	}
	
	public void onClick(View v){
		Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	}
	
	public void quiz(View v){
		Intent intent = new Intent(this, QuizTimerActivity.class);
	    startActivity(intent);
	}

}
