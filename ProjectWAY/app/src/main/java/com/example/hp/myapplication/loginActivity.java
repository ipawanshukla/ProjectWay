package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {
   // Animation fromtop;
   //public  Intent i = new Intent(loginActivity.this,MainActivity.class);
   // ImageView iv;
   /*public Intent getintent()
   {
       return i;
   }*/
   public static Activity fa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_two);
        fa = this;
        ///final Button bLogin = (Button) findViewById(R.id.bLogin);
        //inal String type = "login";

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bLogin)
        {
            String type="login";
            EditText etUsername = findViewById(R.id.etUserName);
            EditText etPassword = findViewById(R.id.etPass);
            EditText etBusNumber = findViewById(R.id.etBus);
            EditText etRoute = findViewById(R.id.etRoute);
            String busNo = etBusNumber.getText().toString().toUpperCase();
            String route = etRoute.getText().toString();
            String eu = etUsername.getText().toString();
            String ep = etPassword.getText().toString();
            new contact().setValue(eu,ep);
            BackgroundWorker bw = new BackgroundWorker(loginActivity.this);
            bw.execute(type,eu,ep,busNo,route);



        }


    }
    public void st()
    {
        if(new contact().getResult())
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }
}
// bw.execute("login",eu,ep);
                /*SharedPreferences sp = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString("username",eu);
                spe.putString("password",ep);
                spe.apply();*/

              /*
               Cursor res = dbh.getAllData();
                while(res.moveToNext())
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "ID is :: "+ res.getString(0)+"Name is "+ res.getString(1)+"Pass is "+ res.getString(2), Toast.LENGTH_SHORT);
                    toast.show();
                }


              if(eu.equals("pawan")&& ep.equals("goforit")) {
                    startActivity(new Intent(loginActivity.this, MainActivity.class));
                    Toast t2 = Toast.makeText(getApplicationContext(),"Welcome "+eu,Toast.LENGTH_SHORT)  ;
                    t2.show();
                }
else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "invalid password", Toast.LENGTH_SHORT);
                    toast.show();
                }*/
              /*String type = "login";
              BackgroundWorker bw = new BackgroundWorker(loginActivity.this);
              bw.execute(type,eu,ep);
                SharedPreferences sp = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString("username",eu);
                spe.putString("password",ep);
                spe.apply();*/



