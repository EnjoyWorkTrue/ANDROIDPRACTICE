package com.example.readandwrite;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

// 버그.. 같은 제목이 있을때  5번째 있는걸 지울려 해도 첫번째께 지워짐.
public class MainActivity extends Activity {
	public boolean isitFirst = true;
	public static String subject;
	public static final int Setting_Result = 1;
	private static final String PREFS_NAME = "savedData";
	ArrayAdapter<String> mAdapter;
	String[] subjects;
	public static Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getPreviousData();
		
		mAdapter = new ArrayAdapter<String>(this, 
											android.R.layout.simple_list_item_1, 
											new ArrayList<String>(Arrays.asList(subjects)));
		ListView lv = (ListView) findViewById(R.id.list_view);
		lv.setAdapter(mAdapter);
		
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
		
		@Override
		public boolean onItemLongClick(AdapterView<?> parent, 
				View view, final int position,long id) {
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
	        builder.setCancelable(true);
	        //builder.setTitle(mAdapter.getItem(position));
	        builder.setNegativeButton("Cancle", null);
	        final EditText edit = new EditText(MainActivity.this);
	        edit.setText(mAdapter.getItem(position));
	        edit.setTextSize(30);
	        builder.setView(edit);
	        builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {

	            public void onClick(DialogInterface dialog, int which) {
	            	Toast.makeText(MainActivity.this,edit.getText().toString(),0);
	            	mAdapter.remove(mAdapter.getItem(position));
	            	mAdapter.notifyDataSetChanged();
	            }
	        }).show();
			return false;
		}

	});	
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, 
					View view, final int position,long id) {
				Toast.makeText(MainActivity.this, mAdapter.getItem(position), 0).show();
				
			}

		});		
	};

	
	
	
	private void getSubjects() {
		//will retreive info later
		subjects = new String[]{"Android","Internet Programming","Database","Theatre"};
	}
	private void getSubjects(String s) {
		//will retreive info later
		subjects = s.split(",");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_settings:
			return true;
		
		case R.id.action_add:
			//goto preference activity for adding
			gotoPreference();
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



	private void gotoPreference() {
		i = new Intent(MainActivity.this,AddSubject.class);
		startActivityForResult(i,Setting_Result);
	
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==Setting_Result){
			pushItemonAdapter(getString());
		
		}
	}



	private void pushItemonAdapter(String s) {
		mAdapter.add(s);
		mAdapter.notifyDataSetChanged();
		
	}



	private String getString() {
		return subject;
	}
	public static void setChangeSubject(String s){
		subject = s;
	}
	//saved DATA when it is stop
	@Override
	protected void onPause() {
		String s="";
		if(mAdapter.getCount()==0)
			s="addedItem";
		else if (mAdapter.getCount()!=0){
		for(int i=0; i<mAdapter.getCount()-1;i++)
			{
			s = s+mAdapter.getItem(i)+",";
			}
		s = s+mAdapter.getItem(mAdapter.getCount()-1);
		}

	
		
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
		Editor editor = settings.edit();		
		editor.putString("savedData", s);		
		editor.putBoolean("first", !isitFirst);
		editor.commit();
		super.onPause();
		
	}
	public void getPreviousData(){
		SharedPreferences settings = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
		if(settings.getBoolean("first", isitFirst)){
			getSubjects();
		}
		else{
			getSubjects(settings.getString("savedData", "haha"));
			
		}
			
		
	}
	
	

}
