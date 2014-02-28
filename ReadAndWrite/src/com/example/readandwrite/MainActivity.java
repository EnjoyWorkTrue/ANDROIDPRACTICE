package com.example.readandwrite;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ArrayAdapter<String> mAdapter;
	String[] subjects;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSubjects();
		
		mAdapter = new ArrayAdapter<String>(this, 
											android.R.layout.simple_list_item_1, 
											new ArrayList<String>(Arrays.asList(subjects)));
		ListView lv = (ListView) findViewById(R.id.list_view);
		lv.setAdapter(mAdapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, 
					View view, final int position,long id) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		        builder.setCancelable(true);
		        builder.setTitle(mAdapter.getItem(position));
		        builder.setNegativeButton("No", null);
		        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

		            public void onClick(DialogInterface dialog, int which) {
		            	mAdapter.remove(mAdapter.getItem(position));
		            	mAdapter.notifyDataSetChanged();
		            }
		        }).show();
				
			}

		});		
	};
	
	
	
	private void getSubjects() {
		//will retreive info later
		subjects = new String[]{"Android","Internet Programming","Database","Theatre"};
		
		
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
			Toast.makeText(this, "action_setting", 0).show();
			return true;
		
		case R.id.action_add:
			Toast.makeText(this, "action_add", 0).show();
			//goto preference activity for adding
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
