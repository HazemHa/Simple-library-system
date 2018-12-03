/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Hazem
 */
public class Magazin {
    private int id;
    private String name;
    private String image;
    private String Publishing ;
    private double price;
    private String Genre;
    private String description;
    private boolean isAvailable;

    public Magazin(int id, String name, String image, String Publishing, double price, String Genre,String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.Publishing = Publishing;
        this.price = price;
        this.Genre = Genre;
        this.description = description;
    }

    public Magazin(String name, String image, String Publishing, double price, String Genre,String description) {
        this.name = name;
        this.image = image;
        this.Publishing = Publishing;
        this.price = price;
        this.Genre = Genre;
        this.description = description;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishing() {
        return Publishing;
    }

    public void setPublishing(String Publishing) {
        this.Publishing = Publishing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

   
    
}
