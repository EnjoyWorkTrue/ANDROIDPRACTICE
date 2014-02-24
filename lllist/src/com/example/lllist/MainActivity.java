package com.example.lllist;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bbbbbbbb
		FragmentManager fm = getFragmentManager();
		if (fm.findFragmentById(android.R.id.content) == null) {  
		SimpleListFragment list = new SimpleListFragment();
		fm.beginTransaction().add(android.R.id.content,list).commit();
		}
		
	}

	

}
