package com.example.hp.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class BusRoute extends AppCompatActivity {



        public Spinner  spinner2;
        //public Button btnSubmit;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bus_route);

            addItemsOnSpinner2();
            //addListenerOnButton();
            //addListenerOnSpinnerItemSelection();

        }

        //add items into spinner dynamically
        public void addItemsOnSpinner2() {

            spinner2 = (Spinner) findViewById(R.id.spinner);
            List<String> list = new ArrayList<String>();
            list.add("list 1");
            list.add("list 2");
            list.add("list 3");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(dataAdapter);
        }

       /* public void addListenerOnSpinnerItemSelection(){

            spinner1 = (Spinner) findViewById(R.id.spinner);
            spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        }

        //get the selected dropdown list value
        public void addListenerOnButton() {

            spinner1 = (Spinner) findViewById(R.id.spinner1);
            spinner2 = (Spinner) findViewById(R.id.spinner2);

            btnSubmit = (Button) findViewById(R.id.btnSubmit);

            btnSubmit.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    Toast.makeText(MyAndroidAppActivity.this,
                            "OnClickListener : " +
                                    "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                                    "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
                            Toast.LENGTH_SHORT).show();
                }

            });*/

        }



