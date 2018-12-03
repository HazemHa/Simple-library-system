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
import static Listener.communicationManager.STATUS_SEARCH;
import static Listener.communicationManager.STATUS_SUCCESSFUL;
import Models.Book;
import Models.CartList;
import Models.Magazin;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author nadakhalid
 */
public class MagazinUI extends javax.swing.JFrame implements communicationManager{
    private basicFunctions mcontroller;
    private communicationManager mSearch;
    private JFrame my;
    private static MagazinUI Instance;
    private final String msg_no_book = "There are no books with this name";
    private String selected_author_name = "";
    private boolean toggle = false;
    private ArrayList<String> selected_genre = new ArrayList<>();
    private final int selected = 1;
    private final int unselected = 2;
    private ArrayList<Magazin> bigCollection = new ArrayList<Magazin>();
    private ArrayList<Magazin> allMagazin = new ArrayList<Magazin>();
    private boolean isSearching = false;
    private boolean isSearchingMagazineName = false;
    private boolean isLoadedMagazin = false;
    private boolean IsAddedToCartList = false;

    /**
     * Creates new form BOOK
     */
    public MagazinUI() {
        initComponents();
        my = this;
        LoadedData.getInstance().getMagazins().clear();
         mcontroller = new basicFunctions();
        mcontroller.setListenerCommunication(this);
               this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         Authors.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selected_author_name = (String) e.getItem();
            }
        });
         
           btn_home.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new HomePage3().setVisible(true);
                my.dispose();
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
                my.dispose();
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
         
           Laha.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Laha.getText().toString());
                } else {
                    selected_genre.remove(Laha.getText().toString());
                }

            }
        });

        Business.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Business.getText().toString());
                } else {
                    selected_genre.remove(Business.getText().toString());
                }

            }
        });
        Decoration.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Decoration.getText().toString());
                } else {
                    selected_genre.remove(Decoration.getText().toString());
                }

            }
        });

        Cook.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Cook.getText().toString());
                } else {
                    selected_genre.remove(Cook.getText().toString());
                }

            }
        });
        
         mcontroller.SelectMagazins();
