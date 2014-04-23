package com.tyco.visonic.interactive.fragmentapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tyco.visonic.interactive.fragmentapp.listadapters.CamerasListAdapter;
import com.tyco.visonic.interactive.fragmentapp.listadapters.DetectorsListAdapter;

public class CamerasFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] values = new String[] { "Front Door", "Garage", "Garage Door", "Back Door"};


        // custom list item
        setListAdapter(new CamerasListAdapter<>(
                        getActivity(),
                        android.R.layout.simple_expandable_list_item_1,
                        getView(),
                        values)
        );
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // do something with the data
    }
}