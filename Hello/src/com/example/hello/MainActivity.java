package com.example.hello;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements Communicator {
	public MyFragment frag = new MyFragment();
    public FragmentB frag2 = new FragmentB();
    String keepCount = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.i("main","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        ///
        if (savedInstanceState!=null){
        	frag = (MyFragment) getFragmentManager().findFragmentByTag("firstFragment");
        	frag2 = (FragmentB) getFragmentManager().findFragmentByTag("secondFragment");
        }
        else
        {
        	FragmentManager manager = getFragmentManager();
        	FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.my_layout,frag,"firstFragment");
            transaction.add(R.id.my_layout,frag2,"secondFragment");
            transaction.commit();
        }
    }
	@Override
	public void respond(String data) {
		Log.i("main","respond");
		//FragmentManager manager = getFragmentManager();
		//frag2 = (FragmentB) manager.findFragmentByTag("secondFragment");
		frag2.changeText(data);
		
		
	}


   
    
}
