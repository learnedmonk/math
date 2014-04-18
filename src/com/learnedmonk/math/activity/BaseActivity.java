package com.learnedmonk.math.activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public abstract class BaseActivity extends ActionBarActivity{
	
	
	protected void onCreate(Bundle savedInstanceState, boolean fullScreen) {
		super.onCreate(savedInstanceState);
		if(fullScreen){
			ActionBar actionBar = getSupportActionBar();
			if(actionBar!=null)
				actionBar.hide();
		}
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	}
	
	protected void showConfirmBox(String title, String msg, 
			DialogInterface.OnClickListener onYes, DialogInterface.OnClickListener onNo){
		
		new AlertDialog.Builder(this)
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle(title)
	        .setMessage(msg)
	        .setPositiveButton("Yes", onYes)
	        .setNegativeButton("No", onNo)
	        .show();

	}
}
