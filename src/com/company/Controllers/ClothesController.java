package com.company.Controllers;

import com.company.FileManager;
import com.company.Models.ClothesModel;
import com.company.Models.CustomersModel;
import com.company.Views.ClothesView;
import com.company.Views.CustomersView;

import javax.swing.*;

public class ClothesController {
    ClothesView clothesView;
    ClothesModel clothesModel;

    public ClothesController() {
        clothesModel = new ClothesModel();
        clothesView = new ClothesView(clothesModel);
        clothesView.addButton.addActionListener(e -> addClothe());
    }

    public void addClothe() {
        String result= FileManager.addClothe(clothesView.names.getSelectedItem().toString(),clothesView.types.getSelectedItem().toString(),clothesView.sizes.getSelectedItem().toString(),clothesView.colorTextField.getText(),clothesView.genders.getSelectedItem().toString(),clothesView.costTextField.getText(),clothesView.quantityTextField.getText());
        JOptionPane.showMessageDialog(clothesView,result);
    }
}
