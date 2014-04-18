package com.learnedmonk.math.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public abstract class BaseActivity extends Activity{
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	}
}
