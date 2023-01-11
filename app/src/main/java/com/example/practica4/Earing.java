package com.example.practica4;

public class Earing {

    private int id;
    private String name;
    private String description;
    private int imageResource;

    public Earing(String name, String description, int imageResource) {
        this.name = name;
        this.description = description;
        this.imageResource= imageResource;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getImageResource(){
        return imageResource;
    }
}
