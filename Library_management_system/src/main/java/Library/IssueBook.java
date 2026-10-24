/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener {
    JTextField tf1, tf2, tf3, tf4, tf5;
    JButton bt1, bt2;
    Choice ch;
    
    public IssueBook() {
        super("Issue Book Section");
        setSize(550, 400);
        setLocation(400, 200);
        
        ch = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            ResultSet rest = obj.stm.executeQuery("select Id from Add_Book");
            while(rest.next()) {
                ch.add(rest.getString("Id"));
            }
        } catch(Exception e) { e.printStackTrace(); }
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        bt1 = new JButton("Issue Book");
        bt2 = new JButton("Cancel");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        JPanel p = new JPanel(new GridLayout(7, 2, 10, 10));
        p.add(new JLabel("Book Id")); p.add(ch);
        p.add(new JLabel("Book No")); p.add(tf1);
        p.add(new JLabel("Book Name")); p.add(tf2);
        p.add(new JLabel("Student Id")); p.add(tf3);
        p.add(new JLabel("Student Name")); p.add(tf4);
        p.add(new JLabel("Student Contact")); p.add(tf5);
        p.add(bt1); p.add(bt2);
        
        JLabel l1 = new JLabel("Issue Book", JLabel.CENTER);
        l1.setForeground(Color.WHITE);
        JPanel p1 = new JPanel(new GridLayout(1, 1));
        p1.setBackground(Color.BLUE);
        p1.add(l1);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p, "Center");
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String date = new java.util.Date().toString();
                String q = "insert into Issue_Book (Id, Book_No, Book_Name, Student_Id, Student_Name, Student_Cont, Date) values("+ch.getSelectedItem()+",'"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+date+"')";
                obj.stm.executeUpdate(q);
                obj.stm.executeUpdate("update Add_Book set Issue_Book = Issue_Book + 1, Quantity = Quantity - 1 where Id="+ch.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Book Issued Successfully!");
                this.setVisible(false);
            } catch(Exception ee) { ee.printStackTrace(); }
        } else {
            this.setVisible(false);
        }
    }
}