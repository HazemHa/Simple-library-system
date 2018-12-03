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
public class Book {
    private int id;
    private String authorName;
    private String name;
    private double price;
    private String ISBN;
    private String img;
    private String Genre;
    private String description;
    private boolean isAvailable;

    public Book(int id, String authorName, String name, double price, String ISBN, String img, String Genre,String description,boolean isAvailable) {
        this.id = id;
        this.authorName = authorName;
        this.name = name;
        this.price = price;
        this.ISBN = ISBN;
        this.img = img;
        this.Genre = Genre;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public Book(int id, String authorName, String name, double price, String ISBN, String img, String Genre, String description) {
        this.id = id;
        this.authorName = authorName;
        this.name = name;
        this.price = price;
        this.ISBN = ISBN;
        this.img = img;
        this.Genre = Genre;
        this.description = description;
    }
    

    public Book(String authorName, String name, double price, String ISBN, String img, String Genre,String description,boolean isAvailable) {
        this.authorName = authorName;
        this.name = name;
        this.price = price;
        this.ISBN = ISBN;
        this.img = img;
        this.Genre = Genre;
        this.description =description;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", authorName=" + authorName + ", name=" + name + ", price=" + price + ", ISBN=" + ISBN + ", img=" + img + ", Genre=" + Genre + ", description=" + description + ", isAvailable=" + isAvailable + '}';
    }
    
    

}
