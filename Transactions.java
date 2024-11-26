package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit, Withdrawal, FastCash, MiniStatement, PinChange, BalanceEnquiry, Exit;
    String  pinnumber;
    Transactions(String pin){
        this.pinnumber =  pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(800, 660, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,5,800, 650);
        add(image);
        
        JLabel text =  new JLabel("Please select your transaction");
        text.setBounds(180,220,300,30);
        text.setForeground(Color.WHITE);
        text.setBackground(Color.black);        
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(140,305,150,20);
        deposit.addActionListener(this);
        add(deposit);
                
        Withdrawal = new JButton("Cash Withdrawal");
        Withdrawal.setBounds(310,305,150,20);
        Withdrawal.addActionListener(this);
        add(Withdrawal);
        
        FastCash = new JButton("Fast cash");
        FastCash.setBounds(140,330,150,20);
        FastCash.addActionListener(this);
        add(FastCash);
        
        MiniStatement =  new JButton("Mini Statement");
        MiniStatement.setBounds(310,330,150,20);
        MiniStatement.addActionListener(this);
        add(MiniStatement);
        
        PinChange =  new JButton("PIN Change");
        PinChange.setBounds(140,355,150,20);
        PinChange.addActionListener(this);
        add(PinChange); 
        
        BalanceEnquiry =  new JButton("Balance Enquiry");
        BalanceEnquiry.setBounds(310,355,150,20);
        BalanceEnquiry.addActionListener(this);
        add(BalanceEnquiry); 
        
        Exit =  new JButton("Exit");
        Exit.setBounds(310,380,150,20);
        Exit.addActionListener(this);
        add(Exit); 
               
        setSize(800, 650);
        setLocation(300,0); 
        setUndecorated(true);
        setVisible(true);
              
        
    }   
    @Override
    public void actionPerformed(ActionEvent AE){
        if(AE.getSource() == Exit){
            System.exit(0);       
    }
        else if(AE.getSource() == deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
        
    }
    else if(AE.getSource() == Withdrawal){
        setVisible(false);
        new Withdrawl(pinnumber).setVisible(true);
        
    }
    else if(AE.getSource() == FastCash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
        
    }
        
   else if(AE.getSource() == PinChange){
        setVisible(false);
        new PinChange(pinnumber).setVisible(true);
        
    }
   else if(AE.getSource() == BalanceEnquiry){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
        
    }
    else if(AE.getSource() == MiniStatement){
    setVisible(false);
    new MiniStatement().setVisible(true);
        
    }
    }
    public static void main(String args[]){
        new Transactions("");
}
}

