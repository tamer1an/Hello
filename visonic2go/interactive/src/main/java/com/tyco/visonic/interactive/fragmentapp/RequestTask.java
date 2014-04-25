package com.tyco.visonic.interactive.fragmentapp;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

class RequestTask extends AsyncTask<String,String,String>
{
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        try
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost method = new HttpPost(params[0]);
            HttpResponse response = httpclient.execute(method);
            HttpEntity entity = response.getEntity();
            if(entity != null){
//                String response_str = EntityUtils.toString(entity, HTTP.UTF_8);
//                Log.e("output",response_str);
//                int i = response.getStatusLine().getStatusCode();
//                Log.e("status","code "+i);
//                return response_str;

                return EntityUtils.toString(entity, HTTP.UTF_8);
            }
            else{
                return "No string.";
            }
        }
        catch(Exception e){
            return "Network problem";
        }
    }
}