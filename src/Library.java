
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatha Suliman
 */
public class Library extends javax.swing.JFrame {
    
    /**
     * Creates new form Library
     */
    
    DefaultTableModel model;
    private Connection con; 
    private Statement stmt;
    private ResultSet rs;
    String Query; 
    
    public Library() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Icons/logo.png")).getImage());
        DatabaseConnect();
        model = (DefaultTableModel) DocsList.getModel();
        CreateColumns(); 
        RertiveBooks();
        RetriveConferenceProceedings();
        RetriveJournalArticles();
        RetriveMagazineArticles();
        RetriveWebPages();
        RetriveOthers();
        sort();
       
    } // End library Constructor
    
     private void DatabaseConnect (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String host = "jdbc:mysql://localhost:3306/marjiei";
            String username = "root";
            String password = ""; 
            String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
            con = DriverManager.getConnection( host+unicode, username, password );
            stmt = con.createStatement();
            
        } catch ( Exception err ) {
          System.out.println( err.getMessage( ) ); }
    }
     
    private void CreateColumns()
    {
        
        model.addColumn("تاريخ الإضافة");
        model.addColumn("سنة النشر");
        model.addColumn("الناشر");
        model.addColumn("المؤلف");
        model.addColumn("العنوان");
    }

      private void RertiveBooks()
      {
          try 
          {
             Query = "Select * from book";
             rs = stmt.executeQuery(Query);
             while (rs.next())
             {
                 String title = rs.getString("title");
                 String author = rs.getString("author");
                 String publisher = rs.getString("publisher");
                 String publishYear = rs.getString("publishYear");
                 String dateAdded = rs.getString("DateAdded");
                 
                 String[] books = {dateAdded, publishYear, publisher, author, title};
                 model.addRow(books); 
                 
             }
             
          } catch (Exception ex)
          {
              System.out.println(ex.getMessage());
          }
          
      } // End RetriveBooks()   
          
             // RETRIVE CONFERENCE PROCEEDINGS
      private void RetriveConferenceProceedings()
      {
          try
          {
                Query = "Select * from conferenceproceeding";
             rs = stmt.executeQuery(Query);
             while (rs.next())
             {
                 String title = rs.getString("title");
                 String author = rs.getString("author");
                 String publisher = rs.getString("publisher");
                 String publishYear = rs.getString("publishYear");
                 String dateAdded = rs.getString("dateAdded");

                 String[] cProceedings = {dateAdded, publishYear, publisher, author, title};
                 model.addRow(cProceedings); 
                 
             }
          } catch (Exception ex)
                 {
             System.out.println(ex.getMessage());
                 }
      } // End RetriveConferenceProceedings()
           
             // RETRIVE JOURNAL ARTICLES  
      private void RetriveJournalArticles()
      {
          try
          {
               Query = "Select * from journalarticle";
             rs = stmt.executeQuery(Query);
             while (rs.next())
             {
                 String title = rs.getString("title");
                 String author = rs.getString("author");
                 String publisher = rs.getString("publisher");
                 String publishYear = rs.getString("publishYear");
                 String dateAdded = rs.getString("DateAdded");

                 String[] jArticles = {dateAdded, publishYear, publisher, author, title};
                 model.addRow(jArticles); 
                 
             }
          } catch (Exception ex)
                 {
             System.out.println(ex.getMessage());
                 }
      } // End RetriveJournalArticles()
            
             
             // RETRIVE MAGAZINE ARTICLES
      private void RetriveMagazineArticles()
      {
          try
          {
              Query = "Select * from magazinearticle";
             rs = stmt.executeQuery(Query);
             while (rs.next())
             {
                 String title = rs.getString("title");
                 String author = rs.getString("author");
                 String publisher = rs.getString("publisher");
                 String publishYear = rs.getString("publishYear");
                 String dateAdded = rs.getString("DateAdded");

                 String[] mArticles = {dateAdded, publishYear, publisher, author, title};
                 model.addRow(mArticles); 
                 
             }
          } catch (Exception ex)
                 {
             System.out.println(ex.getMessage());
                 }
      } // End RetriveMagazineArticles()
      
             // RETRIVE WEB PAGES
      private void RetriveWebPages()
      {
          try
          {
                   Query = "Select * from webpage";
             rs = stmt.executeQuery(Query);
             while (rs.next())
             {
                 String title = rs.getString("title");
                 String author = rs.getString("author");
                 String publisher = rs.getString("publisher");
                 String publishYear = rs.getString("publishYear");
                 String dateAdded = rs.getString("DateAdded");

                 String[] webPages = {dateAdded, publishYear, publisher, author, title};
                 model.addRow(webPages); 
                 
             }
          } catch (Exception ex)
                 {
             System.out.println(ex.getMessage());
                 }
      } // End RetriveWebPages()
             
             // RETRIVE OTHERS
       private void RetriveOthers()
      {
          try
          {
                Query = "Select * from other";
             rs = stmt.executeQuery(Query);
             while (rs.next())
             {
                 String title = rs.getString("title");
                 String author = rs.getString("author");
                 String publisher = rs.getString("publisher");
                 String publishYear = rs.getString("publishYear");
                 String dateAdded = rs.getString("DateAdded");

                 String[] others = {dateAdded, publishYear, publisher, author, title};
                 model.addRow(others); 
                 
             }
          } catch (Exception ex)
                 {
             System.out.println(ex.getMessage());
                 }
      } // End RetriveOthers()
       
       // to Sort using column header
      private void sort()
      {
          TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
          DocsList.setRowSorter(sorter);
      }
      
      private void Search(String key)
      {
          TableRowSorter<DefaultTableModel> filter = new TableRowSorter<DefaultTableModel>(model);
          DocsList.setRowSorter(filter);
          filter.setRowFilter(RowFilter.regexFilter(key));
      }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DocsList = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        addCombobox = new javax.swing.JComboBox<>();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("مكتبة مرجعي");

        jScrollPane1.setAutoscrolls(true);

        DocsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        DocsList.setToolTipText("مكتبة المراجع");
        jScrollPane1.setViewportView(DocsList);

        searchField.setToolTipText("بحث");
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        addCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "إضافة وثيقة", "إدخال يدوي", "إنشاء مجلد" }));
        addCombobox.setToolTipText("إضافة");
        addCombobox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                addComboboxPopupMenuWillBecomeVisible(evt);
            }
        });
        addCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComboboxActionPerformed(evt);
            }
        });

        editButton.setText("تعديل وثيقة");
        editButton.setToolTipText("تعديل");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("حذف وثيقة");
        deleteButton.setToolTipText("حذف");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addIcon.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/editIcon.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/deleteIcon.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editButton)
                        .addGap(14, 14, 14)
                        .addComponent(addCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editButton)
                        .addComponent(deleteButton)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void addComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComboboxActionPerformed
        // TODO add your handling code here:

        // 'Add' Combobox Selection
        int index = addCombobox.getSelectedIndex();
        switch ( index )
        {
            case 0:
            // Code for importing file here.

            break;
            case 1:
            // Code for add entry manually here.
            addManuallyform frame = new addManuallyform();
            frame.setVisible(true);

            this.setVisible(false);
            break;
            case 2:
            // Code for creating folder here.

        } // End Switch Statment.
    }//GEN-LAST:event_addComboboxActionPerformed

    private void addComboboxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_addComboboxPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_addComboboxPopupMenuWillBecomeVisible

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        
        String key = searchField.getText();
        Search(key);
    }//GEN-LAST:event_searchFieldKeyReleased

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
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Library().setVisible(true);
            }
        });
    } // End main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DocsList;
    private javax.swing.JComboBox<String> addCombobox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
