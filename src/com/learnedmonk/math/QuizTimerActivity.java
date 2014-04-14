package com.learnedmonk.math;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class QuizTimerActivity extends Activity{
	
	private TextView timerText;
	private QuizTimerActivity self;
	
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.quiz_start);
		
		self = this;
		
		timerText = (TextView) findViewById(R.id.timer);
		
		new CountDownTimer(4000, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	 timerText.setText(""+(millisUntilFinished / 1000));
		     }

		     public void onFinish() {
		    	 Intent intent = new Intent(self, QuizActivity.class);
		    	 startActivity(intent);
		     }
		  }.start();
		
	}


}
