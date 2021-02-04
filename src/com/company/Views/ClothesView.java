package com.company.Views;

import com.company.Models.ClothesModel;
import com.company.Models.CustomersModel;

import javax.swing.*;
import java.awt.*;

public class ClothesView extends JFrame{
    private ClothesModel model;
    JPanel jPanel;
    SpringLayout springLayout;
    JLabel size,name,type,cost,quantity,color,gender;
    public JTextField costTextField,colorTextField,quantityTextField;
    public Container contentPage;
    public JButton addButton = new JButton("Add New Clothe");
    public JComboBox sizes,names,types,genders;
    public ClothesView(ClothesModel model){
        this.model=model;
        setTitle("Manage Clothes Page");
        size= new JLabel("Choose Size: ");
        name=new JLabel("Choose Name: ");
        type= new JLabel("Choose Type: ");
        quantity=new JLabel("Choose Quantity: ");
        cost= new JLabel("Choose Cost(in $): ");
        color=new JLabel("Choose Color: ");
        gender=new JLabel("Choose Gender: ");;
        costTextField=new JTextField("", 4);
        quantityTextField=new JTextField("", 4);
        colorTextField=new JTextField("", 8);
        contentPage=getContentPane();
        jPanel=new JPanel();
        springLayout = new SpringLayout();
        contentPage.setLayout(springLayout);
        contentPage.add(name);
        contentPage.add(size);
        contentPage.add(type);
        contentPage.add(cost);
        contentPage.add(addButton);
        contentPage.add(quantity);
        contentPage.add(color);
        contentPage.add(gender);
        contentPage.add(costTextField);
        contentPage.add(colorTextField);
        contentPage.add(quantityTextField);
        springLayout.putConstraint(SpringLayout.WEST, addButton, 225, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, addButton, 100, SpringLayout.NORTH, contentPage);

        springLayout.putConstraint(SpringLayout.WEST, name, 75, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, name, 50, SpringLayout.NORTH, addButton);

        springLayout.putConstraint(SpringLayout.WEST, type, 75, SpringLayout.EAST, name);
        springLayout.putConstraint(SpringLayout.NORTH, type, 50, SpringLayout.NORTH, addButton);

        springLayout.putConstraint(SpringLayout.WEST, size, 75, SpringLayout.EAST, type);
        springLayout.putConstraint(SpringLayout.NORTH, size, 50, SpringLayout.NORTH, addButton);

        setComboBoxes();

        springLayout.putConstraint(SpringLayout.WEST, gender, 75, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, gender, 75, SpringLayout.NORTH, names);

        springLayout.putConstraint(SpringLayout.WEST, color, 40, SpringLayout.EAST, gender);
        springLayout.putConstraint(SpringLayout.NORTH, color, 75, SpringLayout.NORTH, names);

        springLayout.putConstraint(SpringLayout.WEST, cost, 40, SpringLayout.EAST, color);
        springLayout.putConstraint(SpringLayout.NORTH, cost, 75, SpringLayout.NORTH, types);

        springLayout.putConstraint(SpringLayout.WEST, quantity, 40, SpringLayout.EAST, cost);
        springLayout.putConstraint(SpringLayout.NORTH, quantity, 75, SpringLayout.NORTH, sizes);

        springLayout.putConstraint(SpringLayout.WEST, colorTextField, 20, SpringLayout.EAST, genders);
        springLayout.putConstraint(SpringLayout.NORTH, colorTextField, 30, SpringLayout.NORTH, color);

        springLayout.putConstraint(SpringLayout.WEST, costTextField, 33, SpringLayout.EAST, colorTextField);
        springLayout.putConstraint(SpringLayout.NORTH, costTextField, 30, SpringLayout.NORTH, cost);

        springLayout.putConstraint(SpringLayout.WEST, quantityTextField, 100, SpringLayout.EAST, costTextField);
        springLayout.putConstraint(SpringLayout.NORTH, quantityTextField, 30, SpringLayout.NORTH, quantity);

        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(jPanel);
        setVisible(true);
    }
    public void setComboBoxes(){
        names = new JComboBox(model.getNames());
        names.setPrototypeDisplayValue("____________");
        contentPage.add(names);
        springLayout.putConstraint(SpringLayout.WEST, names, 75, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, names, 30, SpringLayout.NORTH, name);
        types = new JComboBox(model.getTypes());
        types.setPrototypeDisplayValue("____________");
        contentPage.add(types);
        springLayout.putConstraint(SpringLayout.WEST, types, 157, SpringLayout.WEST, names);
        springLayout.putConstraint(SpringLayout.NORTH, types, 30, SpringLayout.NORTH, type);
        sizes = new JComboBox(model.getSizes());
        sizes.setPrototypeDisplayValue("____________");
        contentPage.add(sizes);
        springLayout.putConstraint(SpringLayout.WEST, sizes, 157, SpringLayout.WEST, types);
        springLayout.putConstraint(SpringLayout.NORTH, sizes, 30, SpringLayout.NORTH, size);
        genders = new JComboBox(model.getGenders());
        genders.setPrototypeDisplayValue("____________");
        contentPage.add(genders);
        springLayout.putConstraint(SpringLayout.WEST, genders, 75, SpringLayout.WEST, contentPage);
        springLayout.putConstraint(SpringLayout.NORTH, genders, 30, SpringLayout.NORTH, gender);
    }
}
