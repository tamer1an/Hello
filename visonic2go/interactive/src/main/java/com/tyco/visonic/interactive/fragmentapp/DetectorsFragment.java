package com.tyco.visonic.interactive.fragmentapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.tyco.visonic.interactive.fragmentapp.listadapters.CamerasListAdapter;
import com.tyco.visonic.interactive.fragmentapp.listadapters.DetectorsListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetectorsFragment extends ListFragment{
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

                        String subType = obj.getString("subtype");  // String zone = obj.getString("zone");  // System.out.println(location + " " + zone + " ");
                        val[i] = subType;
                    }

                    // custom list item
                    setListAdapter(new DetectorsListAdapter<String>(
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
        }.execute("https://.../rest_api/1.0/get_zones");
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





    //////////////////////////////////


//                    String[] values = new String[] { "Low battery", "Child Room", "Back Door",
//                            "Kitchen", "Trouble", "Office", "Dining room", "Garage Door",
//                            "Alarmed", "Badroom" };
//                    // custom list item
//                    setListAdapter(new CamerasListAdapter<>(
//                                    getActivity(),
//                                    android.R.layout.simple_expandable_list_item_1,
//                                    getView(),
//                                    val)
//                    );


*/