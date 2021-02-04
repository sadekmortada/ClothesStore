package com.company.Views;

import com.company.Models.User;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {
    User model;
    JPanel jPanel;
    BoxLayout boxLayout;
    Container contentPage;
    public JButton customerButton = new JButton("Manage Customers");
    public JButton clotheButton = new JButton("Manage Clothes");
    public JButton signOutButton = new JButton("Sign Out");
    private JLabel label;
    public EmployeeView(User employee){
        this.model=employee;
        label=new JLabel("WELCOME "+employee.getUsername());
        setTitle("Employee Page");
        contentPage=getContentPane();
        jPanel=new JPanel();
        boxLayout = new BoxLayout(contentPage,BoxLayout.Y_AXIS);
        customerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clotheButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signOutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPage.setLayout(boxLayout);
        contentPage.add(Box.createRigidArea(new Dimension(0, 100)));
        contentPage.add(label);
        contentPage.add(Box.createRigidArea(new Dimension(0, 50)));
        contentPage.add(customerButton);
        contentPage.add(Box.createRigidArea(new Dimension(0, 50)));
        contentPage.add(clotheButton);
        contentPage.add(Box.createRigidArea(new Dimension(0, 50)));
        contentPage.add(signOutButton);
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(jPanel);
        setVisible(true);
    }
}
