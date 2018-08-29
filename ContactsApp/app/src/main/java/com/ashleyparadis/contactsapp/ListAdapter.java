package com.ashleyparadis.contactsapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Customer> {

    Context context;
    int layoutResourceId;
    ArrayList<com.ashleyparadis.contactsapp.Customer> data = null;

    public ListAdapter(Context context, int layoutResourceId, ArrayList<com.ashleyparadis.contactsapp.Customer> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomerList list = null;

        if(convertView == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);

            list = new CustomerList();
            list.customerName = (TextView)convertView.findViewById(R.id.customerName);
            list.phoneNumber = (TextView)convertView.findViewById(R.id.customerPhoneNumber);

            convertView.setTag(list);
        }
        else
        {
            list = (CustomerList)convertView.getTag();
        }

        com.ashleyparadis.contactsapp.Customer customerList = data.get(position);
        list.customerName.setText(customerList.getName());
        list.phoneNumber.setText(customerList.getPhoneNumber());

        return convertView;
    }

    static class CustomerList
    {
        TextView customerName;
        TextView phoneNumber;

    }
}
