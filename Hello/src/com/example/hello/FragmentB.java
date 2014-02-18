package com.example.hello;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentB extends Fragment{
	TextView text;
	String keepText=null;
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		
		super.onActivityCreated(savedInstanceState);
		text = (TextView) getActivity().findViewById(R.id.textView5);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
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
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("keepCounter",keepText);
	}
	public void changeText(String data){
		keepText = data;
		text.setText(data);
	}

}
