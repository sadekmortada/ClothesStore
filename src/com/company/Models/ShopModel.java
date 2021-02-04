package com.company.Models;

import com.company.FileManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Random;

public class ShopModel {
    ArrayList<Clothe> clothes;
    DefaultTableModel orders;
    String[] head={"Name","Type","Color","Size","Gender","Cost($)","Available"};
    public ShopModel(){
        setClothes();
    }
    public void setClothes(){
        clothes= FileManager.getClothes();
        orders = new DefaultTableModel(new Object[]{"Add To Cart"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Boolean.class;
            }
        };
        for (int index = 0; index < clothes.size(); index++)
            orders.addRow(new Object[]{false});
    }
    public Object[][] getClothesAsTable() {
        Object[][] objects = new Object[clothes.size()][8];
        for (int i = 0; i < clothes.size(); i++) {
            Object[] temp = {clothes.get(i).getName(), clothes.get(i).getType(), clothes.get(i).getColor(), clothes.get(i).getSize(), clothes.get(i).getGender(), clothes.get(i).getCost(), clothes.get(i).getQuantity()};
            objects[i] = temp;
        }
        return objects;
    }


    public ArrayList<Clothe> getClothes() {
        return clothes;
    }

    public void setClothes(ArrayList<Clothe> clothes) {
        this.clothes = clothes;
    }

    public String[] getHead() {
        return head;
    }

    public void setHead(String[] head) {
        this.head = head;
    }

    public DefaultTableModel getOrders() {
        return orders;
    }
}
