/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementnahom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
public class LoginForm extends JFrame{
    private JPanel parent;
    private JPanel top;
    private JLabel titleLabel;
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton loginButton;
    private JButton optionButton;
    public LoginForm(String title){
        super(title);
        parent=new JPanel(new GridLayout(3,2,5,5));
        top=new JPanel();
        titleLabel=new JLabel("Bank Management System Login");
        Font font=new Font(Font.SANS_SERIF,Font.BOLD,30);
        titleLabel.setFont(font);
        titleLabel.setBackground(Color.GREEN);
        top.add(titleLabel);
        userLabel=new JLabel("Username: ");
        passLabel=new JLabel("Password: ");
        userLabel.setFont(new Font(Font.SERIF,Font.BOLD,18));
        passLabel.setFont(new Font(Font.SERIF,Font.BOLD,18));
        txtUsername=new JTextField(15);
        txtPassword=new JPasswordField(15);
        txtUsername.setFont(new Font(Font.SERIF,Font.BOLD,18));
        txtPassword.setFont(new Font(Font.SERIF,Font.BOLD,18));
        loginButton=new JButton("Login");
        optionButton=new JButton("Forgot password?");
        loginButton.setFont(new Font(Font.SERIF,Font.BOLD,18));
        optionButton.setFont(new Font(Font.SERIF,Font.BOLD,18));
        parent.add(userLabel);
        parent.add(txtUsername);
        parent.add(passLabel);
        parent.add(txtPassword);
        parent.add(loginButton);
        parent.add(optionButton);
        this.add(top,BorderLayout.NORTH);
        this.add(parent,BorderLayout.CENTER);
        this.pack();
        txtPassword.addActionListener(
           new ActionListener(){
               public void actionPerformed(ActionEvent evt){
                   login();
               }
           }
        );
        loginButton.addActionListener(
          new ActionListener(){
              public void actionPerformed(ActionEvent evt){
                  login();
              }
          }
        );
    }
     public void login(){
         String user=txtUsername.getText();
                  String pass=String.valueOf(txtPassword.getPassword());
                  String hash=DB.getResult("user","password","username='"+user+"'");
                  if(hash!=null && !hash.isEmpty() && hash.equals(pass)){
                     /* Person p=Person.findPerson(user);
                      if(p==null){
                          System.out.println("Person not found!!!");
                          return;
                      }*/
                      Main form=new Main();
                      form.setVisible(true);
                  }
                  else{
                      JOptionPane.showMessageDialog(LoginForm.this,"Wrong username or password","Login failed",JOptionPane.ERROR_MESSAGE);
                  }
     }
}
