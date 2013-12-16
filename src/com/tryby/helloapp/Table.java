package com.tryby.helloapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Table extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);	
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);		
		
		ImageView iw = (ImageView) findViewById(R.id.imageView0);
		iw.setBackgroundResource(R.anim.animation);
		iw.setOnClickListener(this);
	}

	public void onClick(View v) {
		if(v.getId() == R.id.button1){
			Log.v("LEE", "Button1");
			
			Intent intent = new Intent(Table.this, List.class);						
			startActivity(new Intent(intent)); 
		}else if(v.getId() == R.id.imageView0){
			AnimationDrawable anim = (AnimationDrawable) v.getBackground();
			anim.start();			
		}
	}
}
