package com.tryby.helloapp;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class List extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);	
		
//		setListAdapter(new ArrayAdapter<String>(
//			this, 
//			android.R.layout.simple_expandable_list_item_1, 
//			getResources().getStringArray(R.array.countries))
//		);
		
		setListAdapter(new MyAdapter<String>(
			this, 
			android.R.layout.simple_expandable_list_item_1, 
			getResources().getStringArray(R.array.countries))
		);
	}

	public class MyAdapter<T> extends ArrayAdapter<T> implements ListAdapter {
		
		@Override
		public View getView(int i,View conView, ViewGroup parent) {
			
			LayoutInflater inf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
			return super.getView(getPosition(null), conView, parent);
		}

		public MyAdapter(Context context, int resource) {
			super(context, resource);
			// TODO Auto-generated constructor stub
		}

		public MyAdapter(Context context, int resource, int textViewResourceId) {
			super(context, resource, textViewResourceId);
			// TODO Auto-generated constructor stub
		}

		public MyAdapter(Context context, int resource, T[] objects) {
			super(context, resource, objects);
			// TODO Auto-generated constructor stub
		}

		public MyAdapter(Context context, int textViewResourceId, List objects) {
			super(context, textViewResourceId);
			// TODO Auto-generated constructor stub
		}

		public MyAdapter(Context context, int resource, int textViewResourceId,
				T[] objects) {
			super(context, resource, textViewResourceId, objects);
			// TODO Auto-generated constructor stub
		}

		public MyAdapter(Context context, int resource, int textViewResourceId,
				List objects) {
			super(context, resource, textViewResourceId);
			// TODO Auto-generated constructor stub
		}

	}
}

