package com.example.family;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFrag extends Fragment implements View.OnClickListener {
	Communicator comm;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("ButtonFrag","onCreateView");
		return inflater.inflate(R.layout.button_frag, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i("ButtonFrage","onActivityCreated");		
		super.onActivityCreated(savedInstanceState);
		comm = (Communicator) getActivity();
		Button button = (Button) getActivity().findViewById(R.id.edit_button);
		Button button1 = (Button) getActivity().findViewById(R.id.Calculate_button);
		button.setOnClickListener(this);
		button1.setOnClickListener(this);
		
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	
	@Override
	public void onClick(View v) {
		Log.i("ButtonFrage","onClick");
		
		if(R.id.edit_button == v.getId()){
			
			comm.respond("edit");
		}
		else if(R.id.Calculate_button==v.getId()){
			comm.respond("calculate");
		}
	}
	
	
	
}
