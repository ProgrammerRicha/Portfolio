package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    int balance = 0;
    String designMsg;
    JButton Back, CheckBalance;
    BalanceEnquiry(String pin){
    this.pinnumber = pin;
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
    Image i2 =  i1.getImage().getScaledInstance(800, 660, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,5,800, 650);
    add(image);
    Back  = new JButton("Back");
    Back.setBounds(300,305,150,20);
    Back.setFont(new Font ("Raleway",Font.BOLD,17));
    Back.addActionListener(this);
    add(Back);
    
//    CheckBalance  = new JButton("CheckBalance");
//    CheckBalance.setBounds(340,350,150,20);
//    CheckBalance.setFont(new Font ("Raleway",Font.BOLD,17));
 //   CheckBalance.addActionListener(this);
 //   add(CheckBalance);
    
    try{
      Conn c =  new Conn();
      ResultSet rs = c.s.executeQuery("Select * FROM bank WHERE pin = '"+pinnumber+"'");
      while(rs.next()){
          if(rs.getString("transaction_type").equals("Deposit")){
              balance += Integer.parseInt(rs.getString("Amount"));}
          else{
              balance -= Integer.parseInt(rs.getString("Amount"));
      }}
      }
      catch(Exception e){
          System.out.println(e);
      }
    JLabel msg = new JLabel("Your account XXXX**** balance is Rs. '"+balance+"' ");                                
    msg.setBounds(150,200,300,25);
    msg.setForeground(Color.ORANGE);
 //   msg.setFont(new Font("Raleway", Font.BOLD, 20));
    image.add(msg);
    
    setSize(850,660);
    setLocation(100,10);
    setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == Back)
       {
           setVisible(false);
           new Transactions("").setVisible(true);
       }
                            
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
