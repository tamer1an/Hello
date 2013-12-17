package com.tryby.helloapp;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
		
		TextView tv2 = (TextView) findViewById(R.id.textView1);
		tv2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

					NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
					Notification notify = new Notification( android.R.drawable.stat_notify_more, "This is test msg", System.currentTimeMillis());
					
					Context context = Second.this;
					CharSequence title = "You have been notified";
					CharSequence details = "continue..";
					
					Intent intent = new Intent();
					PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
					
					notify.setLatestEventInfo(context, title, details, pendingIntent);
//					notify.sound = Uri.parse("android.resource://com.tryby.helloapp/"+ R.raw)
					
					nm.notify(0, notify);
					
					Toast toast = Toast.makeText(Second.this, "notification create", 5000);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
				
			}
		});
	}
}
