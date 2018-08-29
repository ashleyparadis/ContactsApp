package com.ashleyparadis.contactsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Contacts App");


        ArrayList<Customer> customerList = new ArrayList<>();

        ApiCaller.getCustomers();
        for (Customer x:ApiCaller.getCustomers()){
            customerList.add(x);
        }

        Log.d("customers", customerList.get(1).toString());


    }
}
