
import java.sql.*;
import javax.swing.table.DefaultTableModel;

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
        
        DatabaseConnect();
        model = (DefaultTableModel) DocsList.getModel();
        CreateColumns(); 
      //  RetriveRaws();
       RertiveBooks();
       RetriveConferenceProceedings();
       RetriveJournalArticles();
       RetriveMagazineArticles();
       RetriveWebPages();
       RetriveOthers();
      
       // sort();
    }
    
     private void DatabaseConnect (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String host = "jdbc:mysql://localhost:3306/marjiei";
            String username = "root";
            String password = ""; 
            con = DriverManager.getConnection( host, username, password );
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

   // private void RetriveRaws()
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

                 String[] books = {publishYear, publisher, author, title};
                 model.addRow(books); 
                 
                 rs = null;
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

                 String[] cProceedings = {publishYear, publisher, author, title};
                 model.addRow(cProceedings); 
                 
                  rs = null;
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

                 String[] jArticles = {publishYear, publisher, author, title};
                 model.addRow(jArticles); 
                 
                  rs = null;
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

                 String[] mArticles = {publishYear, publisher, author, title};
                 model.addRow(mArticles); 
                 
                  rs = null;
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

                 String[] webPages = {publishYear, publisher, author, title};
                 model.addRow(webPages); 
                 
                  rs = null;
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

                 String[] others = {publishYear, publisher, author, title};
                 model.addRow(others); 
                 
                  rs = null;
             }
          } catch (Exception ex)
                 {
             System.out.println(ex.getMessage());
                 }
      } // End RetriveOthers()
       
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
        add = new javax.swing.JComboBox<>();
        search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setAutoscrolls(true);

        DocsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(DocsList);

        add.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "إضافة وثيقة", "إدخال يدوي", "إنشاء مجلد" }));
        add.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                addPopupMenuWillBecomeVisible(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setText("تعديل وثيقة");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("حذف وثيقة");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addComponent(jLabel2)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel1)
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(21, 21, 21)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel4)))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit)
                        .addGap(14, 14, 14)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit)
                            .addComponent(delete)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:

        int index = add.getSelectedIndex();
        switch ( index )
        {
            case 0:
            // Code for importing file here.

            break;
            case 1:
            // Code for add entry manually here.
            addManuallyform frame = new addManuallyform();
            frame.setVisible(true);

            break;
            case 2:
            // Code for creating folder here.

        } // End Switch Statment.
    }//GEN-LAST:event_addActionPerformed

    private void addPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_addPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_addPopupMenuWillBecomeVisible

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
               //  DatabaseConnect connection = new DatabaseConnect(); // To connect to Database. 
              //   connection.getData();
                new Library().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DocsList;
    private javax.swing.JComboBox<String> add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
