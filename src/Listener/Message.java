/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

/**
 *
 * @author Hazem
 */
public class Message {
    private int stauts;
    private Object content;
    private String message;

    public Message(int stauts, Object content, String message) {
        this.stauts = stauts;
        this.content = content;
        this.message = message;
    }

    public Message(int stauts, String message) {
        this.stauts = stauts;
        this.message = message;
    }

    public Message(int stauts, Object content) {
        this.stauts = stauts;
        this.content = content;
    }
    
    

    public Message() {
    }
    
    

    
    

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" + "stauts=" + stauts + ", content=" + content + ", message=" + message + '}';
    }

   
    
    
}
