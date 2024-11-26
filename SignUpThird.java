package bank.management.system;
import javax.swing.*;
import java.awt.*; // using font
import java.awt.event.*;
import java.util.*; // Random method is in this class

public class SignUpThird extends JFrame implements ActionListener{
    String FormNo;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBank, eStatement, declaration;
    JButton Submit, Cancel;
    JRadioButton savingAccount, fixedDepositAccount, currentAccount, recurringDepositAccount; 
    SignUpThird(String FormNo){
        this.FormNo = FormNo;
        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(800,675);
        setLocation(200,1);
        setLayout(null);
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("iCON/iCON.jpg")); // to get image
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2); // converted to again in imageIcon as we can't pass a image obj in label
        JLabel label = new JLabel(i3);// cann't add anything directly in the frame , that why JLabel is used
        label.setBounds(20,5,100,100);
        add(label);
        JLabel page3 = new JLabel("Page 3: Account Details");
        page3.setFont(new Font("Raleway",Font.BOLD,18));
        page3.setBounds(300,15,250,30);
        add(page3);
        // Account Type
        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway",Font.BOLD,18));
        accountType.setBounds(100,120,150,30);
        add(accountType);
        // set radio button fro acount type
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway",Font.BOLD,18));
        savingAccount.setBounds(100,160,200,30);
        savingAccount.setBackground(Color.white);
        add(savingAccount);
        //
        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setFont(new Font("Raleway",Font.BOLD,18));
        fixedDepositAccount.setBounds(350,160,250,30);
        fixedDepositAccount.setBackground(Color.white);
        add(fixedDepositAccount);
        
        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway",Font.BOLD,18));
        currentAccount.setBounds(100,200,200,30);
        currentAccount.setBackground(Color.white);
        add(currentAccount);
        
        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setFont(new Font("Raleway",Font.BOLD,18));
        recurringDepositAccount.setBounds(350,200,300,30);
        recurringDepositAccount.setBackground(Color.white);
        add(recurringDepositAccount);
        
        ButtonGroup accountGroup =  new ButtonGroup();
        accountGroup.add(savingAccount);
        accountGroup.add(fixedDepositAccount);
        accountGroup.add(currentAccount);
        accountGroup.add(recurringDepositAccount);
               
        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Raleway",Font.BOLD,18));
        cardNumber.setBounds(100,250,150,30);
        add(cardNumber);
        JLabel cardDigit = new JLabel("(Your 16-digit Card number)");
        cardDigit.setFont(new Font("Raleway",Font.BOLD,14));
        cardDigit.setBounds(100,275,250,30);
        add(cardDigit);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("Raleway",Font.BOLD,18));
        number.setBounds(350,250,300,30);
        add(number);
        
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(100,320,150,30);
        add(pin);
        JLabel pinLabel = new JLabel("(4 digit password)");
        pinLabel.setFont(new Font("Raleway",Font.BOLD,14));
        pinLabel.setBounds(100,350,250,20);
        add(pinLabel);
        
        JLabel pinPassword = new JLabel("XXXX");
        pinPassword.setFont(new Font("Raleway",Font.BOLD,18));
        pinPassword.setBounds(350,320,150,30);
        add(pinPassword);
        
        JLabel serviceRequired = new JLabel("Service Required:");
        serviceRequired.setFont(new Font("Raleway",Font.BOLD,18));
        serviceRequired.setBounds(100,380,200,30);
        add(serviceRequired);
        // set radio button for service required
        atmCard = new JCheckBox("ATM Card");
        atmCard.setFont(new Font("Raleway",Font.BOLD,18));
        atmCard.setBounds(100,420,200,30);
        atmCard.setBackground(Color.white);
        add(atmCard);
        
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Raleway",Font.BOLD,18));
        internetBanking.setBounds(350,420,200,30);
        internetBanking.setBackground(Color.white);
        add(internetBanking);
        
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Raleway",Font.BOLD,18));
        mobileBanking.setBounds(100,460,200,30);
        mobileBanking.setBackground(Color.white);
        add(mobileBanking);
        //
        emailAlerts= new JCheckBox("Email Alerts");
        emailAlerts.setFont(new Font("Raleway",Font.BOLD,18));
        emailAlerts.setBounds(350,460,200,30);
        emailAlerts.setBackground(Color.white);
        add(emailAlerts);
        
        chequeBank= new JCheckBox("Cheque Bank");
        chequeBank.setFont(new Font("Raleway",Font.BOLD,18));
        chequeBank.setBounds(100,500,200,30);
        chequeBank.setBackground(Color.white);
        add(chequeBank);
        
        eStatement = new JCheckBox("E-Statement");
        eStatement.setFont(new Font("Raleway",Font.BOLD,18));
        eStatement.setBounds(350,500,200,30);
        eStatement.setBackground(Color.white);
        add(eStatement);
        
        
        declaration = new JCheckBox("""
                                    I hereby declare that the above entered details are correct to the best of 
                                     my knowledge.""");
        declaration.setFont(new Font("Raleway",Font.BOLD,14));
        declaration.setBounds(50,540,800,20);
        declaration.setBackground(Color.white);
        add(declaration);
        
        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setFont(new Font("Raleway", Font.BOLD,14));
        Submit.setBounds(400,580,100,30);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);
        //
        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setBounds(100,580,100,30);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("Raleway", Font.BOLD,14));
        Cancel.addActionListener(this);
        add(Cancel);
        
    }
    @Override
    public void actionPerformed(ActionEvent AE){
        if (AE.getSource() == Submit){
            String accountType = null;
            if (savingAccount.isSelected()){
            accountType = "Saving Account";
        }
            else if (fixedDepositAccount.isSelected()){
            accountType = "Fixed Deposit Account";
        }
            else if (currentAccount.isSelected()){
            accountType = "Current Account";           
        }
            else if (recurringDepositAccount.isSelected()){
            accountType = "Recurring Deposit Account";
        }
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L)) + 50409360;
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";

            if(atmCard.isSelected()){
                facility = facility + " Atm Card";
            }
            if(internetBanking.isSelected()){
                facility = facility + " Internet Banking" ;
            }
            if(mobileBanking.isSelected()){
                facility = facility + " Mobile Banking";
            }
            if(emailAlerts.isSelected()){
                facility = facility + " Email Alerts" ;
            }
            if(chequeBank.isSelected()){
                facility = facility + " ChequeBank" ;
            }
            if(eStatement.isSelected()){
                facility = facility + " E-Statement";
            }
            try{
               if(accountType == null){
                   JOptionPane.showMessageDialog(null, "Account type is required");
               } 
               else{
                   Conn conn = new Conn();
                   String query1 = "insert into signUpThree values('"+ FormNo+"' , '"+accountType+"','"+cardNumber+"' "
                    + ", '"+pinNumber+"' , '"+facility+"')";
                   String query2 = "insert into login values('"+ FormNo+"' ,'"+cardNumber+"', '"+pinNumber+"')";
                   
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin code: " + pinNumber );
               }
              // new Login();
              setVisible(false);
              new Deposit(pinNumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
                
            }
        }           
        else if(AE.getSource() == Cancel){
             setVisible(false);
             new Login().setVisible(true);
             
        }
    }
    public static void main(String args[]){
        new SignUpThird("");
       
    }
}
