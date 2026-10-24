/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LibrarianSection extends JFrame implements ActionListener {
    public LibrarianSection() {
        super("Librarian Section");
        setSize(800, 500);
        setLocation(100, 100);
        
        MenuBar m1 = new MenuBar();
        Menu men1 = new Menu("Add Info");
        MenuItem ment1 = new MenuItem("Add Book");
        Menu men2 = new Menu("View Info");
        MenuItem ment2 = new MenuItem("View Book");
        MenuItem ment23 = new MenuItem("View Issue Book");
        Menu men3 = new Menu("Issue Info");
        MenuItem ment3 = new MenuItem("Issue Book");
        Menu men4 = new Menu("Return");
        MenuItem ment4 = new MenuItem("Return Book");
        Menu men5 = new Menu("Exit");
        MenuItem ment5 = new MenuItem("Logout");
        
        men1.add(ment1);
        men2.add(ment2); men2.add(ment23);
        men3.add(ment3);
        men4.add(ment4);
        men5.add(ment5);
        
        m1.add(men1); m1.add(men2); m1.add(men3); m1.add(men4); m1.add(men5);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment23.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        
        setMenuBar(m1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        String comd = e.getActionCommand();
        if(comd.equals("Add Book")) {
            new AddBook().setVisible(true);
        } else if(comd.equals("View Book")) {
            new ViewInfo().setVisible(true);
        } else if(comd.equals("View Issue Book")) {
            new ViewIssueBook().setVisible(true);
        } else if(comd.equals("Issue Book")) {
            new IssueBook().setVisible(true);
        } else if(comd.equals("Return Book")) {
            new ReturnBook().setVisible(true);
        } else if(comd.equals("Logout")) {
            new Index().setVisible(true);
            this.setVisible(false);
        }
    }
}