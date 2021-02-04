package com.company.Views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginView extends JFrame {
    JPanel jPanel;
    SpringLayout springLayout;
    JLabel usernameLabel,passwordLabel;
    public JTextField usernameTextField,passwordTextField;
    Container contentPage;
    public JButton loginButton = new JButton("login");
    public LoginView(){
        setTitle("Login Page");
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
        contentPage.add(loginButton);
        springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 100, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 100, SpringLayout.NORTH, contentPage);
        springLayout.putConstraint(SpringLayout.WEST, usernameTextField, 50, SpringLayout.EAST, usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, usernameTextField, 100, SpringLayout.NORTH, contentPage);
        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 100, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 100, SpringLayout.NORTH, usernameLabel);
        springLayout.putConstraint(SpringLayout.WEST, passwordTextField, 50, SpringLayout.EAST, passwordLabel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordTextField, 100, SpringLayout.NORTH, usernameTextField);
        springLayout.putConstraint(SpringLayout.WEST, loginButton, 250, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 100, SpringLayout.NORTH, passwordLabel);
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(jPanel);
        setVisible(true);
    }
}
