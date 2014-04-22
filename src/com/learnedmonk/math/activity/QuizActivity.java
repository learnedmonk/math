package com.learnedmonk.math.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.learnedmonk.math.Dao;
import com.learnedmonk.math.Dao.Q;
import com.learnedmonk.math.R;
import com.learnedmonk.math.db.DB;

public class QuizActivity extends FragmentActivity{
	
	private static DB db = null;
	
	private QuizFragment qf;
	
	static Q[] qs = null;
	static int idx = 0;
	static double ts;
	
	public static class CounterFragment extends Fragment{
		
		TextView timerText;
		
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
		        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	        View out =  inflater.inflate(R.layout.quiz_start, container, false);
	        timerText = (TextView) out.findViewById(R.id.timer);
	        return out;
		}
	}
	
	public static class QuizFragment extends Fragment{
		
		TextView screen,question;
		
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
		        Bundle savedInstanceState) {
			
			View out =  inflater.inflate(R.layout.quiz_on, container, false);
			screen = (TextView) out.findViewById(R.id.screen);
			question = (TextView) out.findViewById(R.id.question);
			
			qs = Dao.generate(0, 10);
			question.setText(qs[idx].exp);
			ts = System.currentTimeMillis();
	       
	        return out;
	        
		}
		
	}
	
	public void onClick(View view){
		Button b = (Button)view;
		String txt = b.getText().toString();
		if ("DEL".equals(txt)){
			String cur = qf.screen.getText().toString();
			int len = cur.length();
			if ( len > 0 ){
				qf.screen.setText(cur.substring(0, len-1));
			}
			
		}else{
			int id = Integer.parseInt(b.getText().toString());
			String val = qf.screen.getText().toString()+id;
			qf.screen.setText(val);
			
			if (!(qs[idx].val+"").startsWith(val)){
				Vibrator v = (Vibrator) getBaseContext().getSystemService(Context.VIBRATOR_SERVICE);
				 // Vibrate for 200 milliseconds
				 v.vibrate(200);
				 
				Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
				qf.screen.startAnimation(shake);
				
			}else{
				if (Integer.parseInt(val) == qs[idx].val){
					qf.screen.setText("");
					idx++;
					if ( idx == qs.length){
						// all done.
						qf.question.setText("time: "+(System.currentTimeMillis() - ts)+" ms");
					}else{
						// next question
						qf.question.setText(qs[idx].exp);
						
					}
				}
			}
			
		}
		
	}
	
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		db = new DB(getBaseContext());
		
		setContentView(R.layout.quiz);
		
		if (savedInstanceState != null) {
            return;
        }
		
		final CounterFragment cf = new CounterFragment();
		cf.setArguments(getIntent().getExtras());
		
		getSupportFragmentManager().beginTransaction()
        .add(R.id.quiz_container, cf).commit();

		
		
		new CountDownTimer(4000, 1000) {
			
			

		     public void onTick(long millisUntilFinished) {
		    	 cf.timerText.setText(""+(millisUntilFinished / 1000));
		     }

		     public void onFinish() {
		    	 
		    	 FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		    	 qf = new QuizFragment();
		    	 transaction.replace(R.id.quiz_container, qf);
		    	 transaction.commit();
		    	 
		     }
		  }.start();
		
	}


}
