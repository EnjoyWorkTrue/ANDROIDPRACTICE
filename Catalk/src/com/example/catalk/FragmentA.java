package com.example.catalk;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentA extends Fragment{
	ListView list;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d("FragmentA","onCreate");
		super.onCreate(savedInstanceState);
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("FragmentA","onCreateView");
		
		View view = inflater.inflate(R.layout.activity_fragment, container,false);
		return view;
	}
	@Override
	public void onDestroy() {
		Log.d("FragmentA","onDestroy");
		super.onDestroy();
	}


}
