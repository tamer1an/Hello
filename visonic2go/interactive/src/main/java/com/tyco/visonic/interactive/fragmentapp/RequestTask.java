package com.tyco.visonic.interactive.fragmentapp;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


class RequestTask extends AsyncTask<String, String, String> {
    private final String USER_AGENT = "Mozilla/5.0";
    private StringBuffer respSB;

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);

            HttpsURLConnection urlConnection =
                    (HttpsURLConnection) url.openConnection();
            urlConnection.setUseCaches(false);
            urlConnection.setAllowUserInteraction(false);

//          urlConnection.setDoInput(true);
//          urlConnection.setDoOutput(true);
//          urlConnection.setSSLSocketFactory(context.getSocketFactory());

//          urlConnection.setRequestMethod("POST");
//          urlConnection.setRequestProperty("User-Agent", USER_AGENT);

            String userCredentials = "200002:1111";
            String basicAuth = "Basic " + new String(Base64.encode(userCredentials.getBytes(), 0));
            urlConnection.setRequestProperty("Authorization", basicAuth);

//          urlConnection.setRequestProperty("Content-Type", "application/xml"); //"application/x-www-form-urlencoded"
//          urlConnection.setRequestProperty("Accept", "application/json");

//          urlConnection.setRequestProperty("Content-Language", "en-US");
//          urlConnection.setRequestProperty("Content-Length", "0");

            Log.d("STATUS CODE", "" + urlConnection.getResponseCode());
            Log.d("RESP MSG", "" + urlConnection.getResponseMessage());

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = urlConnection.getInputStream();
                respSB = copyInputStreamToOutputStream(in, System.out);
            } else {
                InputStream in = urlConnection.getErrorStream();
                copyInputStreamToOutputStream(in, System.out);
            }

            return respSB.toString();
        } catch (Exception e) {
            return "Network problem" + e.toString();
        }
    }

    private StringBuffer copyInputStreamToOutputStream(InputStream in, PrintStream out) throws IOException {
        Log.d("output", in.toString());

        StringBuffer sb = new StringBuffer();
        try {
            int ch;

            while ((ch = in.read()) != -1) {
                sb.append((char) ch);
            } // out.println(sb.toString());
        } catch (IOException e) {
            throw e;
        } finally {
            in.close();
        }
        return sb;
    }
}