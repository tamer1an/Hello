package com.tyco.visonic.interactive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.tyco.visonic.interactive.sandbox.HomeActivity;
import com.tyco.visonic.interactive.sandbox.StartActivity;
import com.tyco.visonic.interactive.sandbox.WideAppFlowListActivity;

//import com.tyco.visonic.interactive.sandbox.HomeActivity;

public class LoginActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button) findViewById(R.id.login);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login){ //Log.v("LEE", "Button1");
//            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//            Intent intent = new Intent(LoginActivity.this, WideAppFlowDetailActivity.class);
//            Intent intent = new Intent(LoginActivity.this, WideAppFlowListActivity.class);
            Intent intent = new Intent(LoginActivity.this, StartActivity.class);
            startActivity(new Intent(intent));
        }
    }
}