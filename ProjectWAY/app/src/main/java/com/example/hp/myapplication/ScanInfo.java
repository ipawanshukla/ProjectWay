package com.example.hp.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by HP on 20-03-2018.
 */

public class ScanInfo extends AsyncTask<String,Void,String> {
    Context ct;
    StringBuilder sb = new StringBuilder();
    ScanInfo(Context ct)
    {
        this.ct = ct;
    }
    public TextView scantxt;
    Context context;
    Intent intent;
    String scan_url = "http://thethinkers.in/va.php";
    String result="";
    String line="";
    String scnres="";
    String user="";
    @Override
    protected void onPreExecute() {

    }
    @Override
    protected String doInBackground(String... params) {
        user = params[1];
        scnres = params[0];
        //scnres = params[0];
        try {
            scantxt = (TextView) scantxt.findViewById(R.id.scan_New);
            URL url = new URL(scan_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("barcode","UTF-8")+"="+URLEncoder.encode(scnres,"UTF-8")+"&"+URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream =new BufferedInputStream( httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            StringBuilder sb = new StringBuilder();
            while((line = bufferedReader.readLine())!= null) {
               sb.append(line);
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
        //return result;
    }

    @Override
    protected void onPostExecute(String result) {
    if(result.equals("success"))
    {
        Toast t2 = Toast.makeText(ct.getApplicationContext(),"Message ",Toast.LENGTH_SHORT)  ;
        t2.show();

    }
    else
    {
        Toast t2 = Toast.makeText(ct.getApplicationContext(),"Message Failed",Toast.LENGTH_SHORT)  ;
        t2.show();
    }


    }
}
