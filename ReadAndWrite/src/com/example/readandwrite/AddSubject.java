package com.example.readandwrite;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddSubject extends Activity {

	private boolean clicked = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_subject);
	}
	public void finish(View v){
		
		MainActivity.setChangeSubject(getText());
		clicked = false;
		finish();
	}
	@Override
	protected void onPause() {
		if(clicked){
			MainActivity.setChangeSubject(getText());
		}
		super.onPause();
	}
	
	
	private String getText(){
		EditText edit = (EditText) findViewById(R.id.editText1);
		return edit.getText().toString();
	}

	
}
