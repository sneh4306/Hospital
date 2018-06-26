
package com.admin;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;


public class LoginPage extends JFrame implements ActionListener{
    JPanel panel;
    JLabel label;
    JLabel label1,lbl2;
    JTextField txt1;
    JPasswordField txt2;
    JButton btn1;
    
    public LoginPage()
    {
        addComponents();
        
        panel.add(label);
        panel.add(txt1);
        panel.add(label1);
        panel.add(txt2);
        panel.add(btn1);
        panel.add(lbl2);
        add(panel);
        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,350);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username="",password="";
        username=txt1.getText();
        password=txt2.getText();
         if(username.equals("admin") && password.equals("1234"))
         {  this.setVisible(false);
             AdminScreenMain am =new AdminScreenMain();
             am=null;
         }
        else
         {
             lbl2.setText("Invalid Login. Please try again");
         }}
    private void addComponents()
    {
        panel=new JPanel();
        panel.setBounds(20, 20, 360, 300);
        panel.setLayout(null);
        
        
        label=new JLabel("Enter User Name");
        label.setBounds(50,50,130,40);
        
        
        txt1=new JTextField(20);
        txt1.setBounds(180,50,150,40);
        
        
        
        txt2=new JPasswordField(20);
        txt2.setBounds(180,120,150,40);
        
        
        label1=new JLabel("Enter Password");
        label1.setBounds(50,120,130,40);
        
        btn1= new JButton("LOGIN");
        btn1.setBounds(180,190,90,40);
        btn1.addActionListener(this);
        
        lbl2=new JLabel("");
        lbl2.setBounds(100,250,250,40);
        
       
    }
}
    

