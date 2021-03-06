/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_forms;

import Controller.basicFunctions;
import Data.LoadedData;
import Listener.Message;
import Listener.communicationManager;
import Models.Book;
import Models.CartList;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nadakhalid
 */
public class Search extends javax.swing.JFrame implements communicationManager {

    private basicFunctions mcontroller;
    private DefaultListModel model;
    private Book selectedBook;
    public static JFrame SearchScreen;
    private boolean isAddedToCartList = false;

    /**
     * Creates new form AuthorBooks
     */
    public Search() {
        initComponents();
        mcontroller = new basicFunctions();
        mcontroller.setListenerCommunication(this);
        SearchScreen = this;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if(BOOK4.GetInstance() == null ){
      JOptionPane.showMessageDialog(this, "You can not Enter directly go to magazine or books page and click search", "Failure", JOptionPane.ERROR_MESSAGE);
       this.dispose();
       System.exit(0);
        }
        BOOK4.GetInstance().setListenerSearchForm(this);
        this.setPreferredSize(new Dimension(200, 400));
         model = new DefaultListModel<Book>();
        

        
          btn_home.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new HomePage3().setVisible(true);
                SearchScreen.dispose();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        btn_logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoadedData.getInstance().setCurrentUser(null);
                new HomePage3().setVisible(true);
                SearchScreen.dispose();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_home = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        result_ISBN = new javax.swing.JTextField();
        result_avalible = new javax.swing.JTextField();
        result_name = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addToCart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Athelas", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/Res.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 60, 340, 60);

        jLabel4.setFont(new java.awt.Font("Athelas", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Avalible:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 200, 70, 20);

        jLabel5.setFont(new java.awt.Font("Athelas", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 250, 90, 24);

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/Home.png"))); // NOI18N
        getContentPane().add(btn_home);
        btn_home.setBounds(360, 510, 107, 61);

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/logout.png"))); // NOI18N
        getContentPane().add(btn_logout);
        btn_logout.setBounds(470, 520, 78, 48);

        jLabel6.setFont(new java.awt.Font("Athelas", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ISBN:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(430, 310, 50, 20);
        getContentPane().add(result_ISBN);
        result_ISBN.setBounds(400, 330, 160, 30);

        result_avalible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                result_avalibleActionPerformed(evt);
            }
        });
        getContentPane().add(result_avalible);
        result_avalible.setBounds(400, 220, 150, 30);
        getContentPane().add(result_name);
        result_name.setBounds(400, 270, 160, 30);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Search again");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(350, 430, 90, 20);

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/Res.png"))); // NOI18N
        btn_search.setText("jButton2");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_search);
        btn_search.setBounds(330, 430, 110, 20);

        jLabel3.setFont(new java.awt.Font("Athelas", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Result");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 70, 220, 40);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Add to cart");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(490, 430, 90, 20);

        addToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/Res.png"))); // NOI18N
        addToCart.setText("jButton2");
        addToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartActionPerformed(evt);
            }
        });
        getContentPane().add(addToCart);
        addToCart.setBounds(470, 430, 110, 20);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/res2.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(260, 130, 400, 400);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/BC.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -90, 1180, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void result_avalibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_result_avalibleActionPerformed
        // TODO add your handling code here:
//        CartList item = new CartList(
//                LoadedData.getInstance().getCurrentUser().getId()
//        ,selectedBook.getId(),1,1);
//        // add in data base
//        mcontroller.addItemInCardList(item);
//        // add in array without need to send to server
//        LoadedData.getInstance().getCartList().add(item);
    }//GEN-LAST:event_result_avalibleActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        SearchScreen.setVisible(false);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void addToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartActionPerformed
//        // TODO add your handling code here:
        if(LoadedData.getInstance().getCurrentUser() != null){
        CartList mitem = new CartList(LoadedData.getInstance().getCurrentUser().getId(),selectedBook.getId(),"book");
        mcontroller.addItemInCardList(mitem);
        isAddedToCartList = true;
        }else{
   JOptionPane.showMessageDialog(this,"You must login to add this item", "Failure", JOptionPane.WARNING_MESSAGE);
   
        }
    }//GEN-LAST:event_addToCartActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                new Search().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCart;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField result_ISBN;
    private javax.swing.JTextField result_avalible;
    private javax.swing.JTextField result_name;
    // End of variables declaration//GEN-END:variables

    @Override
    public void OnCompete(Message msg) {
        int status = msg.getStauts();
        Object Content = msg.getContent();
        // i come form BOOK4
        if(Content!=null && !(Content instanceof ArrayList)){
            Book b = (Book)Content;
            selectedBook = b;
            if(b.isIsAvailable()){
                result_avalible.setText("Available");
                addToCart.setVisible(true);
            }else  {
                result_avalible.setText("UnAvailable");
                addToCart.setVisible(false);
            }
            result_name.setText(b.getName());
            result_ISBN.setText(b.getISBN());
        }
        if(Content==null && status == STATUS_SEARCH){
          JOptionPane.showMessageDialog(this,"There are no books founded","Compete",JOptionPane.INFORMATION_MESSAGE);
        
        }
        if(status == STATUS_SUCCESSFUL && isAddedToCartList){
      JOptionPane.showMessageDialog(this,msg.getMessage(),"Compete",JOptionPane.INFORMATION_MESSAGE);
      isAddedToCartList = false;

        }
//        // show a joptionpane dialog using showMessageDialog
//        //   JOptionPane.showMessageDialog(this,msg.getMessage(),"Compete",JOptionPane.INFORMATION_MESSAGE);
//        if ( msg.getContent() != null) {
//            if (msg.getContent() instanceof ArrayList) {
//                ArrayList<Book> books = (ArrayList) msg.getContent();
//                for (Book bk : books) {
//                    model.addElement(bk);
//                }
//            }
//           
//        }
//        else if(msg.getStauts() == communicationManager.STATUS_SUCCESSFUL && msg.getContent() != null){
//             JOptionPane.showMessageDialog(this, msg.getMessage(), "successfully", JOptionPane.INFORMATION_MESSAGE);
//           
//            }else if (msg.getStauts() == communicationManager.STATUS_SUCCESSFUL){
//                         JOptionPane.showMessageDialog(this, "successfully added", "successfully", JOptionPane.INFORMATION_MESSAGE);
//
//        }

    }

    @Override
    public void OnFailure(Message msg) {
        JOptionPane.showMessageDialog(this, msg.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);

    }
}
