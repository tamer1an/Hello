package com.tyco.visonic.interactive;

import android.content.Context;
import org.apache.http.impl.client.DefaultHttpClient;

public class MyHttpClient extends DefaultHttpClient {

    final Context context;

    public MyHttpClient(Context context) {
        this.context = context;
    }

/*    @Override
    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        // Register for port 443 our SSLSocketFactory with our keystore
        // to the ConnectionManager
        registry.register(new Scheme("https", newSslSocketFactory(), 443));
        return new SingleClientConnManager(getParams(), registry);
    }

    private SSLSocketFactory newSslSocketFactory() {
        try {
            // Get an instance of the Bouncy Castle KeyStore format
            KeyStore trusted = KeyStore.getInstance("BKS");
            // Get the raw resource, which contains the keystore with
            // your trusted certificates (root and any intermediate certs)
            InputStream in = context.getResources().openRawResource(R.raw.mykeystore);
            try {
                // Initialize the keystore with the provided trusted certificates
                // Also provide the password of the keystore
                trusted.load(in, "mysecret".toCharArray());
            } finally {
                in.close();
            }
            // Pass the keystore to the SSLSocketFactory. The factory is responsible
            // for the verification of the server certificate.
            SSLSocketFactory sf = new SSLSocketFactory(trusted);
            // Hostname verification from certificate
            // http://hc.apache.org/httpcomponents-client-ga/tutorial/html/connmgmt.html#d4e506
            sf.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            return sf;
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }*/
}





// Instantiate the custom HttpClient
//DefaultHttpClient client = new MyHttpClient(getApplicationContext());
//HttpGet get = new HttpGet("https://www.mydomain.ch/rest/contacts/23");
//// Execute the GET call and obtain the response
//HttpResponse getResponse = client.execute(get);
//HttpEntity responseEntity = getResponse.getEntity();

//    public static HttpClient createHttpClient(){
//        try {
//            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            trustStore.load(null, null);
//
//            SSLSocketFactory sf = new MySSLSocketFactory(trustStore);
//            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//
//            HttpParams params = new BasicHttpParams();
//            HttpConnectionParams.setConnectionTimeout(params, 15000);
//            HttpConnectionParams.setSoTimeout(params, 5000);
//
//            SchemeRegistry registry = new SchemeRegistry();
//            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
//            registry.register(new Scheme("https", sf, 443));
//
//            ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
//
//            return new DefaultHttpClient(ccm, params);
//        } catch (Exception e) {
//            return new DefaultHttpClient();
//        }
//    }












////////////////////// REQUEST TASk

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