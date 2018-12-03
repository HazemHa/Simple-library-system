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
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author nadakhalid
 */
public class BOOK4 extends javax.swing.JFrame implements communicationManager {

    private basicFunctions mcontroller;
    private communicationManager mSearch;
    private JFrame my;
    private static BOOK4 Instance;
    private final String msg_no_book = "There are no books with this name";
    private String selected_author_name = "";
    private boolean toggle = false;
    private ArrayList<String> selected_genre = new ArrayList<>();
    private final int selected = 1;
    private final int unselected = 2;
    private ArrayList<Book> bigCollection = new ArrayList<Book>();
    private ArrayList<Book> allBooks = new ArrayList<Book>();
    private boolean isSearching = false;
    private boolean isSearchingBookName = false;
    private boolean isLoadedBooks = false;
    private boolean IsAddedToCartList = false;

    /**
     * Creates new form BOOK
     */
    public BOOK4() {
        initComponents();
        my = this;
        LoadedData.getInstance().getBooks().clear();
        mcontroller = new basicFunctions();
        mcontroller.setListenerCommunication(this);
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

        Authors.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selected_author_name = (String) e.getItem();
            }
        });

        Drama.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Drama.getText().toString());
                } else {
                    selected_genre.remove(Drama.getText().toString());
                }

            }
        });
        Science.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Science.getText().toString());
                } else {
                    selected_genre.remove(Science.getText().toString());
                }

            }
        });
        Fantasy.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Fantasy.getText().toString());
                } else {
                    selected_genre.remove(Fantasy.getText().toString());
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
        Science.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Science.getText().toString());
                } else {
                    selected_genre.remove(Science.getText().toString());
                }

            }
        });
        Biography.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Biography.getText().toString());
                } else {
                    selected_genre.remove(Biography.getText().toString());
                }

            }
        });
        Selfhelp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(Selfhelp.getText().toString());
                } else {
                    selected_genre.remove(Selfhelp.getText().toString());
                }

            }
        });
        ActionAdventure.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (selected == e.getStateChange()) {
                    selected_genre.add(ActionAdventure.getText().toString());
                } else {
                    selected_genre.remove(ActionAdventure.getText().toString());
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
        
        
                
        mcontroller.SelectBook();
        Instance = this;

    }

    public static BOOK4 GetInstance() {
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

        allBooksNew = new javax.swing.JScrollPane();
        newPanelBook = new javax.swing.JPanel();
        allBooksOld = new javax.swing.JScrollPane();
        oldPanelBook = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Magazinename = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Authors = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Fantasy = new javax.swing.JCheckBox();
        Business = new javax.swing.JCheckBox();
        Science = new javax.swing.JCheckBox();
        Selfhelp = new javax.swing.JCheckBox();
        Biography = new javax.swing.JCheckBox();
        ActionAdventure = new javax.swing.JCheckBox();
        btn_search = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Drama = new javax.swing.JCheckBox();
        btn_home = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newPanelBook.setBackground(new java.awt.Color(204, 204, 255));
        newPanelBook.setForeground(new java.awt.Color(51, 51, 51));
        allBooksNew.setViewportView(newPanelBook);

        getContentPane().add(allBooksNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 760, 270));

        allBooksOld.setBackground(new java.awt.Color(255, 255, 255));
        allBooksOld.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        oldPanelBook.setBackground(new java.awt.Color(204, 204, 255));
        oldPanelBook.setForeground(new java.awt.Color(51, 51, 51));
        allBooksOld.setViewportView(oldPanelBook);

        getContentPane().add(allBooksOld, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 740, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/newroof.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 1070, 90));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search for Book ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 260, -1));

        Magazinename.setBorder(null);
        Magazinename.setCaretColor(new java.awt.Color(204, 204, 204));
        Magazinename.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        Magazinename.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        Magazinename.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(Magazinename, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 240, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("       New Releases");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 570, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Author");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 80, 30));

        Authors.setBackground(new java.awt.Color(0, 102, 102));
        Authors.setFont(new java.awt.Font("Athelas", 0, 18)); // NOI18N
        Authors.setForeground(new java.awt.Color(153, 153, 153));
        Authors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tara Westover", "Steve hawking", "Pedro domingos", "Oliver brown", "marilyn monroe", "Maria Shriver", "Jeff nathanson", "George Martin", "Elaine clayton", "Ann Crispin" }));
        getContentPane().add(Authors, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 200, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/publicImage/newroof.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, 70));

        Fantasy.setBackground(new java.awt.Color(0, 153, 153));
        Fantasy.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Fantasy.setForeground(new java.awt.Color(255, 255, 255));
        Fantasy.setText("Fantasy");
        getContentPane().add(Fantasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, -1, -1));

        Business.setBackground(new java.awt.Color(0, 153, 153));
        Business.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Business.setForeground(new java.awt.Color(255, 255, 255));
        Business.setText("Business & money ");
        getContentPane().add(Business, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, -1, -1));

        Science.setBackground(new java.awt.Color(0, 153, 153));
        Science.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Science.setForeground(new java.awt.Color(255, 255, 255));
        Science.setText("Science  ");
        getContentPane().add(Science, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, -1, -1));

        Selfhelp.setBackground(new java.awt.Color(0, 153, 153));
        Selfhelp.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Selfhelp.setForeground(new java.awt.Color(255, 255, 255));
        Selfhelp.setText("Self-help");
        getContentPane().add(Selfhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, -1, -1));

        Biography.setBackground(new java.awt.Color(0, 153, 153));
        Biography.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Biography.setForeground(new java.awt.Color(255, 255, 255));
        Biography.setText("Biography  ");
        getContentPane().add(Biography, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, -1, -1));

        ActionAdventure.setBackground(new java.awt.Color(0, 153, 153));
        ActionAdventure.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        ActionAdventure.setForeground(new java.awt.Color(255, 255, 255));
        ActionAdventure.setText("Action/Adventure");
        getContentPane().add(ActionAdventure, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, -1, -1));

        btn_search.setBackground(new java.awt.Color(0, 102, 102));
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Genres");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 80, 30));

        Drama.setBackground(new java.awt.Color(0, 153, 153));
        Drama.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        Drama.setForeground(new java.awt.Color(255, 255, 255));
        Drama.setText("Drama");
        Drama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DramaActionPerformed(evt);
            }
        });
        getContentPane().add(Drama, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, -1, -1));

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

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        isSearching = true;
        String bookname = Magazinename.getText().toString();
        if (bookname != null && !bookname.isEmpty()) {
            isSearchingBookName = true;
            mcontroller.isAvailableBook(bookname);
        }

        if (selected_author_name != null && !selected_author_name.isEmpty()) {
            mcontroller.searchBookAutor(selected_author_name);
        } 
        if (selected_genre.size() > 0) {
            mcontroller.searchBookGenre(selected_author_name,selected_genre);
        }
        if (Search.SearchScreen != null) {
            Search.SearchScreen.setVisible(true);
        }


    }//GEN-LAST:event_btn_searchActionPerformed

    private void DramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DramaActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_DramaActionPerformed

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
            java.util.logging.Logger.getLogger(BOOK4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BOOK4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BOOK4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BOOK4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BOOK4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ActionAdventure;
    private javax.swing.JComboBox<String> Authors;
    private javax.swing.JCheckBox Biography;
    private javax.swing.JCheckBox Business;
    private javax.swing.JCheckBox Drama;
    private javax.swing.JCheckBox Fantasy;
    private javax.swing.JTextField Magazinename;
    private javax.swing.JCheckBox Science;
    private javax.swing.JCheckBox Selfhelp;
    private javax.swing.JScrollPane allBooksNew;
    private javax.swing.JScrollPane allBooksOld;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel newPanelBook;
    private javax.swing.JPanel oldPanelBook;
    // End of variables declaration//GEN-END:variables

    @Override
    public void OnCompete(Message msg) {

        int status = msg.getStauts();
        Object Content = msg.getContent();
        String message = msg.getMessage();
        

                
        // loaded all books successful
        if (Content == null && status == STATUS_SUCCESSFUL && !isLoadedBooks) {
            for (final Book book : LoadedData.getInstance().getBooks()) {
                JLabel showBook = new javax.swing.JLabel();
                showBook.setPreferredSize(new Dimension(230, 350));
                JLabel copy = new javax.swing.JLabel();
                copy.setPreferredSize(new Dimension(230, 350));
                copy.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                                JOptionPane.showMessageDialog(myFrame, book.getDescription(), book.getName(), JOptionPane.INFORMATION_MESSAGE);
                        if (JOptionPane.showConfirmDialog(null, "Are you want to add " + book.getName() + " for author "+book.getAuthorName()
                                +" and  genre  :"+book.getGenre()+ " to cardlist?", "Question",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                           if (LoadedData.getInstance().getCurrentUser() != null) {
                                CartList item = new CartList(
                                        LoadedData.getInstance().getCurrentUser().getId(),
                                        book.getId(), "book");
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
                showBook.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                    JOptionPane.showMessageDialog(myFrame, book.getDescription(), book.getName(), JOptionPane.INFORMATION_MESSAGE);
                        if (JOptionPane.showConfirmDialog(null, "Are you want to add " + book.getName() + " for author "+book.getAuthorName()
                                +" and  genre  :"+book.getGenre()+ " to cardlist?", "Question",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                            if (LoadedData.getInstance().getCurrentUser() != null) {
                                CartList item = new CartList(
                                        LoadedData.getInstance().getCurrentUser().getId(),
                                        book.getId(), "book");
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
                showBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Book/" + book.getImg()))); // NOI18N
                copy.setIcon(showBook.getIcon());
                oldPanelBook.add(showBook);
                newPanelBook.add(copy);

            }
            isLoadedBooks = true;

        } //after added item in card list
        else if (status == STATUS_SUCCESSFUL && IsAddedToCartList) {
            JOptionPane.showMessageDialog(null, message, "Compete", JOptionPane.INFORMATION_MESSAGE);
            IsAddedToCartList = false;
        }
        else if(status == STATUS_SUCCESSFUL && isSearching){
            if(isSearchingBookName){
                new Search().setVisible(true);
                isSearchingBookName = false;
                msg.setStauts(STATUS_SEARCH);
                mSearch.OnCompete(msg);
            }else{
            oldPanelBook.removeAll();
            oldPanelBook.revalidate();
            oldPanelBook.repaint();
            ArrayList<Book> searchBook = (ArrayList)Content;
            if(searchBook != null){
            for (final Book b : searchBook) {
                 JLabel showBook = new javax.swing.JLabel();
                showBook.setPreferredSize(new Dimension(230, 350));
                showBook.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                    JOptionPane.showMessageDialog(myFrame, book.getDescription(), book.getName(), JOptionPane.INFORMATION_MESSAGE);
                        if (JOptionPane.showConfirmDialog(null,"Are you want to add " + b.getName() + " for author "+b.getAuthorName()
                                +" and  genre  :"+b.getGenre()+ " to cardlist?", "Question",
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
                showBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Book/" + b.getImg()))); // NOI18N
                oldPanelBook.add(showBook);
            }
            }
//            isSearching = false;
            }
        }
    }

    @Override
    public void OnFailure(Message msg) {
        JOptionPane.showMessageDialog(this, msg.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);

    }
}
