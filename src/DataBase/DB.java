/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Data.LoadedData;
import Listener.Message;
import Listener.communicationManager;
import Models.Bill;
import Models.Book;
import Models.CartList;
import Models.Magazin;
import Models.User;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hazem
 */
public class DB {

    private static DB Instance;
    private communicationManager mcommunicateController;

    // JDBC driver name and database URL
    private final String DB = "wise";
    private final int PORT = 3306;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:" + PORT + "/" + DB;

    //  Database credentials
    private final String USER = "root";
    private final String PASS = "";
    private final String msg_succ = "Complete successfully";
    private final String msg_fail = "Something went wrong try again ..";
    private final String msg_login_error = "username or password is incorrect";
    private final String msg_welcome = "welcome ";

    // Open a connection
    private Connection connection = null;
    // Execute a query
    private Statement statement = null;

    private PreparedStatement preStmt;
    private Message msg;

    public static DB getInstance() {
        if (Instance == null) {
            Instance = new DB();
        }

        return Instance;
    }

    public DB() {
        createConnection();
    }

    public void createConnection() {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        connection = null;

        try {
            connection = (Connection) DriverManager
                    .getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setListenerCommunicate(communicationManager mcommunicateController) {
        this.mcommunicateController = mcommunicateController;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void createTables() {
        try {
//            statement.execute(createTableAddress());
            statement.execute(createTableUser());
//            statement.execute(createTablePublisher());
//            statement.execute(createTablePublisherBook());
            statement.execute(createTableBills());
            statement.execute(createTablecartList());
//            statement.execute(createTableAuthors());
            statement.execute(createTableBook());
//            statement.execute(createTableOrder());
            statement.execute(createTableMagazin());
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Statement getStatement() {
        return statement;
    }

    private String createTableUser() {
        return "CREATE TABLE IF NOT EXISTS users "
                + "(id INTEGER NOT NULL AUTO_INCREMENT , "
                + " name VARCHAR(255) NOT NULL, "
                + " email VARCHAR(255) NOT NULL, "
                + " password VARCHAR(255) NOT NULL, "
                //                + " address_id INTEGER  references address(id) , "
                + " PRIMARY KEY ( id ))";
    }

    private String createTableMagazin() {
        return "CREATE TABLE IF NOT EXISTS magazin "
                + "(id INTEGER NOT NULL AUTO_INCREMENT , "
                + " name VARCHAR(255) NOT NULL, "
                + " image VARCHAR(255) NOT NULL, "
                + "Publishing  VARCHAR(255) NOT NULL, "
                + " price INT NOT NULL, "
                + " genre VARCHAR(255) NOT NULL , "
                + " description VARCHAR(255) NOT NULL , "
                + " PRIMARY KEY ( id ))";
    }

    private String createTableBook() {
        return "CREATE TABLE IF NOT EXISTS book "
                + "(id INTEGER NOT NULL AUTO_INCREMENT, "
                + " author VARCHAR(255), "
                + " name VARCHAR(255) NOT NULL, "
                + " ISBN VARCHAR(255) NOT NULL, "
                + " image  VARCHAR(255), "
                + " genre VARCHAR(255)  NULL, "
                + " price INT  NULL, "
                + " description VARCHAR(255) NOT NULL , "
                + " PRIMARY KEY ( id ))";
    }

    private String createTablecartList() {
        return "CREATE TABLE IF NOT EXISTS cartList "
                + "(id INTEGER NOT NULL AUTO_INCREMENT, "
                + " user_id INTEGER  references users(id), "
                + " item_id INT references book(id), "
                + " type VARCHAR(255),"
                + " PRIMARY KEY ( id ))";
    }

    private String createTableBills() {
        return "CREATE TABLE IF NOT EXISTS bills "
                + "(id INTEGER NOT NULL AUTO_INCREMENT, "
                + " firstname VARCHAR(255), "
                + " lastname VARCHAR(255), "
                + " phonenumber VARCHAR(255), "
                + " address VARCHAR(255), "
                + " gender VARCHAR(255), "
                + " date VARCHAR(255), "
                + " items VARCHAR(255), "
                + " totalPrice VARCHAR(255), "
                + " PriceAfterDiscount VARCHAR(255), "
                + " ArrivalDate VARCHAR(255), "
                + " PRIMARY KEY ( id ))";
    }

    public void InsertBillPre(String fname, String lname, String numberphone, String address, String gender, String date, String items, double TotalPrice, double TotalPriceAfterDiscount, String ArrivalDate) {
        try {
            String sql = "INSERT INTO bills(firstname,lastname,phonenumber,address,gender,date,items,totalPrice,PriceAfterDiscount,ArrivalDate)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";

            preStmt = connection.prepareStatement(sql);
            preStmt.setString(1, fname);
            preStmt.setString(2, lname);
            preStmt.setString(3, numberphone);
            preStmt.setString(4, address);
            preStmt.setString(5, gender);
            preStmt.setString(6, date);
            preStmt.setString(7, items);
            preStmt.setDouble(8, TotalPrice);
            preStmt.setDouble(9, TotalPriceAfterDiscount);
            preStmt.setString(10, ArrivalDate);

            int result = preStmt.executeUpdate();

            String msg_result = result == 1 ? "added completely" : "happend error";

            msg = new Message(communicationManager.STATUS_SUCCESSFUL, msg_result);
            mcommunicateController.OnCompete(msg);

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }

    }

    public void SelectBills() {
        ArrayList<Bill> Bills = null;
        try {
            String sql = "SELECT * FROM bills ";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                Bills = new ArrayList<>();
            }
            while (rs.next()) {
                //Retrieve by column name
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String phonenumber = rs.getString("phonenumber");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String date = rs.getString("date");
                String items = rs.getString("items");
                double totalPrice = rs.getDouble("totalPrice");
                double PriceAfterDiscount = rs.getDouble("PriceAfterDiscount");
                String ArrivalDate = rs.getString("ArrivalDate");

                Bill bill = new Bill(fname, lname, phonenumber, address, gender, date, items, totalPrice, PriceAfterDiscount, ArrivalDate);
                LoadedData.getInstance().getBills().add(bill);

            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, Bills, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void InsertUserPre(String name, String email, String password) {
        try {
            String sql_user = "INSERT INTO users(name,email,password)"
                    + "VALUES (?,?,?)";

            preStmt = connection.prepareStatement(sql_user);
            // Set the values
            preStmt.setString(1, name);
            preStmt.setString(2, email);
            preStmt.setString(3, password);
            int added_user = preStmt.executeUpdate();
            String msg_result = added_user == 1 ? "added completely" : "happend error";

            msg = new Message(communicationManager.STATUS_SUCCESSFUL, msg_result);
            msg.setContent(lastRecord("users"));
            mcommunicateController.OnCompete(msg);

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }

    }

    private int lastRecord(String tableName) {
        int id = -1;
        try {
            String last_id = "SELECT * FROM " + tableName + " ORDER BY ID DESC LIMIT 1";
            ResultSet rs = preStmt.executeQuery(last_id);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                id = rs.getInt("id");
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void InsertBookPre(String authorName, String name, double price, String ISBN, String img, String Genre) {
        try {

            String sql = "INSERT INTO book(author,name,ISBN,image,genre,price)"
                    + "VALUES (?,?,?,?,?,?)";

            preStmt = connection.prepareStatement(sql);
            // Set the values
            preStmt.setString(1, authorName);
            preStmt.setString(2, name);
            preStmt.setString(3, ISBN);
            preStmt.setString(4, img);
            preStmt.setString(5, Genre);
            preStmt.setDouble(6, price);
            // Insert
            int result = preStmt.executeUpdate();
            String msg_result = result == 1 ? "added completely" : "happend error";

            msg = new Message(communicationManager.STATUS_SUCCESSFUL, msg_result);
            mcommunicateController.OnCompete(msg);

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void DeleteBookPre(int id){
        
        try {
            String sql = "DELETE FROM book where id=?";
            preStmt = connection.prepareStatement(sql);
            // Set the values
            preStmt.setInt(1, id);
             int result = preStmt.executeUpdate();
            String msg_result = result == 1 ? "Deleted completely" : "happend error";

            msg = new Message(communicationManager.STATUS_SUCCESSFUL, msg_result);
            mcommunicateController.OnCompete(msg);

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
       

    }
    public void InsertMagazinPre(String name, String author, String Description, String genre, String image) {
        try {

            String sql = "INSERT INTO magazin(name,image,descrition,author,genre)"
                    + "VALUES (?,?,?,?,?)";

            preStmt = connection.prepareStatement(sql);
            // Set the values
            preStmt.setString(1, name);
            preStmt.setString(2, image);
            preStmt.setString(3, Description);
            preStmt.setString(4, author);
            preStmt.setString(5, genre);
            // Insert
            int result = preStmt.executeUpdate();
            String msg_result = result == 1 ? "added completely" : "happend error";

            msg = new Message(communicationManager.STATUS_SUCCESSFUL, msg_result);
            mcommunicateController.OnCompete(msg);

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void InsertItemCartListPre(int user_id, int item_id, String type) {
        try {
            String sql = "INSERT INTO cartlist(user_id,item_id,type)"
                    + "VALUES (?,?,?)";

            preStmt = connection.prepareStatement(sql);

            // Set the values
            preStmt.setInt(1, user_id);
            preStmt.setInt(2, item_id);
            preStmt.setString(3, type);
            // Insert
            int result = preStmt.executeUpdate();
            String msg_result = result == 1 ? "added completely" : "happend error";

            msg = new Message(communicationManager.STATUS_SUCCESSFUL, msg_result);
            mcommunicateController.OnCompete(msg);

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void SelectUser() {
        try {
            String sql = "SELECT * FROM users,address where users.address_id = address.id";
            preStmt = connection.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User usr = new User(id, name, email, password);
                LoadedData.getInstance().getUsers().add(usr);

            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, "Load Complete");
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void SelectBooks() {
        try {
            String sql = "SELECT * FROM book;";
            preStmt = connection.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {

                //Retrieve by column name
                int id = rs.getInt("id");
                String authornamr = rs.getString("author");
                String name = rs.getString("name");
                String ISBN = rs.getString("ISBN");
                String img = rs.getString("image");
                String Genre = rs.getString("genre");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                Book b = new Book(id, authornamr, name, price, ISBN, img, Genre, description);
                LoadedData.getInstance().getBooks().add(b);

            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void SelectMagazins() {
        try {
            String sql = "SELECT * FROM magazin";
            preStmt = connection.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {
//int id, String name, String image, String description, String Author, String Genre                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String Publishing = rs.getString("Publishing");
                double author = rs.getDouble("price");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Magazin maga = new Magazin(id, name, image, Publishing, author, genre, description);
                LoadedData.getInstance().getMagazins().add(maga);

            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, "Load Complete");
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void SelectBook(int book_id) {
        Book b = null;
        try {
            String sql = "SELECT * FROM book where id = ?";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setInt(1, book_id);
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                //Retrieve by column name
                int id = rs.getInt("id");
                String authornamr = rs.getString("author");
                String name = rs.getString("name");
                String ISBN = rs.getString("ISBN");
                String img = rs.getString("image");
                String Genre = rs.getString("genre");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                b = new Book(id, authornamr, name, price, ISBN, img, Genre, description);

            }
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, b, msg_succ);
            mcommunicateController.OnCompete(msg);
            rs.close();

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void SelectBookInCartList(int user_id, int item_id) {
        Book b = null;
        try {
            String sql = "SELECT * FROM cartlist car,book bp where car.user_id = ? and car.item_id = ? and bp.id = car.item_id;";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setInt(1, user_id);
            tempPre.setInt(1, item_id);
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set

            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String authornamr = rs.getString("author");
                String name = rs.getString("name");
                String ISBN = rs.getString("ISBN");
                String img = rs.getString("image");
                String Genre = rs.getString("genre");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                b = new Book(id, authornamr, name, price, ISBN, img, Genre, description);
            }
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, b, msg_succ);
            mcommunicateController.OnCompete(msg);
            rs.close();

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void SelectMagazin(int magazin_id) {
        Magazin maga = null;
        try {
            String sql = "SELECT * FROM book where id = ?";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setInt(1, magazin_id);
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String Publishing = rs.getString("Publishing");
                double author = rs.getDouble("price");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                maga = new Magazin(id, name, image, Publishing, author, genre, description);

            }
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, maga, msg_succ);
            mcommunicateController.OnCompete(msg);
            rs.close();

        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void SelectMyCartlist(int user_id) {
        ArrayList<Book> books = null;
        try {
            String sql = "SELECT pb.* FROM cartList car , book pb where user_id = ? and car.item_id = pb.id;";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setInt(1, user_id);
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                books = new ArrayList<>();
            }
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String authornamr = rs.getString("author");
                String name = rs.getString("name");
                String ISBN = rs.getString("ISBN");
                String img = rs.getString("image");
                String Genre = rs.getString("genre");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                Book b = new Book(id, authornamr, name, price, ISBN, img, Genre, description);
                books.add(b);

            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, books, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void SelectUserInfo(int user_id) {
        User usr = null;
        try {
            String sql = "SELECT * FROM users where id = ?";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setInt(1, user_id);
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                usr = new User(id, name, email, password);
            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, usr, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public User Login(String username, String password) {
        User current = null;
        try {
            String sql = "SELECT * from users where (users.email=? and users.password=?)";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, username);
            tempPre.setString(2, password);
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {

                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password_user = rs.getString("password");
                current = new User(id, name, email, password_user);

            }

            rs.close();
            if (current == null) {
                msg = new Message(communicationManager.STATUS_NOT_FOUND, current, msg_login_error);
            } else {
                msg = new Message(communicationManager.STATUS_SUCCESSFUL, current, msg_welcome);
                msg.setContent(current);
            }
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
        return current;
    }

    public void searchBook(String bookname) {
        ArrayList<Book> books = null;
        try {
            String sql = "SELECT * FROM book b,cartlist cart where b.name LIKE ? and b.id = cart.item_id;";

            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%" + bookname + "%");
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                books = new ArrayList<>();
            }
            while (rs.next()) {

                //Retrieve by column name
                //Retrieve by column name
                int id = rs.getInt("id");
                String authornamr = rs.getString("author");
                String name = rs.getString("name");
                String ISBN = rs.getString("ISBN");
                String img = rs.getString("image");
                String Genre = rs.getString("genre");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                Book b = new Book(id, authornamr, name, price, ISBN, img, Genre, description);
                books.add(b);
            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, books, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }
      public void isAvailableBook(String bookname) {
       Book b = null;
        try {
            String sql = "SELECT * FROM book b,cartlist cart where b.name LIKE ? and b.id = cart.item_id and type='book';";

            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%" + bookname + "%");
            ResultSet rs = tempPre.executeQuery();
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String authornamr = rs.getString("author");
                String name = rs.getString("name");
                String ISBN = rs.getString("ISBN");
                String img = rs.getString("image");
                String Genre = rs.getString("genre");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                 b = new Book(id, authornamr, name, price, ISBN, img, Genre, description,false);
                 b.setIsAvailable(false);

            }
            rs.close();
            
            
            if(b ==null){
            String sql_2 = "SELECT * FROM book where name LIKE ?;";

            PreparedStatement tempPre_2 = connection.prepareStatement(sql_2);
            tempPre_2.setString(1, "%" + bookname + "%");
            ResultSet rs2 = tempPre_2.executeQuery();
            while (rs2.next()) {
                //Retrieve by column name
                int id = rs2.getInt("id");
                String authornamr = rs2.getString("author");
                String name = rs2.getString("name");
                String ISBN = rs2.getString("ISBN");
                String img = rs2.getString("image");
                String Genre = rs2.getString("genre");
                double price = rs2.getDouble("price");
                String description = rs2.getString("description");
                b = new Book(id, authornamr, name, price, ISBN, img, Genre, description,true);
                b.setIsAvailable(true);
            }
            rs2.close();
            }
            
            
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, b, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }
      
     public void isAvailableMagazine(String magazinname) {
       Magazin b = null;
        try {
            String sql = "SELECT * FROM magazin m,cartlist cart where m.name LIKE ? and m.id = cart.item_id and type='magazin';";

            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%" + magazinname + "%");
            ResultSet rs = tempPre.executeQuery();
            while (rs.next()) {
                //Retrieve by column name
              int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String Publishing = rs.getString("Publishing");
                double author = rs.getDouble("price");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                b = new Magazin(id, name, image, Publishing, author, genre, description);
                 b.setIsAvailable(false);

            }
            rs.close();
            
            
            
            String sql_2 = "SELECT * FROM magazin where name LIKE ?;";

            PreparedStatement tempPre_2 = connection.prepareStatement(sql_2);
            tempPre_2.setString(1, "%" + magazinname + "%");
            ResultSet rs2 = tempPre_2.executeQuery();
            while (rs2.next()) {
                //Retrieve by column name
               int id = rs2.getInt("id");
                String name = rs2.getString("name");
                String image = rs2.getString("image");
                String Publishing = rs2.getString("Publishing");
                double author = rs2.getDouble("price");
                String genre = rs2.getString("genre");
                String description = rs2.getString("description");
                b = new Magazin(id, name, image, Publishing, author, genre, description);
                b.setIsAvailable(true);
            }
            rs2.close();
            
            
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, b, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }



    public void searchMagazin(String magazinName) {
        ArrayList<Magazin> magazins = null;
        try {
            String sql = "SELECT * FROM magazin where name LIKE ?;";

            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%" + magazinName + "%");
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                magazins = new ArrayList<>();
            }
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String Publishing = rs.getString("Publishing");
                double author = rs.getDouble("price");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Magazin maga = new Magazin(id, name, image, Publishing, author, genre, description);
                magazins.add(maga);
            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, magazins, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void searchMagazinGenre(String Genre) {
        ArrayList<Magazin> magazins = null;
        try {
            String sql = "SELECT * FROM magazin where genre LIKE ?;";

            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%" + Genre + "%");
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                magazins = new ArrayList<>();
            }
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String Publishing = rs.getString("Publishing");
                double author = rs.getDouble("price");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Magazin maga = new Magazin(id, name, image, Publishing, author, genre, description);
                magazins.add(maga);
            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, magazins, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void searchMagazinAuthor(String authorName) {
        ArrayList<Magazin> magazins = null;
        try {
            String sql = "SELECT * FROM magazin where Publishing LIKE ?;";

            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%" + authorName + "%");
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                magazins = new ArrayList<>();
            }
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String Publishing = rs.getString("Publishing");
                double price = rs.getDouble("price");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Magazin maga = new Magazin(id, name, image, Publishing, price, genre, description);
                magazins.add(maga);
            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, magazins, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void searchBookAuthor(String author_id) {
        ArrayList<Book> books = null;
        try {
            String sql = "SELECT * FROM book  where author like ?;";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%"+author_id+"%");
            ResultSet rs = tempPre.executeQuery();
            //STEP 5: Extract data from result set
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                books = new ArrayList<>();
            }
            while (rs.next()) {

                //Retrieve by column name
                int id = rs.getInt("id");
                String authornamr = rs.getString("author");
                String name = rs.getString("name");
                String ISBN = rs.getString("ISBN");
                String img = rs.getString("image");
                String Genre = rs.getString("genre");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                Book b = new Book(id, authornamr, name, price, ISBN, img, Genre, description);
                books.add(b);
            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, books, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }

    public void searchBookGenre(String AuthorName, String nameGenre) {
        ArrayList<Book> books = null;
        try {
            String sql = "SELECT * FROM book where author like ? and "+nameGenre+";";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%" + AuthorName + "%");
            ResultSet rs = tempPre.executeQuery();
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                books = new ArrayList<>();
            }
            //STEP 5: Extract data from result set
            while (rs.next()) {

                //Retrieve by column name
                int id = rs.getInt("id");
                String authornamr = rs.getString("author");
                String name = rs.getString("name");
                String ISBN = rs.getString("ISBN");
                String img = rs.getString("image");
                String Genre = rs.getString("genre");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                Book b = new Book(id, authornamr, name, price, ISBN, img, Genre, description);
                books.add(b);
            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, books, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }
    
    public void searchMagazinGenre(String AuthorName, String nameGenre) {
        ArrayList<Magazin> magazin = null;
        try {
            String sql = "SELECT * FROM magazin where Publishing like ? and "+nameGenre+";";
            PreparedStatement tempPre = connection.prepareStatement(sql);
            tempPre.setString(1, "%" + AuthorName + "%");
            ResultSet rs = tempPre.executeQuery();
            if (rs.isAfterLast() || rs.isBeforeFirst()) {
                magazin = new ArrayList<>();
            }
            //STEP 5: Extract data from result set
            while (rs.next()) {

                 int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String Publishing = rs.getString("Publishing");
                double price = rs.getDouble("price");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Magazin maga = new Magazin(id, name, image, Publishing, price, genre, description);
                magazin.add(maga);
            }
            rs.close();
            msg = new Message(communicationManager.STATUS_SUCCESSFUL, magazin, msg_succ);
            mcommunicateController.OnCompete(msg);
        } catch (SQLException ex) {
            msg = new Message(communicationManager.STATUS_FAILURE, ex.getLocalizedMessage());
            mcommunicateController.OnFailure(msg);
        }
    }
}
