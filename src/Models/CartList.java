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
public class CartList {
    private int id;
    private int user_id;
    private int item_id;
    private String type;

    public CartList(int id, int user_id, int item_id, String type) {
        this.id = id;
        this.user_id = user_id;
        this.item_id = item_id;
        this.type = type;
    }

    public CartList(int user_id, int item_id, String type) {
        this.user_id = user_id;
        this.item_id = item_id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
        
  
}
