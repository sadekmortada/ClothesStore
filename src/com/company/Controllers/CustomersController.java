package com.company.Controllers;

import com.company.FileManager;
import com.company.Models.CustomersModel;
import com.company.Models.User;
import com.company.Views.CustomersView;
import com.company.Views.EmployeeView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CustomersController {
    CustomersView customersView;
    CustomersModel customersModel;

    public CustomersController() {
        customersModel = new CustomersModel();
        customersView = new CustomersView(customersModel);
        customersView.addButton.addActionListener(e -> addCustomer());
        customersView.removeButton.addActionListener(e -> removeCustomer());
        if(customersView.jComboBox!=null)
            customersView.jComboBox.addActionListener(e->selectCustomer());
    }

    public void addCustomer() {
        String result=FileManager.addCustomer(customersView.usernameTextField.getText(),customersView.passwordTextField.getText());
        JOptionPane.showMessageDialog(customersView,result);
        if(result.equals("Customer Added Successfully")) {
            customersModel.setCustomers();
            customersView.contentPage.remove(customersView.jComboBox);
            customersView.contentPage.remove(customersView.removeButton);
            customersView.setComboBox();
        }
    }

    public void removeCustomer() {
        FileManager.removeCustomer(customersView.jComboBox.getSelectedItem().toString());
        JOptionPane.showMessageDialog(customersView,"Customer is Removed Successfully");
        customersModel.setCustomers();
        customersView.contentPage.remove(customersView.jComboBox);
        customersView.contentPage.remove(customersView.removeButton);
        customersView.setComboBox();
    }

    public void selectCustomer(){
        customersView.removeButton.setText("Remove "+customersView.jComboBox.getSelectedItem().toString());
    }
}
