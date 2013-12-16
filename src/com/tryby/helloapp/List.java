package com.tryby.helloapp;

import java.util.zip.Inflater;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class List extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);	
		
		// default list item
//		setListAdapter(new ArrayAdapter<String>(
//			this, 
//			android.R.layout.simple_expandable_list_item_1, 
//			getResources().getStringArray(R.array.countries))
//		);	
		
		// custom list item
		setListAdapter(new MyAdapter<String>(
			this, 
			android.R.layout.simple_expandable_list_item_1, 
			findViewById(R.id.textView7),
			getResources().getStringArray(R.array.countries))
		);
	}

	private class MyAdapter<T> extends ArrayAdapter<String> {
		public MyAdapter(Context context, int resource, View view,
				String[] strings) {
			super(context, resource, strings);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			LayoutInflater inf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inf.inflate(R.layout.list_item, parent, false);
			String[] items = getResources().getStringArray(R.array.countries);
			
			ImageView iw = (ImageView) row.findViewById(R.id.imageView7);
			TextView tw = (TextView) row.findViewById(R.id.textView7);
			
			tw.setText(items[position]);
			
			if (items[position].equals("United State")){
				iw.setImageResource(R.drawable.usa);
			}else if(items[position].equals("Brazil")){
				iw.setImageResource(R.drawable.brazil);
			}else if(items[position].equals("Russia")){
				iw.setImageResource(R.drawable.russia);
			}else if(items[position].equals("Japan")){
				iw.setImageResource(R.drawable.japan);
			}else if(items[position].equals("Egypt")){
				iw.setImageResource(R.drawable.france);
			}
			
			return row; //			return super.getView(position, convertView, parent);
		}
	}
}