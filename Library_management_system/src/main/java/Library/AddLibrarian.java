/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AddLibrarian extends JFrame implements ActionListener {
    JTextField tf1, tf3, tf4, tf5, tf6;
    JPasswordField pf2;
    JButton bt1, bt2;
    
    public AddLibrarian() {
        super("Add Librarian");
        setSize(550, 400);
        setLocation(400, 200);
        
        JLabel l1 = new JLabel("Add Librarian", JLabel.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 22));
        l1.setForeground(Color.WHITE);
        JPanel p1 = new JPanel(new GridLayout(1, 1));
        p1.setBackground(Color.BLUE);
        p1.add(l1);
        
        tf1 = new JTextField();
        pf2 = new JPasswordField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        
        bt1 = new JButton("Add Librarian");
        bt2 = new JButton("Cancel");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        JPanel p2 = new JPanel(new GridLayout(7, 2, 10, 10));
        p2.add(new JLabel("Name")); p2.add(tf1);
        p2.add(new JLabel("Password")); p2.add(pf2);
        p2.add(new JLabel("E-mail")); p2.add(tf3);
        p2.add(new JLabel("Contact")); p2.add(tf4);
        p2.add(new JLabel("Address")); p2.add(tf5);
        p2.add(new JLabel("City")); p2.add(tf6);
        p2.add(bt1); p2.add(bt2);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into Librarian (Name, Password, Email, Contact, Address, City) values('"+tf1.getText()+"','"+pf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"')";
                int aa = obj.stm.executeUpdate(q);
                if(aa == 1) {
                    JOptionPane.showMessageDialog(null, "Librarian Inserted Successfully!");
                    this.setVisible(false);
                }
            } catch(Exception ee) { ee.printStackTrace(); }
        } else {
            this.setVisible(false);
        }
    }
}