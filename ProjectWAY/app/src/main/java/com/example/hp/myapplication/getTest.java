package com.example.hp.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by HP on 24-03-2018.
 */

public class getTest extends AsyncTask <String,Integer,String> {
    Context ct;
getTest(Context ct )
{
    this.ct = ct;
}
    @Override
    protected String doInBackground(String... params) {
        try {
            String user = (String) params[0];
            String scanres = (String) params[1];
            String link = "http://thethinkers.in/validatescan2?user=" + user + "& barcode=" + scanres;

            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";

            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }

            in.close();
            return sb.toString();
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("success")) {
            new contact().setScan(true);

        } else {
           new contact().setScan(false);
        }
    }
}
