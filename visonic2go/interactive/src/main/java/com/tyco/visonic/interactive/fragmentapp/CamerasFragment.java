package com.tyco.visonic.interactive.fragmentapp;

import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.tyco.visonic.interactive.fragmentapp.listadapters.CamerasListAdapter;

public class CamerasFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] values = new String[] { "Front Door", "Garage", "Garage Door", "Back Door"};


        AsyncTask<String, String, String> getListTask = new RequestTask(){
            @Override
            protected void onPreExecute() {

                super.onPreExecute();
            }

            @Override public void onPostExecute(String result)
            {
//                String response_str = EntityUtils.toString(entity, HTTP.UTF_8);
                  Log.d("output", result);
//                int i = response.getStatusLine().getStatusCode();
//                Log.e("status","code "+i);
//                return response_str;
            }
        }
        .execute("https:// ... /rest_api/1.0/get_cameras");

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

//try{
//        this.ctx = getView().getContext();
//        } catch (Exception e){
//        e.getStackTrace();
//        }

//        .execute("https:// ... /rest_api/1.0/dump?par1=val1&par2=val2");
//        .execute("https:// ... /rest_api/1.0/is_connected");
//        .execute("https:// ... /rest_api/1.0/get_status");