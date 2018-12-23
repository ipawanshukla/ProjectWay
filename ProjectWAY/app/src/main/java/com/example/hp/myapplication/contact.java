package com.example.hp.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by HP on 17-03-2018.
 */

public class contact extends AppCompatActivity  {
    Intent intent;
    String user,pass;
    boolean r;
    Context conte;
    String tes;
    String scanres;
    Boolean scan;
Context context;
    void setValue(String eu , String ep)
    {
        user = eu;
        pass = ep;
    }
    void setResult(boolean res)
    {
        r = res;
    }
    void launchBus()
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    String getEU()
    {
        return user;
    }
    String getEP()
    {
        return pass;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    boolean getResult( )
    {

       return this.r;
    }
    void setScanres(String r)
    {
        scanres= r;
    }
    Boolean getscan()
    {
        return scan;
    }
    String tryres(String res)
    {
    String test= res;
        return test ;
    }
    void setScan(Boolean t)
    {
        scan = t;
        this.callLog();

    }
    void callLog()
    {
        intent =new Intent(conte.getApplicationContext(),MainActivity.class);
        Toast.makeText(conte.getApplicationContext(),"Welcome "+user,Toast.LENGTH_LONG).show();
        conte.getApplicationContext().startActivity(intent);
    }


}
