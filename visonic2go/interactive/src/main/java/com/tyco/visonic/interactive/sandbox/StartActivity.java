package com.tyco.visonic.interactive.sandbox;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;


import com.tyco.visonic.interactive.R;

public class StartActivity extends Activity {
    public static Context appContext;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//ActionBar gets initiated
        ActionBar actionbar = getActionBar();
//Tell the ActionBar we want to use Tabs.
        assert actionbar != null;
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//initiating both tabs and set text to it.
        ActionBar.Tab PlayerTab = actionbar.newTab().setText("Fragment A");
        ActionBar.Tab StationsTab = actionbar.newTab().setText("Fragment B");

//create the two fragments we want to use for display content
        Fragment PlayerFragment = new AFragment();
        Fragment StationsFragment = new BFragment();

//set the Tab listener. Now we can listen for clicks.
        PlayerTab.setTabListener(new MyTabsListener(PlayerFragment));
        StationsTab.setTabListener(new MyTabsListener(StationsFragment));

//add the two tabs to the actionbar
        actionbar.addTab(PlayerTab);
        actionbar.addTab(StationsTab);
    }
}