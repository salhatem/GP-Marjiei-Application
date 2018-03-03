
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
        RertiveDocuments();
        sort();
       
    } // End library Constructor
    
     private void DatabaseConnect (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String host = "jdbc:mysql://localhost:3306/mg-marjieidb";
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
        model.addColumn("الصفحات");
        model.addColumn("المؤلف");
        model.addColumn("العنوان");
    }

      public void RertiveDocuments()
      {
          try 
          {
             Query = "Select * from referencedocument";
             rs = stmt.executeQuery(Query);
             while (rs.next())
             {
                 String title = rs.getString("title");
                 String author = rs.getString("author");
                 int pages = rs.getInt("pages");
                 String publisher = rs.getString("publisher");
                 int publishYear = rs.getInt("publishYear");
                 String dateAdded = rs.getString("DateAdded");
                 
                 String[] docs = {dateAdded, publishYear+"", publisher ,pages+"", author, title};
                 model.addRow(docs);   
             }
             
          } catch (Exception ex)
          {
              System.out.println(ex.getMessage());
          }
          
      } // End RertiveDocuments()   
       
       // to Sort Documents using column header
      private void sort()
      {
          TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
          DocsList.setRowSorter(sorter);
      }
      
      // Search Documents List
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
        addIcon = new javax.swing.JLabel();
        deleteIcon = new javax.swing.JLabel();
        searchIcon = new javax.swing.JLabel();
        interfaceLanguageButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("مكتبة مرجعي");
        setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane1.setAutoscrolls(true);

        DocsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        DocsList.setToolTipText("مكتبة المراجع");
        DocsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DocsListMouseClicked(evt);
            }
        });
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

        editButton.setText("تعديل ");
        editButton.setToolTipText("تعديل");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("حذف وثيقة");
        deleteButton.setToolTipText("حذف");

        addIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addIcon.png"))); // NOI18N

        deleteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/deleteIcon.png"))); // NOI18N

        searchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N

        interfaceLanguageButton.setText("English");

        jLabel1.setText("العنوان :");

        jLabel2.setText("المؤلف :");

        jLabel3.setText(" الناشر :");

        jLabel4.setText("سنة النشر :");

        jLabel6.setText("الصفحات :");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jMenu1.setText("إضافة");
        jMenuBar2.add(jMenu1);

        jMenu4.setText("تعديل");
        jMenuBar2.add(jMenu4);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/helpIcon.png"))); // NOI18N
        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(editButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(interfaceLanguageButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchIcon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(deleteIcon)
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCombobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addIcon)
                                .addGap(25, 25, 25)))
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addIcon)
                            .addComponent(deleteIcon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton))
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(interfaceLanguageButton)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchIcon)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addGap(29, 29, 29)
                        .addComponent(editButton)
                        .addGap(40, 40, 40)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

          //  this.setVisible(false);
            break;
            case 2:
            // Code for creating folder here.

        } // End Switch Statment.
    }//GEN-LAST:event_addComboboxActionPerformed

    private void addComboboxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_addComboboxPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_addComboboxPopupMenuWillBecomeVisible

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
     try{ 
       
         String value1= jTextField1.getText();
         String value2= jTextField2.getText();
         String value3= jTextField3.getText();
         String value4= jTextField4.getText();
         String value5= jTextField5.getText();
        

            String query = "update referencedocument set title='"+value1+"' , author='"+value2+"', pages='"+value3+"', publisher='"+value4+"', publishYear='"+value5+"' where title='"+value1+"' ";
        PreparedStatement pst = con.prepareStatement(query);
     pst.execute();

     JOptionPane.showMessageDialog(null, "تم التحديث بنجاح");
     }catch (Exception ex)
          {
              JOptionPane.showMessageDialog(null, ex);
          }
       
     
    }//GEN-LAST:event_editButtonActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        String key = searchField.getText();
        Search(key);
    }//GEN-LAST:event_searchFieldKeyReleased
  
          
     // End RertiveDocuments()   
    private void DocsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DocsListMouseClicked
         // TODO add your handling code here:
    int i = DocsList.getSelectedRow();
      TableModel model = DocsList.getModel();  
        
         // Display Slected Row In JTexteFields
        jTextField5.setText(model.getValueAt(i,1).toString());
        jTextField4.setText(model.getValueAt(i,2).toString());
        jTextField3.setText(model.getValueAt(i,3).toString());
        jTextField2.setText(model.getValueAt(i,4).toString());
        jTextField1.setText(model.getValueAt(i,5).toString());
       
    }//GEN-LAST:event_DocsListMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
    private javax.swing.JLabel addIcon;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteIcon;
    private javax.swing.JButton editButton;
    private javax.swing.JButton interfaceLanguageButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchIcon;
    // End of variables declaration//GEN-END:variables

    private void executeSQlQuery(String query, String updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
