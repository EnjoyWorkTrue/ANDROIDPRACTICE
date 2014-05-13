package com.example.catalk;

import com.example.catalk.R.id;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements Communicator {
	int count;
	public MainFragment mainFrag = new MainFragment();
	public FragmentA fragA = new FragmentA();
	public FragmentB fragB = new FragmentB();
	private boolean on = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e("MainActivity","onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(savedInstanceState!=null)
		{ 
			Log.e("MainActivity","not null");
			mainFrag = (MainFragment) getFragmentManager().findFragmentByTag("mainFrag");
			fragA = (FragmentA) getFragmentManager().findFragmentByTag("fragmentA");
			FragmentManager manager = getFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			transaction.remove(fragA);
			transaction.replace(R.id.bottom_fragment, fragB,"FragmentB");
			
			
		}
		else
		{
			Log.e("MainActivity","null");
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.top_fragment,mainFrag,"mainFrag");
		transaction.add(R.id.bottom_fragment,fragA,"fragmentA");
		transaction.commit();
		
	}
	}
	@Override
	public void repond(String s) {
		Log.e("MainActivity","repond");
		if(s=="buttonB" && this.on)
		{
			this.on = false;
			FragmentManager manager = getFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			transaction.remove(fragA);
			transaction.add(R.id.bottom_fragment, fragB,"FragmentB");
			transaction.commit();
			
		}
		if(s=="buttonA" && !this.on)
		{
			this.on = true;
			FragmentManager manager = getFragmentManager();
			fragA.changeText("ss"+count);
			count++;
			FragmentTransaction transaction = manager.beginTransaction();
			transaction.replace(R.id.bottom_fragment, fragA, "FragmentA");
			
			transaction.commit();
			
		}
		
		
	}

}
