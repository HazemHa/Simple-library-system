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
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author nadakhalid
 */
public class Genre extends javax.swing.JFrame implements communicationManager{
    private basicFunctions mcontroller;
    private DefaultListModel model = new DefaultListModel();


    /**
     * Creates new form Genre
     */
    public Genre() {
        initComponents();
        mcontroller = new basicFunctions();
        mcontroller.setListenerCommunication(this);
        mcontroller.SelectBook();
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btn_addcart = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jList1.setBackground(new java.awt.Color(204, 204, 204));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Book 1", "Book 2", "Book 3", "Book 4", "Book 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        getContentPane().add(jList1);
        jList1.setBounds(210, 90, 240, 320);

        jLabel2.setFont(new java.awt.Font("Athelas", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add to cart");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(550, 290, 160, 30);

        btn_addcart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Circle.png"))); // NOI18N
        btn_addcart.setBorder(null);
        btn_addcart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcartActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addcart);
        btn_addcart.setBounds(530, 230, 95, 160);

        jLabel3.setFont(new java.awt.Font("Athelas", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Genre Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 50, 170, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BC.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1054, 659);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 90, 180, 170);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addcartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcartActionPerformed
        // TODO add your handling code here:
     
         System.out.println(jList1.getSelectedValue());
        
    }//GEN-LAST:event_btn_addcartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Genre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Genre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Genre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Genre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Genre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addcart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void OnCompete(Message msg) {
        
         for (Book bk : LoadedData.getInstance().getBooks()) {
             model.addElement(bk.getName());

        }
        
        jList1.setModel(model);
        
    }

    @Override
    public void OnFailure(Message msg) {
    }
}
