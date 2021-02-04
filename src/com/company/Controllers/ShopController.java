package com.company.Controllers;

import com.company.FileManager;
import com.company.Models.Clothe;
import com.company.Models.ShopModel;
import com.company.Models.User;
import com.company.Views.EmployeeView;
import com.company.Views.ShopView;

import javax.swing.*;
import java.util.ArrayList;

public class ShopController {
    ShopModel model;
    ShopView shopView;
    User customer;
    public ShopController(User user) {
        customer=user;
        model=new ShopModel();
        shopView =new ShopView(user,model);
        shopView.buyButton.addActionListener(e->buyOrder());
        shopView.signOutButton.addActionListener(e->signOut());
    }

    public void signOut(){
        new LoginController();
        shopView.dispose();
    }
    public void buyOrder(){
        ArrayList<Clothe> order=new ArrayList<>();
        for(int temp=0,i=0;i<model.getClothes().size();i++,temp++)
            if((boolean)model.getOrders().getValueAt(temp,0)) {
                order.add(model.getClothes().get(i));
                int quantity=Integer.parseInt(model.getClothes().get(i).getQuantity());
                quantity--;
                if (quantity!=0)
                    model.getClothes().get(i).setQuantity(Integer.toString(quantity));
                else
                    model.getClothes().remove(i--);
            }
        FileManager.addTransaction(order,customer);
        JOptionPane.showMessageDialog(shopView, "Transaction Done Successfully");
        FileManager.saveClothes(model.getClothes());
        new ShopController(customer);
        shopView.dispose();
    }
}
