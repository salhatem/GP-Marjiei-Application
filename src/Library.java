
import java.sql.*;
import javax.swing.table.*;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    String Query, fName = ""; ; 
    
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
                 String publisher = rs.getString("publisher");
                 int publishYear = rs.getInt("publishYear");
                 String dateAdded = rs.getString("DateAdded");
                 
                 String[] docs = {dateAdded, publishYear+"", publisher, author, title};
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        addDocMenuItem = new javax.swing.JMenuItem();
        manuallyMenuItem = new javax.swing.JMenuItem();
        newFolderMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        editDocMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        deleteDocMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();

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

        jLabel1.setText("العنوان");

        jTextField1.setColumns(20);

        jTextField2.setColumns(20);

        jLabel2.setText("المؤلف");

        jLabel3.setText("الناشر");

        jTextField3.setColumns(20);

        jTextField4.setColumns(20);

        jLabel4.setText("سنة النشر");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "كتاب", "مقال صحفي", "مقال مجلة", "صفحة ويب", "ورقة مؤتمر", "أخرى" }));

        jTextField6.setColumns(20);

        jLabel6.setText("الصفحات");

        jLabel5.setText("extra1");

        jTextField5.setColumns(20);

        jLabel7.setText("extra2");

        jTextField7.setColumns(20);

        fileMenu.setText("ملف");

        addDocMenuItem.setText("إضافة وثيقة");
        addDocMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(addDocMenuItem);

        manuallyMenuItem.setText("إدخال يدوي");
        manuallyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manuallyMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(manuallyMenuItem);

        newFolderMenuItem.setText("إنشاء مجلد");
        fileMenu.add(newFolderMenuItem);
        fileMenu.add(jSeparator1);

        editDocMenuItem.setText("تعديل وثيقة");
        fileMenu.add(editDocMenuItem);
        fileMenu.add(jSeparator2);

        deleteDocMenuItem.setText("حذف وثيقة");
        fileMenu.add(deleteDocMenuItem);
        fileMenu.add(jSeparator3);

        exitMenuItem.setText("خروج");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar2.add(fileMenu);

        jMenu4.setText("تعديل");
        jMenuBar2.add(jMenu4);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/helpIcon.png"))); // NOI18N

        helpMenuItem.setText("مساعدة");
        helpMenu.add(helpMenuItem);

        jMenuBar2.add(helpMenu);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(editButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(interfaceLanguageButton)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchIcon)
                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton)))
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
              try 
              {
            JFileChooser chooser = new JFileChooser();
            
            //*****************filter***********************
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Pdf file(.pdf)", "pdf");
            chooser.setFileFilter(filter);
            
            //*****************JFileChooser*****************
            int returnValue = chooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
            fName = chooser.getSelectedFile().getPath();
            }
            
            //**************get PDF file info***************
            PDFManager pdfManager = new PDFManager();
            pdfManager.setFilePath(fName);
            pdfManager.ToText();
            
            } catch (HeadlessException | IOException ex)
                  {
                    System.out.println(ex.getMessage());
                  }
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
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        String key = searchField.getText();
        Search(key);
    }//GEN-LAST:event_searchFieldKeyReleased

    private void addDocMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDocMenuItemActionPerformed

    private void manuallyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manuallyMenuItemActionPerformed
        // TODO add your handling code here:
        addManuallyform frame = new addManuallyform();
            frame.setVisible(true);
    }//GEN-LAST:event_manuallyMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMenuItemActionPerformed

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
    private javax.swing.JMenuItem addDocMenuItem;
    private javax.swing.JLabel addIcon;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenuItem deleteDocMenuItem;
    private javax.swing.JLabel deleteIcon;
    private javax.swing.JButton editButton;
    private javax.swing.JMenuItem editDocMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JButton interfaceLanguageButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JMenuItem manuallyMenuItem;
    private javax.swing.JMenuItem newFolderMenuItem;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchIcon;
    // End of variables declaration//GEN-END:variables
}
