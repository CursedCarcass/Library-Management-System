/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton bt1, bt2;
    
    public Admin() {
        super("Admin Login Page");
        setLocation(400, 200);
        setSize(500, 200);
        
        l1 = new JLabel("Admin Login", JLabel.CENTER);
        l2 = new JLabel("Username");
        l3 = new JLabel("Password");
        
        tf1 = new JTextField();
        pf1 = new JPasswordField();
        bt1 = new JButton("Login");
        bt2 = new JButton("Cancel");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 10));
        p2.add(l2); p2.add(tf1);
        p2.add(l3); p2.add(pf1);
        p2.add(bt1); p2.add(bt2);
        
        setLayout(new BorderLayout(10, 10));
        add(l1, "North");
        add(p2, "Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                if (obj.con == null) return; // Stop if connection failed
                
                String s = "select * from admin where username='"+tf1.getText()+"' and password='"+pf1.getText()+"'";
                ResultSet rest = obj.stm.executeQuery(s);
                if(rest.next()) {
                    new AdminSection().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Admin Credentials!");
                }
            } catch(Exception ee) { 
                ee.printStackTrace(); 
                JOptionPane.showMessageDialog(null, "SQL Error:\n" + ee.getMessage());
            }
        } else if(e.getSource() == bt2) {
            new Index().setVisible(true);
            this.setVisible(false);
        }
    }
}
