package com.learnedmonk.math.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public abstract class BaseActivity extends Activity{
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
