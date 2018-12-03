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
public class Bill {
    
    private int id;
    private String fname;
    private String lname;
    private String numberphone;
    private String address;
    private String gender;
    private String date;
    private String items;
    private double TotalPrice;
    private double TotalPriceAfterDiscount;
    private String ArrivalDate;

    public Bill(int id, String fname, String lname, String numberphone, String address, String gender, String date, String items, double TotalPrice, double TotalPriceAfterDiscount, String ArrivalDate) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.numberphone = numberphone;
        this.address = address;
        this.gender = gender;
        this.date = date;
        this.items = items;
        this.TotalPrice = TotalPrice;
        this.TotalPriceAfterDiscount = TotalPriceAfterDiscount;
        this.ArrivalDate = ArrivalDate;
    }

    public Bill(String fname, String lname, String numberphone, String address, String gender, String date, String items, double TotalPrice, double TotalPriceAfterDiscount, String ArrivalDate) {
        this.fname = fname;
        this.lname = lname;
        this.numberphone = numberphone;
        this.address = address;
        this.gender = gender;
        this.date = date;
        this.items = items;
        this.TotalPrice = TotalPrice;
        this.TotalPriceAfterDiscount = TotalPriceAfterDiscount;
        this.ArrivalDate = ArrivalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public double getTotalPriceAfterDiscount() {
        return TotalPriceAfterDiscount;
    }

    public void setTotalPriceAfterDiscount(double TotalPriceAfterDiscount) {
        this.TotalPriceAfterDiscount = TotalPriceAfterDiscount;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(String ArrivalDate) {
        this.ArrivalDate = ArrivalDate;
    }
    
    
    
    
}
