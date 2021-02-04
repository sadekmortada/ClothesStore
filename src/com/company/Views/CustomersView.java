package com.company.Views;

import com.company.Models.CustomersModel;
import com.company.Models.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomersView extends JFrame {
    private CustomersModel model;
    JPanel jPanel;
    SpringLayout springLayout;
    JLabel usernameLabel,passwordLabel;
    public JTextField usernameTextField,passwordTextField;
    public Container contentPage;
    public JButton addButton = new JButton("Add New Customer");
    public JButton removeButton = new JButton("Remove");
    public JComboBox jComboBox;
    public CustomersView(CustomersModel model){
        this.model=model;
        setTitle("Manage Customers Page");
        usernameLabel= new JLabel("Username: ");
        passwordLabel=new JLabel("Password: ");
        usernameTextField=new JTextField("", 20);
        passwordTextField=new JTextField("", 20);
        contentPage=getContentPane();
        jPanel=new JPanel();
        springLayout = new SpringLayout();
        contentPage.setLayout(springLayout);
        contentPage.add(usernameLabel);
        contentPage.add(usernameTextField);
        contentPage.add(passwordLabel);
        contentPage.add(passwordTextField);
        contentPage.add(addButton);
        setComboBox();
        springLayout.putConstraint(SpringLayout.WEST, addButton, 225, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, addButton, 100, SpringLayout.NORTH, contentPage);

        springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 50, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 50, SpringLayout.NORTH, addButton);

        springLayout.putConstraint(SpringLayout.WEST, usernameTextField, 50, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, usernameTextField, 30, SpringLayout.NORTH, usernameLabel);

        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 210, SpringLayout.EAST, usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 50, SpringLayout.NORTH, addButton);

        springLayout.putConstraint(SpringLayout.WEST, passwordTextField, 50, SpringLayout.EAST, usernameTextField);
        springLayout.putConstraint(SpringLayout.NORTH, passwordTextField, 30, SpringLayout.NORTH, passwordLabel);



        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(jPanel);
        setVisible(true);
    }
    public void setComboBox(){
        if(model.getCustomersNames()!=null) {
            jComboBox = new JComboBox(model.getCustomersNames());
            contentPage.add(jComboBox);
            springLayout.putConstraint(SpringLayout.WEST, jComboBox, 80, SpringLayout.WEST, contentPage);
            springLayout.putConstraint(SpringLayout.NORTH, jComboBox, 150, SpringLayout.NORTH, usernameTextField);
            jComboBox.setPrototypeDisplayValue("Choose Customer to Remove");
            contentPage.add(removeButton);
            removeButton.setText("Remove "+jComboBox.getSelectedItem().toString());
            springLayout.putConstraint(SpringLayout.WEST, removeButton, 50, SpringLayout.EAST, jComboBox);
            springLayout.putConstraint(SpringLayout.NORTH, removeButton, 150, SpringLayout.NORTH, passwordTextField);
        }
    }
}
