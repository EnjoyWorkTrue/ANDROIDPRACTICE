package com.example.family;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class EditFamily extends Fragment {
	private String[] message ={"","","",""};
	
	Communicator comm;
	String a;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d("EditFamily","onCreate");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.edit_family, container,
	            false);
	
		
		
		
		return view;
		
		
	}
	
	
	public String getStringFrom_EditFamily(){
		View v = this.getView();
		EditText edit1 = (EditText) v.findViewById(R.id.editText1);
		EditText edit2 = (EditText) v.findViewById(R.id.editText2);
		EditText edit3 = (EditText) v.findViewById(R.id.editText3);
		EditText edit4 = (EditText) v.findViewById(R.id.editText4);
		message[0] = edit1.getText().toString();
		message[1] = edit2.getText().toString();
		message[2] = edit3.getText().toString();
		message[3] = edit4.getText().toString();
		
		
		return edit1.getText().toString();
	}
	public String calculate1(){
		this.getStringFrom_EditFamily();
		
		return message[0];
	}
	public int calculate(){
		this.getStringFrom_EditFamily();
		int total = 0;
		for(int i =0; i<4;i++){
			if (message[i].equals("")) return 0;
			else{
				try{
				total +=  Integer.parseInt(message[i]);
				}
				catch(NumberFormatException e){
					return -1;
				}
			}
		}
		
		return total;
	}
	

}
