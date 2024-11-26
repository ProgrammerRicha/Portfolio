package bank.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
 import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField NewPin, ConfirmPin;
    String pinnumber;
    JButton Change, Back;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(800, 660, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,5,800, 650);
        add(image);
        
        JLabel text =  new JLabel("Change your Pin");
        text.setBounds(230,200,300,30);
        text.setForeground(Color.WHITE);
        text.setBackground(Color.black);        
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        JLabel NewPinLabel =  new JLabel("New Pin:");
        NewPinLabel.setBounds(140,240,100,20);
        NewPinLabel.setForeground(Color.WHITE);
        NewPinLabel.setBackground(Color.black);        
        NewPinLabel.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(NewPinLabel);
        
        JLabel ConfirmPinLabel=  new JLabel("Confirm Pin:");
        ConfirmPinLabel.setBounds(140,270,100,20);
        ConfirmPinLabel.setForeground(Color.WHITE);
        ConfirmPinLabel.setBackground(Color.black);        
        ConfirmPinLabel.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(ConfirmPinLabel);
        
        NewPin =  new JPasswordField();
        NewPin.setBounds(250,240,200,20);
        NewPin.setForeground(Color.black);
        NewPin.setBackground(Color.WHITE);        
        NewPin.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(NewPin);
        
        ConfirmPin =  new JPasswordField();
        ConfirmPin.setBounds(250,270,200,20);
        ConfirmPin.setForeground(Color.black);
        ConfirmPin.setBackground(Color.white);        
        ConfirmPin.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(ConfirmPin);
        
        Change = new JButton("Change");
        Change.setFont(new Font("Raleway",Font.BOLD,16));
        Change.setBounds(330,350,100,24);
     //   Change.setBackground(new Color(4, 170, 109));
        Change.setForeground(Color.black);
        Change.addActionListener(this);
        image.add(Change);
        
        Back = new JButton("Back");
        Back.setFont(new Font("Raleway",Font.BOLD,16));
        Back.setBounds(150,350,100,24);
     //   Back.setBackground(new Color(4, 170, 109));
        Back.setForeground(Color.black);
        Back.addActionListener(this);
        image.add(Back);
        
        
        setSize(800, 650);
        setLocation(300,0); 
      //  setUndecorated(true);
        setVisible(true);
    }  
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Change){
           try{
              String NPin = NewPin.getText();
              String RPin = ConfirmPin.getText();
              if(!NPin.equals(RPin)){
                  JOptionPane.showMessageDialog(null, "New Pin & Confirm Pin mismatch");
                  return;
              }
              if(NPin.equals("")){
                  JOptionPane.showMessageDialog(null, "Please enter pin");
                  return;
              }
              if(RPin.equals("")){
                  JOptionPane.showMessageDialog(null, "Please enter pin");
                  return;
              }
              // Ensure the pin is numeric and of appropriate length
              if (!NPin.matches("\\d{4}")) { // Assuming pin should be 4 digits
                 JOptionPane.showMessageDialog(null, "Pin must be a 4-digit number");
                 return;
              }
              Conn c = new Conn();
              String query1 = "Update bank set pin = '"+Integer.parseInt(NPin)+"' where pin = '"+pinnumber+"'";
              String query2 = "Update login set Pin_Code = '"+Integer.parseInt(NPin)+"' where Pin_Code = '"+pinnumber+"'";
              String query3 = "Update signUpThree set Pin = '"+Integer.parseInt(NPin)+"' where Pin = '"+pinnumber+"'";
              
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              c.s.executeUpdate(query3);
              
              JOptionPane.showMessageDialog(null, "PIN CHANGED SUCCESSFULLY");
              setVisible(false);
              new Transactions(NPin).setVisible(true);
              
           } catch(Exception e){
               System.out.println(e);
           }
        }
        else if(ae.getSource() == Back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
    }}
    public static void main(String args[]){
        new PinChange("");
    }
}
