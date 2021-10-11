package org.example;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


public class HttpClient {


    public static void inicializar() {
        File trustStoreFile = new File("keystores/myTrustStore");
        char[] trustStorePassword = "123456".toCharArray();
        KeyStore keytrustStore = null;
        TrustManagerFactory tmf = null;
        SSLContext sslcertificate = null;
        try {
            keytrustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keytrustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
            tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keytrustStore);
            sslcertificate = SSLContext.getInstance("TLS");
            sslcertificate.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslcertificate);
        } catch (IOException | NoSuchAlgorithmException | CertificateException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
    }


    public static String getServicio() throws IOException {
        System.out.println("entre");
        URL urlString = new URL("https://ec2-3-84-24-31.compute-1.amazonaws.com:5005/servicio");
        HttpURLConnection con = (HttpURLConnection) urlString.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();

        }
    }
}
