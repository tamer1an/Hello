package com.tyco.visonic.interactive.fragmentapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.Menu;
import android.view.MenuItem;

import com.tyco.visonic.interactive.R;

public class StartActivity extends Activity {
    public static Context appContext;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//ActionBar gets initiatedS
        ActionBar actionbar = getActionBar();
//Tell the ActionBar we want to use Tabs.
//        assert actionbar != null;
//        if (actionbar != null) {
            actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //initiating both tabs and set text to it.
                ActionBar.Tab DetectorTab  = actionbar.newTab().setIcon(android.R.drawable.ic_menu_view); //.setText(R.string.title_section3); //@android:drawable/stat_sys_phone_call
                ActionBar.Tab CamerasTab   = actionbar.newTab().setIcon(android.R.drawable.stat_notify_voicemail);   //.setText(R.string.title_section2);
                ActionBar.Tab AlarmTab     = actionbar.newTab().setIcon(android.R.drawable.stat_sys_warning);  //.setText(R.string.title_section4);
                ActionBar.Tab AlertTab     = actionbar.newTab().setIcon(android.R.drawable.ic_menu_myplaces);//.setText(R.string.title_section5);
                ActionBar.Tab EventsDTab   = actionbar.newTab().setIcon(android.R.drawable.ic_menu_compass); //.setText(R.string.title_section6);

        //create the agments we want to use for display content
                Fragment DetectFragment          = new DetectorsFragment();
                Fragment CamerasFragment         = new CamerasFragment();
                Fragment AlarmsFragmentFragment  = new AlarmsDetailsFragment();
                Fragment AlertsDetailsFragment   = new AlertsDetailsFragment();
                Fragment EventsFragment          = new EventsFragment();

        //set the Tab listener. Now we can listen for clicks.
                DetectorTab.setTabListener(new MyTabsListener(DetectFragment));
                CamerasTab.setTabListener( new MyTabsListener(CamerasFragment));
                AlarmTab.setTabListener(   new MyTabsListener(AlarmsFragmentFragment));
                AlertTab.setTabListener(   new MyTabsListener(AlertsDetailsFragment));
                EventsDTab.setTabListener( new MyTabsListener(EventsFragment));

        //add the two tabs to the actionbar
                actionbar.addTab(DetectorTab);
                actionbar.addTab(CamerasTab);
                actionbar.addTab(AlarmTab);
                actionbar.addTab(AlertTab);
                actionbar.addTab(EventsDTab);

//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}