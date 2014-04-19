package com.learnedmonk.math.activity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.learnedmonk.math.R;

public abstract class BaseActivity extends ActionBarActivity{
	
	LayoutInflater mInflater;
	
	
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
	
	protected void showPopupMessage(String msg){
		Dialog dialog = new Dialog(this);
		dialog.setCanceledOnTouchOutside(true);
		mInflater = LayoutInflater.from(getApplicationContext());
		TextView view = (TextView) mInflater.inflate(R.layout.popup, null);
		view.setText(msg);
		dialog.setContentView(view);
		dialog.show();
	}
}
