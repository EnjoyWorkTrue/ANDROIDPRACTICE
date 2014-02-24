package com.example.lllist;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListFragment extends ListFragment {
	public SimpleListFragment(){
	}
	
	String[] mtitle = new String[] {"one","two"};

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,
				mtitle);
		setListAdapter(adapter);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	

}