Instance = this;
    }
    
    public static MagazinUI GetInstance() {        
        return Instance;
    }
    
    public void setListenerSearchForm(communicationManager mcommunicate) {
        mSearch = mcommunicate;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oldMagazin = new javax.swing.JScrollPane();
        OldMagazinContainer = new javax.swing.JPanel();
        newMagazin = new javax.swing.JScrollPane();
        NewMagazinContainer = new javax.swing.JPanel();
        img_Home = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        magazinName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Authors = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Business = new javax.swing.JCheckBox();
        Laha = new javax.swing.JCheckBox();
        Decoration = new javax.swing.JCheckBox();
        btn_search = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        Cook = new javax.swing.JCheckBox();
        btn_home = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        oldMagazin.setViewportView(OldMagazinContainer);

        getContentPane().add(oldMagazin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 730, 260));

        newMagazin.setViewportView(NewMagazinContainer);

        getContentPane().add(newMagazin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 740, 260));

        img_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/newroof.png"))); // NOI18N
        getContentPane().add(img_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 1070, 90));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search for Book ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 260, -1));

        magazinName.setBorder(null);
        magazinName.setCaretColor(new java.awt.Color(204, 204, 204));
        magazinName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        magazinName.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        magazinName.setSelectionColor(new java.awt.Color(255, 255, 255));
        magazinName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magazinNameActionPerformed(evt);
            }
        });
        getContentPane().add(magazinName, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 240, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("       New Releases");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 570, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Author");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 80, 30));

        Authors.setBackground(new java.awt.Color(0, 102, 102));
        Authors.setFont(new java.awt.Font("Athelas", 0, 18)); // NOI18N
        Authors.setForeground(new java.awt.Color(153, 153, 153));
        Authors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laha", "Sydati ", "Newyork", "Decoration " }));
        Authors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorsActionPerformed(evt);
            }
        });
        getContentPane().add(Authors, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 200, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/newroof.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, 70));

        Business.setBackground(new java.awt.Color(0, 153, 153));
        Business.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Business.setForeground(new java.awt.Color(255, 255, 255));
        Business.setText("Business");
        getContentPane().add(Business, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, -1, -1));

        Laha.setBackground(new java.awt.Color(0, 153, 153));
        Laha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Laha.setForeground(new java.awt.Color(255, 255, 255));
        Laha.setText("Laha");
        Laha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LahaActionPerformed(evt);
            }
        });
        getContentPane().add(Laha, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, -1, -1));

        Decoration.setBackground(new java.awt.Color(0, 153, 153));
        Decoration.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Decoration.setForeground(new java.awt.Color(255, 255, 255));
        Decoration.setText("Decoration");
        Decoration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecorationActionPerformed(evt);
            }
        });
        getContentPane().add(Decoration, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, -1, -1));

        btn_search.setBackground(new java.awt.Color(0, 102, 102));
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Genres");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 80, 30));

        jButton11.setToolTipText("Click to see details");
        jButton11.setBorder(null);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        Cook.setBackground(new java.awt.Color(0, 153, 153));
        Cook.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Cook.setForeground(new java.awt.Color(255, 255, 255));
        Cook.setText("Cook");
        getContentPane().add(Cook, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, -1, -1));

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/Home.png"))); // NOI18N
        getContentPane().add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 120, 70));

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/logout.png"))); // NOI18N
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 580, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/back.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, -10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/BC.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void magazinNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magazinNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_magazinNameActionPerformed

    private void AuthorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthorsActionPerformed

    private void LahaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LahaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LahaActionPerformed

    private void DecorationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecorationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DecorationActionPerformed
 
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
     // TODO add your handling code here:
        isSearching = true;
        String Magazinename = magazinName.getText().toString();
        if (Magazinename != null && !Magazinename.isEmpty()) {
            isSearchingMagazineName = true;
            mcontroller.isAvailableMagazine(Magazinename);
        }

        if (selected_author_name != null && !selected_author_name.isEmpty()) {
            mcontroller.searchMagazinAuthor(selected_author_name);
        } 
        if (selected_genre.size() > 0) {
            mcontroller.searchMagazineGenre(selected_author_name,selected_genre);
        }
        if (Search1.SearchScreen != null) {
            Search1.SearchScreen.setVisible(true);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(Magazin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Magazin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Magazin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Magazin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MagazinUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Authors;
    private javax.swing.JCheckBox Business;
    private javax.swing.JCheckBox Cook;
    private javax.swing.JCheckBox Decoration;
    private javax.swing.JCheckBox Laha;
    private javax.swing.JPanel NewMagazinContainer;
    private javax.swing.JPanel OldMagazinContainer;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel img_Home;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField magazinName;
    private javax.swing.JScrollPane newMagazin;
    private javax.swing.JScrollPane oldMagazin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void OnCompete(Message msg) {

        int status = msg.getStauts();
        Object Content = msg.getContent();
        String message = msg.getMessage();
                        
        // loaded all Magazin successful
        if (Content == null && status == STATUS_SUCCESSFUL && !isLoadedMagazin) {
            for (final Magazin magazin : LoadedData.getInstance().getMagazins()) {
                JLabel showmagazin = new javax.swing.JLabel();
                showmagazin.setPreferredSize(new Dimension(230, 350));
                JLabel copy = new javax.swing.JLabel();
                copy.setPreferredSize(new Dimension(230, 350));
                copy.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                                JOptionPane.showMessageDialog(myFrame, book.getDescription(), book.getName(), JOptionPane.INFORMATION_MESSAGE);
                        if (JOptionPane.showConfirmDialog(null, "Are you want to add " + magazin.getName() + " for author "+magazin.getPublishing()
                                +" and  genre  :"+magazin.getGenre()+ " to cardlist?", "Question",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                           if (LoadedData.getInstance().getCurrentUser() != null) {
                                CartList item = new CartList(
                                        LoadedData.getInstance().getCurrentUser().getId(),
                                        magazin.getId(), "magazin");
                                // add in data base
                                IsAddedToCartList = true;
                                mcontroller.addItemInCardList(item);
                            } else {
        JOptionPane.showMessageDialog(null, "You must login to able added item to cardlist", "Failure", JOptionPane.ERROR_MESSAGE);

                            }
                        } else {
                            // no option
                        }

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
                showmagazin.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                    JOptionPane.showMessageDialog(myFrame, book.getDescription(), book.getName(), JOptionPane.INFORMATION_MESSAGE);
                        if (JOptionPane.showConfirmDialog(null, "Are you want to add " + magazin.getName() + " for author "+magazin.getPublishing()
                                +" and  genre  :"+magazin.getGenre()+ " to cardlist?", "Question",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                            if (LoadedData.getInstance().getCurrentUser() != null) {
                                CartList item = new CartList(
                                        LoadedData.getInstance().getCurrentUser().getId(),
                                        magazin.getId(), "magazin");
                                // add in data base
                                IsAddedToCartList = true;
                                mcontroller.addItemInCardList(item);
                            } else {
        JOptionPane.showMessageDialog(null, "You must login to able added item to cardlist", "Failure", JOptionPane.ERROR_MESSAGE);

                            }
                        } else {
                            // no option
                        }

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
                showmagazin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Magazine/" + magazin.getImage()))); // NOI18N
                copy.setIcon(showmagazin.getIcon());
                OldMagazinContainer.add(showmagazin);
                NewMagazinContainer.add(copy);

            }
            isLoadedMagazin = true;

        } //after added item in card list
        else if (status == STATUS_SUCCESSFUL && IsAddedToCartList) {
            JOptionPane.showMessageDialog(null, message, "Compete", JOptionPane.INFORMATION_MESSAGE);
            IsAddedToCartList = false;
        }
        else if(status == STATUS_SUCCESSFUL && isSearching){
            if(isSearchingMagazineName){
                new Search1().setVisible(true);
                isSearchingMagazineName = false;
                msg.setStauts(STATUS_SEARCH);
                mSearch.OnCompete(msg);
            }else{
            OldMagazinContainer.removeAll();
            OldMagazinContainer.revalidate();
            OldMagazinContainer.repaint();
            ArrayList<Magazin> searchMagazin = (ArrayList)Content;
            for (final Magazin b : searchMagazin) {
                 JLabel showMagazin = new javax.swing.JLabel();
                showMagazin.setPreferredSize(new Dimension(230, 350));
                showMagazin.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                    JOptionPane.showMessageDialog(myFrame, book.getDescription(), book.getName(), JOptionPane.INFORMATION_MESSAGE);
                        if (JOptionPane.showConfirmDialog(null, "Are you want to add " + b.getName() + "to cardlist?", "Question",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                            if (LoadedData.getInstance().getCurrentUser() != null) {
                                CartList item = new CartList(
                                        LoadedData.getInstance().getCurrentUser().getId(),
                                        b.getId(), "book");
                                // add in data base
                                IsAddedToCartList = true;
                                mcontroller.addItemInCardList(item);
                            } else {
        JOptionPane.showMessageDialog(null, "You must login to able added item to cardlist", "Failure", JOptionPane.ERROR_MESSAGE);

                            }
                        } else {
                            // no option
                        }

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
                showMagazin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Magazine/" + b.getImage()))); // NOI18N
                OldMagazinContainer.add(showMagazin);
            }
//            isSearching = false;
            }
        }
//  
    }

    @Override
    public void OnFailure(Message msg) {
          JOptionPane.showMessageDialog(this,msg.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE);

    }
}
