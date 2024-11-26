package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
       JTextField depositAmount;
       JButton Deposit, Cancel;
       String pinnumber;
   Deposit(String Pin){
      this.pinnumber = Pin;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
      Image i2 =  i1.getImage().getScaledInstance(850, 660, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,5,800, 650);
      add(image);

      JLabel text =  new JLabel("Enter deposit amount: ");
      text.setBounds(160,200,300,30);
      text.setForeground(Color.WHITE);
  //    text.setBackground(Color.red);        
      text.setFont(new Font("Raleway",Font.BOLD,16));
      image.add(text); // use to add texr on image 
      // add(text); this will not work in this case as we are adding text on image
      
      depositAmount =  new JTextField();
      depositAmount.setBounds(160,240,300,25);
   //   depositAmount.setForeground(Color.black);
   //   depositAmount.setBackground(Color.white);        
      depositAmount.setFont(new Font("Raleway",Font.BOLD,16));
      image.add(depositAmount); 
      
      Deposit =  new JButton("Deposit");
      Deposit.setBounds(380,335,100,23);
   //   depositAmount.setForeground(Color.black);
   //   Deposit.setBackground(Color.white);        
      Deposit.setFont(new Font("Raleway",Font.BOLD,16));
      Deposit.addActionListener(this);
      image.add(Deposit);
      
      Cancel =  new JButton("Cancel");
      Cancel.setBounds(380,361,100,23);
   //   depositAmount.setForeground(Color.black);
   //   Cancel.setBackground(Color.white);        
      Cancel.setFont(new Font("Raleway",Font.BOLD,16));
      Cancel.addActionListener(this);
      image.add(Cancel);
      
      setSize(850,660);
      setLocation(300,5);
      // setBounds()
      setVisible(true);
   }
   @Override
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == Deposit){
          String deposit_amount =  depositAmount.getText();
          Date date = new Date();
          if(deposit_amount.equals("")){
              JOptionPane.showMessageDialog(null, "Please enter amount");
              
          }
          else{
              try{
              Conn c =  new Conn();
              String query = "insert into bank values('"+pinnumber+"', '"+date+"','Deposit', '"+deposit_amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs. '"+deposit_amount+"' Deposited Sucessfully ");
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
              }
              catch(Exception e){
                  System.out.println(e);
              }
          
       }
                 
       }
   else if(ae.getSource() == Cancel)
   {
     setVisible(false);
     new Transactions(pinnumber).setVisible(true);
   }}
    public static void main(String args[]){
        new Deposit("");
}
}
