package com.tyco.visonic.interactive.fragmentapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tyco.visonic.interactive.fragmentapp.listadapters.DetectorsListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlertsDetailsFragment extends ListFragment{
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

                        String alertType = obj.getString("alert_type");  // String zone = obj.getString("zone");  // System.out.println(location + " " + zone + " ");
                        val[i] = alertType;
                    }

                    // custom list item
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, val);
                    setListAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (NullPointerException ignored) {

                }
            }
        }.execute("https://...a/rest_api/1.0/get_alerts");

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // do something with the data
    }
}


//String[] values = new String[] { "Control Panel", "Zone Temperature id:8","Zone Delay-1","Control Panel", "Zone Temperature id:8", "Zone Delay-1", "Zone Temperature id:8"};

