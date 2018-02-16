/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatha Suliman
 */

import java.sql.*;


public class DatabaseConnect {
    
    private Connection con; 
    private Statement stmt;
    private ResultSet rs;
    
    public DatabaseConnect (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String host = "jdbc:derby://localhost:3306/marjiei";
            String username = "root";
            String password = " "; 
            con = DriverManager.getConnection( host, username, password );
            stmt = con.createStatement();
            
        } catch ( Exception err ) {
          System.out.println( err.getMessage( ) ); }
    }
    
  
}
