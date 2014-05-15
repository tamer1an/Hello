package com.tyco.visonic.interactive.fragmentapp;

import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.tyco.visonic.interactive.fragmentapp.listadapters.CamerasListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CamerasFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new RequestTask() { /*AsyncTask<String, String, String> getListTask =*/
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            public void onPostExecute(String result) { // String response_str = EntityUtils.toString(result, HTTP.UTF_8);
                Log.d("output", result);

                try {
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray c = responseObject.getJSONArray("content");
                    String[] val = new String[c.length()];

                    for (int i = 0; i < c.length(); i++) {
                        JSONObject obj = c.getJSONObject(i);

                        String location = obj.getString("location");  // String zone = obj.getString("zone");  // System.out.println(location + " " + zone + " ");
                        val[i] = location;
                    }

                    // custom list item
                    setListAdapter(new CamerasListAdapter<>(
                                    getActivity(),
                                    android.R.layout.simple_expandable_list_item_1,
                                    getView(),
                                    val)
                    );

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (NullPointerException ignored) {

                }
            }
        }.execute("https://..../rest_api/1.0/get_cameras");
    }

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        // do something with the data
//    }
}