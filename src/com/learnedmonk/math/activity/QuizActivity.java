package com.learnedmonk.math.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.learnedmonk.math.Dao;
import com.learnedmonk.math.Dao.Q;
import com.learnedmonk.math.R;
import com.learnedmonk.math.db.DB;

public class QuizActivity extends BaseActivity{
	
	private DB db = null;
	
	private TextView screen,question;
	Q[] qs = null;
	int idx = 0;
	double ts;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		db = new DB(getBaseContext());
		
		setContentView(R.layout.quiz_on);
		screen = (TextView) findViewById(R.id.screen);
		question = (TextView) findViewById(R.id.question);
		
		//TODO implement levels
		
		qs = Dao.generate(0, 10);
		question.setText(qs[idx].exp);
		ts = System.currentTimeMillis();
		
		
	}
	
	public void onClick(View view){
		Button b = (Button)view;
		String txt = b.getText().toString();
		if ("DEL".equals(txt)){
			String cur = screen.getText().toString();
			int len = cur.length();
			if ( len > 0 ){
				screen.setText(cur.substring(0, len-1));
			}
			
		}else{
			int id = Integer.parseInt(b.getText().toString());
			String val = screen.getText().toString()+id;
			screen.setText(val);
			
			if (!(qs[idx].val+"").startsWith(val)){
				Vibrator v = (Vibrator) getBaseContext().getSystemService(Context.VIBRATOR_SERVICE);
				 // Vibrate for 200 milliseconds
				 v.vibrate(200);
				 
				Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
				screen.startAnimation(shake);
				
			}else{
				if (Integer.parseInt(val) == qs[idx].val){
					screen.setText("");
					idx++;
					if ( idx == qs.length){
						// all done.
						question.setText("time: "+(System.currentTimeMillis() - ts)+" ms");
					}else{
						// next question
						question.setText(qs[idx].exp);
						
					}
				}
			}
			
		}
		
	}

}
