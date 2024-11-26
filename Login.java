
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  // for using ResultSet

public class Login extends JFrame implements ActionListener{
    JButton login,signUp,clear; // define button globally so that can access outside the method as well
    JTextField cardTextField;
    JPasswordField pinTextField; // use to take as a password
    String formNo;
    Login (){
        setTitle("AUTOMATED TELLER MACHINE"); // Use to set frame title
        setLayout(null); // by default layout is center 
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("iCON/iCON.jpg")); // to get image
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2); // converted to again in imageIcon as we can't pass a image obj in label
        JLabel label = new JLabel(i3);// cann't add anything directly in the frame , that why JLabel is used
        label.setBounds(20,5,100,100);
        add(label);
        JLabel text =  new JLabel("Welcome to ATM"); //used to write on frame
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(260,40,400,40); // set the text manually on frame as we have set layout is null
        add(text);
        
        JLabel Cardno =  new JLabel("Card No:"); //used to write on frame
      //  Cardno.setForeground(Color.red);
        Cardno.setFont(new Font("Raleway",Font.BOLD,28));
        Cardno.setBounds(120,150,150,30); // set the text manually on frame as we have set layout is null
        add(Cardno);
        
        cardTextField = new JTextField(); // set text field
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel Pin =  new JLabel("Pin:"); //used to write on frame
        Pin.setFont(new Font("Raleway",Font.BOLD,28));
        Pin.setBounds(120,220,150,30); // set the text manually on frame as we have set layout is null
        add(Pin);
        
        pinTextField = new JPasswordField(); // set text field
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));       
        add(pinTextField);
        
        login  = new JButton("SIGN IN"); // for creating button on frames
        login.setBounds(300,300,100,30);// used to set location of the button(or anything) on frame
        login.setBackground(Color.black); // use to set button cololr
        login.setForeground(Color.white); // use to set color of the text written on button
        login.addActionListener(this); // to catch button action event
        add(login);
        
        clear =  new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.black); // use to set button cololr
        clear.setForeground(Color.white); // use to set color of the text written on buttonc
        clear.addActionListener(this); // to catch button action event
        add(clear);
        
        signUp  = new JButton("SIGN UP");
        signUp.setBounds(300,350,250,30);
        signUp.setBackground(Color.black); // use to set button cololr
        signUp.setForeground(Color.white); // use to set color of the text written on buttons
        signUp.addActionListener(this); // to catch button action event
        add(signUp);
                      
        
        getContentPane().setBackground(Color.white); // used to get a frame by getContentpPane and set the color of the frame
        setSize(800,480); // set the size of the frame
        setVisible(true); // initially frame are not visible for user, 
        setLocation(250,100); // set location of the frame
        
        
}

    public void actionPerformed(ActionEvent ae){ // it will decide what action to be performed after 
        // click on the button
        if(ae.getSource() == clear){ // to check which button is clicked
            cardTextField.setText("");  // use to set the text of the fields
            pinTextField.setText("");
            
        }
        else if(ae.getSource() == login){
            Conn c =  new Conn();
            String Cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "Select * from login where Card_Number = '"+Cardnumber+"' and  Pin_Code = '"+pinnumber+"'";
            try{
               ResultSet rs =  c.s.executeQuery(query); // use executeQuery for DDL commands
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
            }
            }
               catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == signUp){
           setVisible(false);
           new SignUpOne().setVisible(true);
          // new SignUpThird(formNo).setVisible(true);
        }
    }

    public static void main(String args[]){
        new Login();
    }
}
