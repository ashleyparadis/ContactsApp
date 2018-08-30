package com.ashleyparadis.contactsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set action bar title
        getSupportActionBar().setTitle("Contacts App");

        //create array list of customers
        ArrayList<Customer> customerList = new ArrayList<>();

        //add customers to array list
        ApiCaller.getCustomers();
        for (Customer x:ApiCaller.getCustomers()){
            customerList.add(x);
        }

        //Log.d("customer", customerList.toString());

        ListAdapter adapter = new ListAdapter(this, R.layout.listofcustomers, customerList);
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
