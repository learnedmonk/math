package com.learnedmonk.math.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.learnedmonk.math.R;
import com.learnedmonk.math.db.DB;

public class QuizActivity extends BaseActivity{
	
	private DB db = null;
	
	private TextView screen;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState,true);
		
		
		db = new DB(getBaseContext());
		
		if ( db.getLevel() == 0 ){
			
			setContentView(R.layout.quiz_on);
			screen = (TextView) findViewById(R.id.screen);
			
		}else{
			/* show levels list view TODO*/
			
			setContentView(R.layout.quiz_on);
			screen = (TextView) findViewById(R.id.screen);
			
		}
		
	}
	
	public void onClick(View view){
		Button b = (Button)view;
		int id = Integer.parseInt(b.getText().toString());
		screen.setText(screen.getText().toString()+id);
	}

}
