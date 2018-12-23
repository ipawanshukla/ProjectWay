package com.example.hp.myapplication;

/**
 * Created by HP on 28-02-2018.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.ProgressBar;
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
import java.sql.Timestamp;

import static android.support.v4.content.ContextCompat.startActivity;


public class TestActivity extends AsyncTask<String,Integer,String> {
    Context contex;
    AlertDialog alertDialog;
    public String username;
    Intent intent;
    TestActivity (Context ctx) {
        contex = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String password;
        String result="";
        String line="";
        String busNo;
        String route;

        String login_url = "http://thethinkers.in/validatescan.php";
        if(type.equals("login")) {
            try {
                //user_name = new contact().getEU();
                username = params[1];
                password = params[2];
                //password = new contact().getEP();
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("scnres","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream =new BufferedInputStream( httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(contex).create();
        alertDialog.setTitle("Login Status");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onPostExecute(String result) {

        if(result.equals("success")){

            intent =new Intent(contex.getApplicationContext(),MainActivity.class);
            Toast.makeText(contex.getApplicationContext(),"Welcome "+username,Toast.LENGTH_LONG).show();
            contex.getApplicationContext().startActivity(intent);
        }
        else if(result.equals("failed")){
            Toast t2 = Toast.makeText(contex.getApplicationContext(),"Login Failed ",Toast.LENGTH_SHORT)  ;
            t2.show();

        }
        else {
            Toast t2 = Toast.makeText(contex.getApplicationContext(),result+"",Toast.LENGTH_SHORT)  ;
            t2.show();
        }



    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}



