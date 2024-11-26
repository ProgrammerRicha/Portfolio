package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;  // for date class (imp. date class also in SQL class
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FastCash extends JFrame implements ActionListener{
    JButton amount100, amount500, amount1000, amount2000, amount5000, amount10000, Back, deposit,Withdrawl;
    String  pinnumber;
    FastCash(String pin){
        this.pinnumber =  pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(800, 660, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,5,800, 650);
        add(image);
        
        JLabel text =  new JLabel("Please select withdrawl amount");
        text.setBounds(140,220,300,30);
        text.setForeground(Color.WHITE);
        text.setBackground(Color.black);        
        text.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(text);
        
        amount100 = new JButton("RS 100");
        amount100.setBounds(140,305,150,20);
        amount100.addActionListener(this);
        add(amount100);
                
        amount500 = new JButton("RS 500");
        amount500.setBounds(310,305,150,20);
        amount500.addActionListener(this);
        add(amount500);
        
        amount1000 = new JButton("RS 1000");
        amount1000.setBounds(140,330,150,20);
        amount1000.addActionListener(this);
        add(amount1000);
        
        amount2000 =  new JButton("RS 2000");
        amount2000.setBounds(310,330,150,20);
        amount2000.addActionListener(this);
        add(amount2000);
        
        amount5000 =  new JButton("RS 5000");
        amount5000.setBounds(140,355,150,20);
        amount5000.addActionListener(this);
        add(amount5000); 
        
        amount10000 =  new JButton("RS 10000");
        amount10000.setBounds(310,355,150,20);
        amount10000.addActionListener(this);
        add(amount10000); 
        
        Back =  new JButton("Back");
        Back.setBounds(310,380,150,20);
        Back.addActionListener(this);
        add(Back); 
        
        
        
        setSize(800, 650);
        setLocation(300,0); 
        setUndecorated(true);
        setVisible(true);
              
        
    }   
    @Override
    public void actionPerformed(ActionEvent AE){
        if(AE.getSource() == Back){
            setVisible(false);
            new Transactions("").setVisible(true);      
    }   
        else{
            String amount = ((JButton)AE.getSource()).getText().substring(3); // Rs 100
            Conn c =  new Conn();
            try{
              ResultSet rs = c.s.executeQuery("Select * FROM bank WHERE pin = '"+pinnumber+"'");
              int balance = 0;
              while(rs.next()){
                  String numStr = rs.getString("Amount");
                  if(rs.getString("transaction_type").equals("Deposit") && numStr != null){
                      balance += Integer.parseInt(numStr);}
                  else{
                      balance -= Integer.parseInt(numStr);
                   
              }
                  if(AE.getSource() != Back && balance < Integer.parseInt(amount)){
                      JOptionPane.showMessageDialog(null, "Insufficient balance");
                      return;
            }
              Date date = new Date();
              String query = "insert into bank values('"+pinnumber+"', '"+date+"','Withdrawl', '"+amount+"')";
              c.s.executeUpdate(query);
              int remaining = balance - Integer.parseInt(amount);
              JOptionPane.showMessageDialog(null, " A/c XX**** Debited with Rs. '"+amount+"' on '"+date+"' by INDIAN ATM Bal Rs. '"+remaining+"'");
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
              }}
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
}
}

