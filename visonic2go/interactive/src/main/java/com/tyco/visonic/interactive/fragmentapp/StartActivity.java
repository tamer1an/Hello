package com.tyco.visonic.interactive.fragmentapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tyco.visonic.interactive.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class StartActivity extends Activity {
    public static Context appContext;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//ActionBar gets initiatedS
        ActionBar actionbar = getActionBar();
//Tell the ActionBar we want to use Tabs.
//        assert actionbar != null;
//        if (actionbar != null) {
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //initiating both tabs and set text to it.
        ActionBar.Tab DetectorTab = actionbar.newTab().setIcon(android.R.drawable.ic_menu_view); //.setText(R.string.title_section3); //@android:drawable/stat_sys_phone_call
        ActionBar.Tab CamerasTab = actionbar.newTab().setIcon(android.R.drawable.stat_notify_voicemail);   //.setText(R.string.title_section2);
        ActionBar.Tab AlarmTab = actionbar.newTab().setIcon(android.R.drawable.stat_sys_warning);  //.setText(R.string.title_section4);
        ActionBar.Tab AlertTab = actionbar.newTab().setIcon(android.R.drawable.ic_dialog_alert);//.setText(R.string.title_section5);
        ActionBar.Tab EventsDTab = actionbar.newTab().setIcon(android.R.drawable.ic_menu_agenda); //.setText(R.string.title_section6);

        //create the agments we want to use for display content
        Fragment DetectFragment = new DetectorsFragment();
        Fragment CamerasFragment = new CamerasFragment();
        Fragment AlarmsFragmentFragment = new AlarmsDetailsFragment();
        Fragment AlertsDetailsFragment = new AlertsDetailsFragment();
        Fragment EventsFragment = new EventsFragment();

        //set the Tab listener. Now we can listen for clicks.
        DetectorTab.setTabListener(new MyTabsListener(DetectFragment));
        CamerasTab.setTabListener(new MyTabsListener(CamerasFragment));
        AlarmTab.setTabListener(new MyTabsListener(AlarmsFragmentFragment));
        AlertTab.setTabListener(new MyTabsListener(AlertsDetailsFragment));
        EventsDTab.setTabListener(new MyTabsListener(EventsFragment));

        //add the two tabs to the actionbar
        actionbar.addTab(DetectorTab);
        actionbar.addTab(CamerasTab);
        actionbar.addTab(AlarmTab);
        actionbar.addTab(AlertTab);
        actionbar.addTab(EventsDTab);
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


//        URL url = null;
//        try {
//            url = new URL("https://94.125.125.228/rest_api/1.0/get_cameras");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        URLConnection urlConnection = null;
//        try {
//            urlConnection = url.openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        InputStream in = null;
//        try {
//            in = urlConnection.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
///////////////////////////////////////////////////////////////////////
//
//        try {
//            HttpClient client = new DefaultHttpClient();
//            HttpGet request = new HttpGet();
//            request.setURI(new URI("https://94.125.125.228/rest_api/1.0/get_cameras"));
//            HttpResponse response = client.execute(request);
//        } catch (URISyntaxException | IOException e) {
//            e.printStackTrace();
//        }


/*/////////////////////////////////////////////////////////////////////
        HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
        DefaultHttpClient client = new DefaultHttpClient();

        SchemeRegistry registry = new SchemeRegistry();
        SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        socketFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
        registry.register(new Scheme("https", socketFactory, 443));
        SingleClientConnManager mgr = new SingleClientConnManager(client.getParams(), registry);
        DefaultHttpClient httpClient = new DefaultHttpClient(mgr, client.getParams());

// Set verifier
        HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);

// Example send http request
        final String url = "https://94.125.125.228/rest_api/1.0/get_cameras";
//        HttpPost httpPost = new HttpPost(url);
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

/////////////////////////////////////
//HttpClient Client = new DefaultHttpClient();
//// Create URL string
//String URL = "http://androidexample.com/media/webservice/httpget.php?user=aawf";
////Log.i("httpget", URL);
//
//try {
//        String SetServerString = "";
//        // Create Request to server and get response
//
//        HttpGet httpget = new HttpGet(URL);
//        ResponseHandler<String> responseHandler = new BasicResponseHandler();
//        SetServerString = Client.execute(httpget, responseHandler);
//
//        // Show response on activity
//        Toast.makeText(getApplicationContext(),SetServerString, Toast.LENGTH_LONG).show();
//        } catch (Exception ex) {
//        Toast.makeText(getApplicationContext(),"fail", Toast.LENGTH_LONG).show();
//        }
//
//        Toast.makeText(getApplicationContext(),"fail", Toast.LENGTH_LONG).show();