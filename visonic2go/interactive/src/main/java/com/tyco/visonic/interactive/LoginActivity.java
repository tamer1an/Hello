package com.tyco.visonic.interactive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LoginActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.login){
            Log.v("LEE", "Button1");
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(new Intent(intent));
        }
    }
}
