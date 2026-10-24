/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AddBook extends JFrame implements ActionListener {
    JTextField tf1, tf2, tf3, tf4, tf5;
    JButton bt1, bt2;
    
    public AddBook() {
        super("Add Book");
        setSize(550, 400);
        setLocation(400, 200);
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        bt1 = new JButton("Add Book");
        bt2 = new JButton("Cancel");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        JPanel p = new JPanel(new GridLayout(6, 2, 10, 10));
        p.add(new JLabel("Book No")); p.add(tf1);
        p.add(new JLabel("Book Name")); p.add(tf2);
        p.add(new JLabel("Author")); p.add(tf3);
        p.add(new JLabel("Publisher")); p.add(tf4);
        p.add(new JLabel("Quantity")); p.add(tf5);
        p.add(bt1); p.add(bt2);
        
        JLabel l1 = new JLabel("Add Book", JLabel.CENTER);
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
                String q = "insert into Add_Book (Book_No, Book_Name, Author, Publisher, Quantity, Issue_Book, Date) values('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"', 0, '"+date+"')";
                int aa = obj.stm.executeUpdate(q);
                if(aa == 1) {
                    JOptionPane.showMessageDialog(null, "Book Inserted Successfully!");
                    this.setVisible(false);
                }
            } catch(Exception ee) { ee.printStackTrace(); }
        } else {
            this.setVisible(false);
        }
    }
}
