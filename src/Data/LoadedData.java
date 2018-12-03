/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Models.Bill;
import Models.Book;
import Models.CartList;
import Models.Magazin;
import Models.User;
import java.util.ArrayList;

/**
 *
 * @author Hazem
 */
public class LoadedData {

    private ArrayList<Book> Books;
    private ArrayList<CartList> cartList;
    private ArrayList<User> users;
    private ArrayList<Magazin> magazins;
    private ArrayList<Bill> bills;
    private User CurrentUser;
    private static LoadedData Instance;

    private LoadedData() {
        Books = new ArrayList<>();
        cartList = new ArrayList<>();
        users = new ArrayList<>();
        magazins = new ArrayList<>();
        bills = new ArrayList<>();
    }

    public static LoadedData getInstance() {
        if (Instance == null) {
            Instance = new LoadedData();
        }

        return Instance;
    }

    public ArrayList<Book> getBooks() {
        return Books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setBooks(ArrayList<Book> Books) {
        this.Books = Books;
    }

    public ArrayList<CartList> getCartList() {
        return cartList;
    }

    public void setCartList(ArrayList<CartList> cartList) {
        this.cartList = cartList;
    }


    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }
    
    

    public User getCurrentUser() {
        return CurrentUser;
    }

    public void setCurrentUser(User CurrentUser) {
        this.CurrentUser = CurrentUser;

    }

    public ArrayList<Magazin> getMagazins() {
        return magazins;
    }

    public void setMagazins(ArrayList<Magazin> magazins) {
        this.magazins = magazins;
    }

}
