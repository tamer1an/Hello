package com.tryby.helloapp;

import android.app.ListActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class List extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);	
		
		setListAdapter(new ArrayAdapter<String>(
			this, 
			android.R.layout.simple_expandable_list_item_1, 
			getResources().getStringArray(R.array.countries))
		);
	}

}
