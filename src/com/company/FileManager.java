package com.company;

import com.company.Models.Clothe;
import com.company.Models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private static File usersFile = new File("res\\users.txt"),clothesFile = new File("res\\clothes.txt"),soldOutFile=new File("res\\soldout.txt");
    private static Scanner reader;
    private static FileWriter fileWriter;
    public static User checkUser(String username, String password){
        try {
            reader = new Scanner(usersFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String []parameters=data.split(",");
            if(parameters[0].equals(username)&&parameters[1].equals(password)) {
                reader.close();
                return new User(parameters[0], parameters[1], parameters[2]);
            }
        }
        reader.close();
        return null;
    }
    public static ArrayList<User> getCustomers(){
        ArrayList<User> customers= new ArrayList<>();
        try {
            reader = new Scanner(usersFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String []parameters=data.split(",");
            if (parameters[2].equals("customer"))
                customers.add(new User(parameters[0], parameters[1], parameters[2]));
        }
        reader.close();
        if (customers.size()==0)
            customers=null;
        return customers;
    }
    public static String addCustomer(String username, String password){
        if(username.equals("")||password.equals("")) {
            return  "ERROR\n\nUsername and password cant be null.";
        }
        try {
            reader = new Scanner(usersFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] parameters = data.split(",");
            if(username.equals(parameters[0])) {
                reader.close();
                return "ERROR\n\nUser of same name exists!";
            }
        }
        reader.close();
        try {
            fileWriter=new FileWriter(usersFile,true);
            fileWriter.write("\n"+username+","+password+","+"customer");
            fileWriter.close();
        } catch (IOException e) {}
        return "Customer Added Successfully";
    }
    public static void removeCustomer(String username){
        ArrayList<User> users=getUsers();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(username)) {
                users.remove(i);
                break;
            }
        }
        try {
            fileWriter=new FileWriter(usersFile);
            for(int i=0;i<users.size();i++) {
                fileWriter.write(users.get(i).getUsername() + "," + users.get(i).getPassword() + "," + users.get(i).getRole());
                if(i!=users.size()-1)
                    fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {}
    }
    public static ArrayList<User> getUsers(){
        ArrayList<User> users= new ArrayList<>();
        try {
            reader = new Scanner(usersFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String []parameters=data.split(",");
            users.add(new User(parameters[0], parameters[1], parameters[2]));
        }
        reader.close();
        if (users.size()==0)
            users=null;
        return users;
    }
    public static ArrayList<Clothe> getClothes(){
        ArrayList<Clothe> clothes= new ArrayList<>();
        try {
            reader = new Scanner(clothesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String []parameters=data.split(",");
            clothes.add(new Clothe(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5],parameters[6]));
        }
        reader.close();
        if (clothes.size()==0)
            clothes=null;
        return clothes;
    }
    public static String addClothe(String name,String type,String size,String color, String gender,String cost, String quantity){
        if(color.equals("")||cost.equals("")||quantity.equals("")) {
            return  "ERROR\n\nColor, cost and quantity cant be null.";
        }
        try {
            reader = new Scanner(clothesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] parameters = data.split(",");
            if(name.equals(parameters[0])&&color.equals(parameters[1])&&type.equals(parameters[2])&&size.equals(parameters[3])&&gender.equals(parameters[4])) {
                reader.close();
                return "ERROR\n\nSame item exists in stock";
            }
        }
        reader.close();
        try {
            fileWriter=new FileWriter(clothesFile,true);
            fileWriter.write("\n"+name+","+color+","+type+","+size+","+gender+","+cost+","+quantity);
            fileWriter.close();
        } catch (IOException e) {}
        return "Item Added Successfully";
    }
    public static void addTransaction(ArrayList<Clothe> order, User user){
        try {
            fileWriter=new FileWriter(soldOutFile,true);
            for(int i=0;i<order.size();i++)
                fileWriter.write("\n"+order.get(i).getName() + "," + order.get(i).getColor() + "," + order.get(i).getType() + "," + order.get(i).getSize() + "," + order.get(i).getGender() + " Bought By "+user.getUsername());
            fileWriter.close();
        } catch (IOException e) {}
    }
    public static void saveClothes(ArrayList<Clothe> clothes){
        if(clothes.size()==0)
            return;
        try {
            fileWriter=new FileWriter(clothesFile);
            for(int i=0;i<clothes.size();i++) {
                fileWriter.write(clothes.get(i).getName() + "," + clothes.get(i).getColor() + "," + clothes.get(i).getType() + "," + clothes.get(i).getSize() + "," + clothes.get(i).getGender() + "," + clothes.get(i).getCost() + "," + clothes.get(i).getQuantity());
                if(i!=clothes.size()-1)
                    fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {}
    }
}
