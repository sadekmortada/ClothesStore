package com.company.Models;

import com.company.FileManager;

import java.util.ArrayList;

public class ClothesModel {
     String[] types={"T shirt","Trouser","Short","Pants","Jacket"};
     String[] names={"Lacoste","Giorgio Armani","Adidas","Gizia"};
     String[] sizes={"XLarge","Large","Medium","Small"};
     String[] genders={"Male","Female"};

    public String[] getGenders() {
        return genders;
    }

    public void setGenders(String[] genders) {
        this.genders = genders;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getSizes() {
        return sizes;
    }

    public void setSizes(String[] sizes) {
        this.sizes = sizes;
    }

}
