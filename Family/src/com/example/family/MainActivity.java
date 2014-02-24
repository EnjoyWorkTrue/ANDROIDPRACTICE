package com.example.family;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements Communicator {
	ButtonFrag buttFrag = new ButtonFrag();
	EditFamily edFamily = new EditFamily();

	
	public ButtonFrag mainFrage = new ButtonFrag();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e("MainActivity","null");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.top_fragment, buttFrag);
		transaction.add(R.id.bottom_fragment, edFamily);
		transaction.addToBackStack(null);
		transaction.commit();
		
		
		
	}


	@Override
	public void respond(String s) {
		Log.e("MainActivity","respond");
		if(s == "edit"){
			Toast.makeText(this, "edit", 0).show();
		}
		else if(s == "calculate"){
			int result = edFamily.calculate();
			if (result ==0) Toast.makeText(this, "fill everything with integer", 0).show();
			if (result==-1) Toast.makeText(this, "have to be all integer", 0).show();
			else Toast.makeText(this, ""+result, 0).show();
		}
		
		
	}
	
	
	
		
	

}
