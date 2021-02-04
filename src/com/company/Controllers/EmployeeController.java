package com.company.Controllers;


import com.company.Models.User;
import com.company.Views.EmployeeView;

public class EmployeeController {
    EmployeeView employeeView;
    User employee;
    public EmployeeController(User user){
        employee=user;
        employeeView =new EmployeeView(employee);
        employeeView.clotheButton.addActionListener(e->addClothes());
        employeeView.customerButton.addActionListener(e->addCustomers());
        employeeView.signOutButton.addActionListener(e->signOut());
    }
    public void addCustomers(){
        new CustomersController();
    }
    public void addClothes(){
        new ClothesController();
    }
    public void signOut(){
        new LoginController();
        employeeView.dispose();
    }
}
