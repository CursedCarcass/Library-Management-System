/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AdminSection extends JFrame implements ActionListener {
    public AdminSection() {
        super("Admin Section");
        setSize(800, 500);
        setLocation(100, 100);
        
        MenuBar m1 = new MenuBar();
        Menu men1 = new Menu("Add Info");
        MenuItem ment1 = new MenuItem("Add Librarian");
        Menu men2 = new Menu("View Info");
        MenuItem ment2 = new MenuItem("View Librarian");
        Menu men3 = new Menu("Delete Info");
        MenuItem ment3 = new MenuItem("Delete Librarian");
        Menu men4 = new Menu("Exit");
        MenuItem ment4 = new MenuItem("Logout");
        
        men1.add(ment1);
        men2.add(ment2);
        men3.add(ment3);
        men4.add(ment4);
        
        m1.add(men1); m1.add(men2); m1.add(men3); m1.add(men4);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        
        setMenuBar(m1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        String comd = e.getActionCommand();
        if(comd.equals("Add Librarian")) {
            new AddLibrarian().setVisible(true);
        } else if(comd.equals("View Librarian")) {
            new ViewLibrarian().setVisible(true);
        } else if(comd.equals("Delete Librarian")) {
            new DeleteLibrarian().setVisible(true);
        } else if(comd.equals("Logout")) {
            new Index().setVisible(true);
            this.setVisible(false);
        }
    }
}
