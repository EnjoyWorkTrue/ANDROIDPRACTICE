package com.example.catalk;





import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


//RepresentButton
public class MainFragment extends Fragment implements View.OnClickListener{
	Button button;
	Button button1;
	Communicator comm;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("MainFragment","onCreateView");
		return inflater.inflate(R.layout.main_fragment, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i("MainFragment","onActivityCreated");
		super.onActivityCreated(savedInstanceState);
		comm = (Communicator) getActivity();
		button = (Button) getActivity().findViewById(R.id.buttonA);		
		button.setOnClickListener(this);
		button1 = (Button) getActivity().findViewById(R.id.buttonB);
		button1.setOnClickListener(this);
		
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
	@Override
	public void onClick(View v) {
		Log.i("main fragment","onclick");
		if (R.id.buttonA == v.getId()){
			Toast.makeText(getActivity(), "a", 0).show();
			comm.repond("buttonA");
		}
		else{			
			Toast.makeText(getActivity(), "b", 0).show();
			comm.repond("buttonB");
		}
		
	}
	
	
}
