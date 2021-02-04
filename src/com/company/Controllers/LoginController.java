package com.company.Controllers;

import com.company.FileManager;
import com.company.Models.User;
import com.company.Views.LoginView;

import javax.swing.*;

public class LoginController {
    LoginView loginView;
    private static User user;
    public LoginController(){
        loginView= new LoginView();
        loginView.loginButton.addActionListener(e->login());
    }
    public void login(){
        String username = loginView.usernameTextField.getText();
        String password=loginView.passwordTextField.getText();
        user= FileManager.checkUser(username,password);
        if(user==null)
            JOptionPane.showMessageDialog(loginView, "ERROR\n\nUser Not Found!");
        else {
            if(user.getRole().equals("employee"))
                new EmployeeController(user);
            else
                new ShopController(user);
            loginView.dispose();
        }
    }

    public static void main(String[] args) {
        new LoginController();
    }
}
