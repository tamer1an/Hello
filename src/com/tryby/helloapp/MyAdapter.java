package com.tryby.helloapp;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class MyAdapter<T> extends ArrayAdapter<T>  { //implements ListAdapter
	
//	@Override
//	public View getView(int i,View conView, ViewGroup parent) {
//		
//	}

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

	public MyAdapter(Context context, int textViewResourceId, List<T> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	public MyAdapter(Context context, int resource, int textViewResourceId,
			T[] objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	public MyAdapter(Context context, int resource, int textViewResourceId,
			List<T> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

}
