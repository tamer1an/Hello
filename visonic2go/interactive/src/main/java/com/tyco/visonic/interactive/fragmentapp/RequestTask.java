package com.tyco.visonic.interactive.fragmentapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

class RequestTask extends AsyncTask<String, String, String> {
    java.security.cert.Certificate ca;
    InputStream caInput;
    CertificateFactory cf;

    String keyStoreType;
    KeyStore keyStore = null;
    String tmfAlgorithm;
    TrustManagerFactory tmf = null;

    SSLContext context = null;
    Context ctx;

    @Override
    protected String doInBackground(String... params) {
        try {
            AssetManager mngr = ctx.getAssets();

            try {
                cf = CertificateFactory.getInstance("X.509");
                caInput = new BufferedInputStream(mngr.open("cert/StartComClass1PrimaryIntermediateServerCA.crt"));
                ca = cf.generateCertificate(caInput);
                System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
            } catch (Exception e) {
                Log.d("post", e.toString());
            } finally {
                // Create a KeyStore containing our trusted CAs
                keyStoreType = KeyStore.getDefaultType();

                try {
                    keyStore = KeyStore.getInstance(keyStoreType);
                } catch (KeyStoreException e) {
                    e.printStackTrace();
                }

                try {
                    assert keyStore != null;
                    keyStore.load(null, null);

                    // Create a TrustManager that trusts the CAs in our KeyStore
                    tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
                    tmf = TrustManagerFactory.getInstance(tmfAlgorithm);

                    try {
                        keyStore.setCertificateEntry("ca", ca);

                        assert tmf != null;
                        tmf.init(keyStore);
                    } catch (KeyStoreException e) {
                        e.printStackTrace();
                    }

                    // Create an SSLContext that uses our TrustManager
                    try {
                        context = SSLContext.getInstance("TLS");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }

                    try {
                        assert context != null;
                        context.init(null, tmf.getTrustManagers(), null);
                    } catch (KeyManagementException e) {
                        e.printStackTrace();
                    }

                    try {
                        caInput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
                    e.printStackTrace();
                }
            }

            URL url = new URL(params[0]);
            HttpsURLConnection urlConnection =
                    (HttpsURLConnection) url.openConnection();

            String userCredentials = "x:x";
            String basicAuth = "Basic " + new String(Base64.encode(userCredentials.getBytes(), 0));

            urlConnection.setRequestProperty ("Authorization", basicAuth);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("Content-Language", "en-US");

            urlConnection.setUseCaches(false);
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            urlConnection.setSSLSocketFactory(context.getSocketFactory());

            Log.d("STATUS CODE",""+urlConnection.getResponseCode());

            InputStream in = urlConnection.getInputStream();
            copyInputStreamToOutputStream(in, System.out);

            return "ok";

        } catch (Exception e) {
            return "Network problem" + e.toString();
        }
    }

//    urlConnection.setSSLSocketFactory(getAllHostsValidSocketFactory());
//    private static SSLSocketFactory sAllHostsValidSocketFactory;
//    private static SSLSocketFactory getAllHostsValidSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
//        if (sAllHostsValidSocketFactory == null) {
//            TrustManager[] trustAllCerts = new TrustManager[]
//                    {new X509TrustManager() {
//                        @Override
//                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                            return null;
//                        }
//
//                        @Override
//                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
//                        }
//
//                        @Override
//                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
//                        }
//                    }};
//
//            SSLContext sc = SSLContext.getInstance("SSL");
//            sc.init(null, trustAllCerts, new java.security.SecureRandom());
//            sAllHostsValidSocketFactory = sc.getSocketFactory();
//        }
//        return sAllHostsValidSocketFactory;
//    }

    private void copyInputStreamToOutputStream(InputStream in, PrintStream out) throws IOException {
        Log.e("output", in.toString());

        byte[] buffer = new byte[1024]; // Adjust if you want
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
    }
}