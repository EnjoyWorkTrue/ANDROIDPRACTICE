package com.example.hello;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFragment extends Fragment implements View.OnClickListener {
	Button button;
	int counter = 0;
	Communicator comm;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(savedInstanceState==null){
			counter=0;
		}
		else
		{
			counter = savedInstanceState.getInt("counter",0);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.activity_my_fragment, container,false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		
		super.onActivityCreated(savedInstanceState);
		comm = (Communicator) getActivity();
		button =(Button) getActivity().findViewById(R.id.button1);
		button.setOnClickListener(this);
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("counter",counter);
	}
	@Override
	public void onClick(View v) {
		counter++;
		comm.respond("Tbe button was clicked "+ counter + " times");
		// TODO Auto-generated method stub
		
	}
	
	

}
