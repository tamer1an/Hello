package com.tryby.helloapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Table extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);	
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}

	public void onClick(View v) {
		if(v.getId() == R.id.button1){
			Log.v("LEE", "Button1");
		}
	}
}
