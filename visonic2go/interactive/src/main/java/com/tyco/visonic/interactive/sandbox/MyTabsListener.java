package com.tyco.visonic.interactive.sandbox;


import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.Fragment;

import android.widget.Toast;

import com.tyco.visonic.interactive.R;

class MyTabsListener implements ActionBar.TabListener {
    public Fragment fragment;

    public MyTabsListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Toast.makeText(StartActivity.appContext, "Reselected!", Toast.LENGTH_LONG).show();
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