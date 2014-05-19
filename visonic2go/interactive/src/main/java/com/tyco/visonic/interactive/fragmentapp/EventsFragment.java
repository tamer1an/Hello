package com.tyco.visonic.interactive.fragmentapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventsFragment extends ListFragment {
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

                    if (c.length() > 0) {
                        for (int i = 0; i < c.length(); i++) {
                            JSONObject obj = c.getJSONObject(i);

                            String alertType = obj.getString("alert_type");  // String zone = obj.getString("zone");  // System.out.println(location + " " + zone + " ");
                            val[i] = alertType;
                        }
                    } else {
                        val = new String[] { "Has come online" };
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
        }.execute("https://.../rest_api/1.0/get_events");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // do something with the data
    }
}


//        String[] values = new String[] { "Has come online", "Went offline","Has come online","Fire","Disarm","Has come online","Fire", "Perimeter Alarm","Fire", "Interior Alarm", "Has come online"};