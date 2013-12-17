package com.tryby.helloapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Second extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		TextView tv = (TextView) findViewById(R.id.textView2);
		tv.setText(getIntent().getExtras().getString("text"));	
		
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Dialog d = new Dialog(Second.this);
				d.setContentView(R.layout.dialog);
				d.setTitle("This is important");
				d.show();
			}
		});
		
	}
}
