package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
       JTextField withdrawlAmount;
       JButton Withdraw, Cancel;
       String pinnumber;
    Withdrawl (String Pin){
      this.pinnumber = Pin;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
      Image i2 =  i1.getImage().getScaledInstance(850, 660, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,5,800, 650);
      add(image);

       JLabel text =  new JLabel("Enter withdrawl amount: ");
      text.setBounds(160,200,300,30);
      text.setForeground(Color.WHITE);
  //    text.setBackground(Color.red);        
      text.setFont(new Font("Raleway",Font.BOLD,16));
      image.add(text); // use to add texr on image 
      // add(text); this will not work in this case as we are adding text on image
      
      withdrawlAmount =  new JTextField();
      withdrawlAmount.setBounds(160,240,300,25);
   //   depositAmount.setForeground(Color.black);
   //   depositAmount.setBackground(Color.white);        
      withdrawlAmount.setFont(new Font("Raleway",Font.BOLD,16));
      image.add(withdrawlAmount); 
      
      Withdraw =  new JButton("Withdraw");
      Withdraw.setBounds(360,335,120,23);
   //   depositAmount.setForeground(Color.black);
   //   Deposit.setBackground(Color.white);        
      Withdraw.setFont(new Font("Raleway",Font.BOLD,16));
      Withdraw.addActionListener(this);
      image.add(Withdraw);
      
      Cancel =  new JButton("Cancel");
      Cancel.setBounds(360,361,120,23);
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
       if(ae.getSource() == Withdraw){
          String withdrawl_amount =  withdrawlAmount.getText();
          Date date = new Date();
          if(withdrawl_amount.equals("")){
              JOptionPane.showMessageDialog(null, "Please enter amount");
              
          }
          else{
              try{
              Conn c =  new Conn();
          //    String query1 = "select Amount from bank where  pin = pinnumber;";
              ResultSet rs = c.s.executeQuery("Select * FROM bank WHERE pin = '"+pinnumber+"'");
              int balance = 0;
              while(rs.next()){
                  if(rs.getString("transaction_type").equals("Deposit")){
                      balance += Integer.parseInt(rs.getString("Amount"));}
                  else{
                      balance -= Integer.parseInt(rs.getString("Amount"));
                   
              }}
              if(balance < Integer.parseInt(withdrawl_amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
              return;}
              String query2 = "insert into bank values('"+pinnumber+"', '"+date+"','Withdrawl', '"+withdrawl_amount+"')";
              c.s.executeUpdate(query2);
              JOptionPane.showMessageDialog(null, " A/c XX**** Debited with Rs. '"+withdrawl_amount+"' on '"+date+"' by INDIAN ATM Bal Rs. '"+balance+"'");
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
        new Withdrawl("");
}
}

