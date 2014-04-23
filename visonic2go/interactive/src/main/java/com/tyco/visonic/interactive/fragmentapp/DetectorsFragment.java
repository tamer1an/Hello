package com.tyco.visonic.interactive.fragmentapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.tyco.visonic.interactive.fragmentapp.listadapters.DetectorsListAdapter;

public class DetectorsFragment extends ListFragment{
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);

       String[] values = new String[] { "Low battery", "Child Room", "Back Door",
                "Kitchen", "Trouble", "Office", "Dining room", "Garage Door",
                "Alarmed", "Badroom" };

        // custom list item
        setListAdapter(new DetectorsListAdapter<String>(
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




/*  notes:
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detectorsfragment, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        String[] values = new String[]{"Low battery", "Child Room", "Back Door",
                "Kitchen", "Trouble", "Office", "Dining room", "Garage Door",
                "Alarmed", "Badroom"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }
*/