/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewInfo extends JFrame {
    String x[] = {"ID", "Book No", "Book Name", "Author", "Quantity", "Issue_Book", "Date"};
    String y[][] = new String[20][7];
    int i = 0, j = 0;
    JTable t;
    
    public ViewInfo() {
        super("View Book Information");
        setSize(900, 400);
        setLocation(100, 100);
        
        try {
            ConnectionClass obj = new ConnectionClass();
            ResultSet rest = obj.stm.executeQuery("select * from Add_Book");
            while(rest.next()) {
                y[i][j++] = rest.getString("Id");
                y[i][j++] = rest.getString("Book_No");
                y[i][j++] = rest.getString("Book_Name");
                y[i][j++] = rest.getString("Author");
                y[i][j++] = rest.getString("Quantity");
                y[i][j++] = rest.getString("Issue_Book");
                y[i][j++] = rest.getString("Date");
                i++; j = 0;
            }
            t = new JTable(y, x);
        } catch(Exception ex) { ex.printStackTrace(); }
        
        add(new JScrollPane(t));
    }
}