package com.learnedmonk.math.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class DB{
	
	private SharedPreferences db =  null;
	

	public static enum Fields{
		LEVEL,
		TABLE_POSITION
	}	
	
	public DB(Context context) {		
		db = PreferenceManager.getDefaultSharedPreferences(context);	
	}	
	
	public int getLevel(){
		return db.getInt(Fields.LEVEL.name(), 0);
	}
	
	public void updateLevel(int level){
		Editor ed = db.edit();
		ed.putInt(Fields.LEVEL.name(), level);
		ed.commit();
	}
	
	public void setTablePosition(int position){
		Editor ed = db.edit();
		ed.putInt(Fields.TABLE_POSITION.name(), position);
		ed.commit();
	}
	
	public int getTablePosition(){
		return db.getInt(Fields.TABLE_POSITION.name(), 9);
	}
}
