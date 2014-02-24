package com.example.catalk;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentB extends Fragment {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d("FragmentB","onCreate");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("FragmentB","onCreateView");
		View view = inflater.inflate(R.layout.activity_fragment_b, container,false);
		return view;
	}
	@Override
	public void onDestroy() {
		Log.d("FragmentB","onDestroy");
		super.onDestroy();
	}

}
