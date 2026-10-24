/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener {
    JTextField tf1, tf2;
    JButton bt1, bt2;
    
    public ReturnBook() {
        super("Return Book");
        setSize(450, 250);
        setLocation(400, 200);
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        bt1 = new JButton("Return Book");
        bt2 = new JButton("Cancel");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        JPanel p = new JPanel(new GridLayout(3, 2, 10, 10));
        p.add(new JLabel("Book No")); p.add(tf1);
        p.add(new JLabel("Student Id")); p.add(tf2);
        p.add(bt1); p.add(bt2);
        
        JLabel l1 = new JLabel("Return Book", JLabel.CENTER);
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
                String bno = tf1.getText();
                String stid = tf2.getText();
                int res = obj.stm.executeUpdate("delete from Issue_Book where Book_No='"+bno+"' and Student_Id='"+stid+"'");
                if(res > 0) {
                    obj.stm.executeUpdate("update Add_Book set Issue_Book = Issue_Book - 1, Quantity = Quantity + 1 where Book_No='"+bno+"'");
                    JOptionPane.showMessageDialog(null, "Book Returned Successfully!");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No matching issued record found.");
                }
            } catch(Exception ee) { ee.printStackTrace(); }
        } else {
            this.setVisible(false);
        }
    }
}
