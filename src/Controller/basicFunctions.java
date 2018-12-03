/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.LoadedData;
import DataBase.DB;
import Listener.Message;
import Listener.communicationManager;
import Models.Bill;
import Models.Book;
import Models.CartList;
import Models.User;
import java.util.ArrayList;

/**
 *
 * @author Hazem
 */
public class basicFunctions implements communicationManager {

    private  basicFunctions Instance;
    private communicationManager mcommunication;

    public  basicFunctions getInstance() {
        if (Instance == null) {
            Instance = new basicFunctions();
        }

        return Instance;
    }

    public basicFunctions() {
        DB.getInstance().setListenerCommunicate(this);

    }

    public void setListenerCommunication(communicationManager mcommunication) {
        this.mcommunication = mcommunication;
    }

  
    
     public void regeisterUserUnlessAddress(User user) {
        DB.getInstance().InsertUserPre(user.getName(), user.getEmail(), user.getPassword());
    }
     
     public void selectBookInCartList(int book_id){
         DB.getInstance().SelectBookInCartList(LoadedData.getInstance().getCurrentUser().getId()
                 , book_id);
     }
    

    public void loginUser(String username, String password) {
        User current = DB.getInstance().Login(username, password);
        if (current != null) {
            LoadedData.getInstance().setCurrentUser(current);
        }
    }
    
    
     public void loginUserUnlessAddress(String username, String password) {
        User current = DB.getInstance().Login(username, password);
       
    }
     
     public void addBill(Bill bill){
         DB.getInstance().InsertBillPre(bill.getFname(), bill.getLname(), bill.getNumberphone()
                 , bill.getAddress(), bill.getGender(), bill.getDate(), bill.getItems()
                 , bill.getTotalPrice(), bill.getTotalPriceAfterDiscount(), bill.getArrivalDate());
     }

    public void searchBook(String name) {
        DB.getInstance().searchBook(name);

    }
    
    public void isAvailableBook(String name) {
        DB.getInstance().isAvailableBook(name);

    }
    public void isAvailableMagazine(String name) {
        DB.getInstance().isAvailableMagazine(name);

    }
     public void searchMagazinName(String name) {
        DB.getInstance().searchMagazin(name);

    }
      public void searchMagazinAuthor(String authorName) {
        DB.getInstance().searchMagazinAuthor(authorName);

    }
       public void searchMagazineGenre(String AuthorName ,ArrayList<String> genres) {
            DB.getInstance().searchMagazinGenre(AuthorName,handlerGenre(genres));
//
    }
       
   

   
    
    public void SelectMyCartlist(int user_id){
        DB.getInstance().SelectMyCartlist(user_id);
    }
    
 

    public void searchBookAutor(String author_od) {
        DB.getInstance().searchBookAuthor(author_od);

    }
 private String handlerGenre(ArrayList<String> genre){
     ArrayList<String> dd = new ArrayList<>();
     for(String temp : genre){
     String query ="genre ='"+temp+"'";
     dd.add(query);
     }
     System.out.println();
     String handler = dd.toString().replace(","," or ");
     handler = handler.substring(1);
     handler= handler.substring(0, handler.length() -1 );

        return handler;
    }
    public void searchBookGenre(String AuthorName ,ArrayList<String> genres) {
            DB.getInstance().searchBookGenre(AuthorName,handlerGenre(genres));
//
    }
    
    public void SelectMagazins(){
        DB.getInstance().SelectMagazins();
    }

   

    public void addItemInCardList(CartList cartlist) {
        DB.getInstance().InsertItemCartListPre(cartlist.getUser_id(),
                cartlist.getItem_id(), cartlist.getType());
    }

    public void addBook(Book book) {
        DB.getInstance().InsertBookPre(book.getName(), book.getAuthorName(), book.getPrice(), book.getISBN(), book.getImg(), book.getGenre());
    }
    
    public void deleteBook(int id_book){
        DB.getInstance().DeleteBookPre(id_book);
    }

    

   


    
    public void SelectBook(){
        DB.getInstance().SelectBooks();
    }

    @Override
    public void OnCompete(Message msg) {
        mcommunication.OnCompete(msg);
    }

    @Override
    public void OnFailure(Message msg) {
        mcommunication.OnFailure(msg);
    }

}
