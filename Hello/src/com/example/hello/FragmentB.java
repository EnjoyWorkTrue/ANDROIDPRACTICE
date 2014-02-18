package com.example.hello;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment{
	TextView text;
	String keepText=null;
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		Log.d("fragmentB","onActivityCreated");
		super.onActivityCreated(savedInstanceState);
		text = (TextView) getActivity().findViewById(R.id.textView5);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
		Log.d("fragmentB","onCreateView");
		View view = inflater.inflate(R.layout.fragment_b, container,false);
		if(savedInstanceState==null)
		{
			
		}
		else
		{
			keepText = savedInstanceState.getString("keepCounter");
			TextView myText =  (TextView) view.findViewById(R.id.textView5);
			myText.setText(keepText);
		}
		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		Log.d("fragmentB","onSaveInstanceState");
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("keepCounter",keepText);
	}
	public void changeText(String data){
		Log.d("fragmentB","changeText");
		keepText = data;
		text.setText(data);
	}

}
