/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewIssueBook extends JFrame {
    String x[] = {"ID", "Book No", "Book Name", "Student_Id", "Student_Name", "Student_Cont", "Date"};
    String y[][] = new String[20][7];
    int i = 0, j = 0;
    JTable t;
    
    public ViewIssueBook() {
        super("View Issue Book Information");
        setSize(900, 400);
        setLocation(100, 100);
        
        try {
            ConnectionClass obj = new ConnectionClass();
            ResultSet rest = obj.stm.executeQuery("select * from Issue_Book");
            while(rest.next()) {
                y[i][j++] = rest.getString("Id");
                y[i][j++] = rest.getString("Book_No");
                y[i][j++] = rest.getString("Book_Name");
                y[i][j++] = rest.getString("Student_Id");
                y[i][j++] = rest.getString("Student_Name");
                y[i][j++] = rest.getString("Student_Cont");
                y[i][j++] = rest.getString("Date");
                i++; j = 0;
            }
            t = new JTable(y, x);
        } catch(Exception ex) { ex.printStackTrace(); }
        
        add(new JScrollPane(t));
    }
}