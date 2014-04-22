package com.tyco.visonic.interactive.fragmentapp;


import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.Toast;

import com.tyco.visonic.interactive.R;

import static android.widget.Toast.makeText;

class MyTabsListener implements ActionBar.TabListener {
    public Fragment fragment;

    public MyTabsListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        try {
            makeText(StartActivity.appContext, "Reselected!", Toast.LENGTH_LONG).show();
        } catch (NullPointerException ignored){

        }

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

}