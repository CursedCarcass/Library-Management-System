/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewLibrarian extends JFrame {
    String x[] = {"ID", "Name", "Password", "E-mail", "Contact", "Address", "City"};
    String y[][] = new String[20][7];
    int i = 0, j = 0;
    JTable t;
    
    public ViewLibrarian() {
        super("Librarian Information");
        setSize(900, 400);
        setLocation(100, 100);
        
        try {
            ConnectionClass obj = new ConnectionClass();
            ResultSet rest = obj.stm.executeQuery("select * from Librarian");
            while(rest.next()) {
                y[i][j++] = rest.getString("Id");
                y[i][j++] = rest.getString("Name");
                y[i][j++] = rest.getString("Password");
                y[i][j++] = rest.getString("Email");
                y[i][j++] = rest.getString("Contact");
                y[i][j++] = rest.getString("Address");
                y[i][j++] = rest.getString("City");
                i++; j = 0;
            }
            t = new JTable(y, x);
        } catch(Exception ex) { ex.printStackTrace(); }
        
        add(new JScrollPane(t));
    }
}