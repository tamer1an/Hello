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

//          urlConnection.setRequestMethod("GET");
//          urlConnection.setRequestProperty("User-Agent", USER_AGENT);

            String userCredentials = "X:X";
            String basicAuth = "Basic " + new String(Base64.encode(userCredentials.getBytes(), 0));
            urlConnection.setRequestProperty ("Authorization", basicAuth);

//          urlConnection.setRequestProperty("Content-Type", "application/xml"); //"application/x-www-form-urlencoded"
//          urlConnection.setRequestProperty("Accept", "application/json");

//          urlConnection.setRequestProperty("Content-Language", "en-US");
//          urlConnection.setRequestProperty("Content-Length", "0");

            Log.d("STATUS CODE",""+urlConnection.getResponseCode());
            Log.d("RESP MSG",""+urlConnection.getResponseMessage());

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
            }
//            out.println(sb.toString());
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return sb;
    }
}

/*

//        byte[] buffer = new byte[1024]; // Adjust if you want
//        int bytesRead;
//        while ((bytesRead = in.read(buffer)) != -1) {
//            out.write(buffer, 0, bytesRead);
//        }

//        int bytesRead = -1;
//        byte[] buffer = new byte[1024];
//        while ((bytesRead = in.read(buffer)) >= 0) {
//            out.write(buffer, 0, bytesRead);
//        }


///////////////////////////////////////////////////
    java.security.cert.Certificate ca;
    InputStream caInput;
    CertificateFactory cf;

    String keyStoreType;
    KeyStore keyStore = null;
    String tmfAlgorithm;
    TrustManagerFactory tmf = null;

    SSLContext context = null;
    Context ctx;

    {
        try {
            AssetManager mngr = ctx.getAssets();

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
    }
*/

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