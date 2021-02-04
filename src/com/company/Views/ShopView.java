package com.company.Views;

import com.company.Models.ShopModel;
import com.company.Models.User;

import javax.swing.*;
import java.awt.*;

public class ShopView extends JFrame {
    User customer;
    ShopModel model;
    JPanel jPanel;
    SpringLayout springLayout;
    public Container contentPage;
    private JLabel label;
    public JTable products=null,cart=null;
    public JScrollPane cartScroll,productsScroll;
    public JButton buyButton = new JButton("BUY");
    public JButton signOutButton = new JButton("Sign Out");
    public ShopView(User customer,ShopModel model){
        this.customer=customer;
        this.model=model;
        setTitle("Shopping Page");
        label=new JLabel("WELCOME "+customer.getUsername());
        contentPage=getContentPane();
        jPanel=new JPanel();
        springLayout = new SpringLayout();
        contentPage.setLayout(springLayout);
        contentPage.add(label);
        contentPage.add(signOutButton);
        contentPage.add(buyButton);
        setTables();
        springLayout.putConstraint(SpringLayout.WEST, label, 50, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, label, 30, SpringLayout.NORTH, contentPage);

        springLayout.putConstraint(SpringLayout.WEST, signOutButton, 240, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, signOutButton, 75, SpringLayout.NORTH, contentPage);

        springLayout.putConstraint(SpringLayout.WEST, buyButton, 250, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, buyButton, 150, SpringLayout.NORTH, contentPage);

        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(jPanel);
        setVisible(true);
    }
    public void setTables(){
        products=new JTable(model.getClothesAsTable(),model.getHead());
        cart=new JTable(model.getOrders());

        cartScroll=new JScrollPane(cart);
        productsScroll=new JScrollPane(products);

        contentPage.add(productsScroll);
        contentPage.add(cartScroll);

        springLayout.putConstraint(SpringLayout.WEST, productsScroll, 0, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, productsScroll, 200, SpringLayout.NORTH, contentPage);
        springLayout.putConstraint(SpringLayout.SOUTH, productsScroll, 0, SpringLayout.SOUTH, contentPage);

        springLayout.putConstraint(SpringLayout.WEST, cartScroll, 0, SpringLayout.EAST, productsScroll);
        springLayout.putConstraint(SpringLayout.NORTH, cartScroll, 200, SpringLayout.NORTH, contentPage);
        springLayout.putConstraint(SpringLayout.EAST, cartScroll, 0, SpringLayout.EAST, contentPage);
        springLayout.putConstraint(SpringLayout.SOUTH, cartScroll, 0, SpringLayout.SOUTH, contentPage);
    }
}
