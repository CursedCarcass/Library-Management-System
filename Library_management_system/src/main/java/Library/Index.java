/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Index extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JButton bt1, bt2;
    JPanel p1, p3;
    
    public Index() {
        super("Library Login Page");
        setLocation(400, 200);
        setSize(500, 200);
        
        l1 = new JLabel("Admin Login");
        l2 = new JLabel("Librarian Login");
        l3 = new JLabel("Library Management");
        
        bt1 = new JButton("Login");
        bt2 = new JButton("Login");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        p1 = new JPanel(new GridLayout(2, 2, 10, 10));
        p1.add(l1); p1.add(bt1);
        p1.add(l2); p1.add(bt2);
        
        p3 = new JPanel();
        p3.setBackground(Color.black);
        l3.setForeground(Color.white);
        p3.add(l3);
        
        setLayout(new BorderLayout(10, 10));
        add(p3, "North");
        add(p1, "Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1) {
            new Admin().setVisible(true);
            this.setVisible(false);
        } else if(e.getSource() == bt2) {
            new Librarian().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Index().setVisible(true);
    }
}
