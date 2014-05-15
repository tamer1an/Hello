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

//        String[] values = new String[] { "Front Door", "Garage", "Garage Door", "Back Door" };

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

                try {
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray c = responseObject.getJSONArray("content");
                    String[] val = new String[c.length()];

                    for (int i = 0 ; i < c.length(); i++) {
                        JSONObject obj = c.getJSONObject(i);

                        String location = obj.getString("location");
                        String zone = obj.getString("zone");

                        System.out.println(location + " " + zone + " ");

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
                }
            }
        }.execute("https://.../rest_api/1.0/get_cameras");
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