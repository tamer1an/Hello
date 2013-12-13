package com.tryby.helloapp;

import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	//create event handler
        super.onCreate(savedInstanceState);
        
        //assign to layout.xml
        setContentView(R.layout.activity_main);
        
        // find button and attach onClick handler
        final EditText et = (EditText) findViewById(R.id.editText1);
        
        Button b = (Button) findViewById(R.id.lunchSecond);
        b.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				Log.d("LEE", "button was clicked");//logging to console
				Intent intent = new Intent(MainActivity.this, Second.class);
				intent.putExtra("text", et.getText().toString());				
				startActivity(new Intent(intent)); 
			}
		});  
        
        //change pic to other than default pic in xml
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.test);        
       
        imageView.setOnClickListener(new OnClickListener() {		//intent.putExtra("text", et.getText().toString());			
			public void onClick(View v) {
				Log.d("LEE", "iw was clicked");//logging to console
				Intent intent = new Intent(MainActivity.this, Frame.class);						
				startActivity(new Intent(intent)); 
			}
		});
        
        // check wi-fi connectivity
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        TextView tw = (TextView) findViewById(R.id.textView1);
        boolean wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        
        if(wifi){
        	tw.setText("wifi is on");
        }else{
        	tw.setText("wifi is off");
        }
        
        tw.setOnClickListener(new OnClickListener() {		//intent.putExtra("text", et.getText().toString());			
			public void onClick(View v) {
				Log.d("LEE", "tw was clicked");//logging to console
				Intent intent = new Intent(MainActivity.this, Table.class);						
				startActivity(new Intent(intent)); 
			}
		});
        
// Implicit Intent
// ImageView iv = (ImageView) findViewById(R.id.imageView1);
// iv.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
