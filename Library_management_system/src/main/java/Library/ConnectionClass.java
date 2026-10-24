/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionClass {
    public Connection con;
    public Statement stm;
    
    public ConnectionClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // CHANGE "root" and "pass123" IF YOUR MYSQL PASSWORD IS DIFFERENT
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            stm = con.createStatement();
            System.out.println("Connected Successfully");
        } catch(Exception e) {
            e.printStackTrace();
            // This will show a popup on your screen with the exact error
            JOptionPane.showMessageDialog(null, "Database Connection Error:\n" + e.getMessage());
        }
    }
}