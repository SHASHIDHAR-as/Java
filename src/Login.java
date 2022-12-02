import java.awt.*;

import javax.swing.*;

// import javafx.scene.text.Font.*;

import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login,signup,clear;

    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);   
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ICONS/logo.jpg"));
        Image i2 =i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//to set the size of the icon
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3); //we cannot pass the image to the label
        //to set the location of the icon ,jlabel is to write the content on the frame 
        label.setBounds(70,10,100,100);
        add(label);
        JLabel text=new JLabel("Welcome to the ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD,38));
        cardno.setBounds(120,150,250,30);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,38));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear =new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup =new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);   //TO SET THE BACKGROUND OF THE PAGE
        setSize(800,800);//TO SET THE SIZE OF THE PAGE
        setVisible(true);//to set the visibility of the frame
        setLocation(350,20);//set the position where to display
    }

    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource() ==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() ==login){
            Conn c1 = new Conn();
            String cardno  = cardTextField.getText();
            String pin  = pinTextField.getText();
            String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
            try{

            ResultSet rs = c1.s.executeQuery(q);
            if(rs.next()){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        }
        else if(ae.getSource() ==signup){
            setVisible(false);
            new Signup().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
        System.out.println("ACCOUNT IS BEING CREATED");
        
    }
    
}
