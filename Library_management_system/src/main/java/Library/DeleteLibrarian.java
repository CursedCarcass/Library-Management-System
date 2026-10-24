/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteLibrarian extends JFrame implements ActionListener {
    JTextField tf1;
    JButton bt1;
    
    public DeleteLibrarian() {
        super("Delete Librarian");
        setSize(400, 200);
        setLocation(400, 200);
        
        tf1 = new JTextField();
        bt1 = new JButton("Delete");
        bt1.addActionListener(this);
        
        JPanel p = new JPanel(new GridLayout(2, 2, 10, 10));
        p.add(new JLabel("Enter Librarian ID"));
        p.add(tf1);
        p.add(bt1);
        
        add(p);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                int id = Integer.parseInt(tf1.getText());
                int res = obj.stm.executeUpdate("delete from Librarian where Id="+id);
                if(res == 1) {
                    JOptionPane.showMessageDialog(null, "Librarian Deleted Successfully");
                    this.setVisible(false);
                }
            } catch(Exception ex) { ex.printStackTrace(); }
        }
    }
}