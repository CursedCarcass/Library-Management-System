/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Librarian extends JFrame implements ActionListener {
    JTextField tf1;
    JPasswordField pf1;
    JButton bt1, bt2;
    
    public Librarian() {
        super("Librarian Login");
        setSize(500, 200);
        setLocation(400, 200);
        
        tf1 = new JTextField();
        pf1 = new JPasswordField();
        bt1 = new JButton("Login");
        bt2 = new JButton("Cancel");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        JPanel p = new JPanel(new GridLayout(3, 2, 10, 10));
        p.add(new JLabel("Name")); p.add(tf1);
        p.add(new JLabel("Password")); p.add(pf1);
        p.add(bt1); p.add(bt2);
        
        JLabel l1 = new JLabel("Librarian Login", JLabel.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        JPanel p1 = new JPanel(new GridLayout(1, 1));
        p1.setBackground(Color.BLUE);
        p1.add(l1);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p, "Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                ResultSet rest = obj.stm.executeQuery("select * from Librarian where Name='"+tf1.getText()+"' and Password='"+pf1.getText()+"'");
                if(rest.next()) {
                    new LibrarianSection().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Librarian Credentials");
                }
            } catch(Exception ee) { ee.printStackTrace(); }
        } else {
            new Index().setVisible(true);
            this.setVisible(false);
        }
    }
}