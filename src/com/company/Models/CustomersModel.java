package com.company.Models;

import com.company.FileManager;

import java.util.ArrayList;

public class CustomersModel {
    public ArrayList<User> customers;
    public CustomersModel(){
        setCustomers();
    }
    public void setCustomers(){
        customers= FileManager.getCustomers();
    }
    public Object[] getCustomersNames(){
        if(customers==null)
            return null;
        ArrayList<String> temp=new ArrayList<>();
        for(int i=0;i<customers.size();i++)
            temp.add(customers.get(i).getUsername());
        return temp.toArray();
    }
}
