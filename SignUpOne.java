package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*; // for getting random numbers
import com.toedter.calendar.JDateChooser;
import java.awt.event.*; // import when using ActionListener

public class SignUpOne extends JFrame implements ActionListener{
    // set field globally
    int FormNo;
    JTextField nameText, FatherNameText, emailText, addressText, cityText, stateText, pinText;
    JComboBox stateCh;
    JButton next;
    JRadioButton male, female, transgender, married, unmarried, other;
    JDateChooser dateChooser;
    SignUpOne(){
        getContentPane().setBackground(Color.WHITE); // design a frame & color class is within AWT class
        setSize(800,675);
        setLocation(200,1);
        setVisible(true);
        setLayout(null); // if setlayout is not null by default it will take border layout 
        // and setBound will not work
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("iCON/iCON.jpg")); // to get image
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2); // converted to again in imageIcon as we can't pass a image obj in label
        JLabel label = new JLabel(i3);// cann't add anything directly in the frame , that's why JLabel is used
        label.setBounds(20,5,100,100);
        add(label);
        Random ran =  new Random(); // it will generate random number
        FormNo =  (Math.abs(ran.nextInt()) % 2000000) + 3000;
        JLabel Application = new JLabel("APPLICATION FORM NO. " + FormNo);
        Application.setFont(new Font("Raleway",Font.BOLD, 28));
        Application.setBounds(140,10,600,40);
        add(Application);
        
        // Personal details
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD, 18));
        personalDetails.setBounds(250,70,400,30);
        add(personalDetails);
        
       // Name
        JLabel name = new JLabel("Name:");
        name.setBounds(100,130,100,30);
        name.setFont(new Font("Raleway",Font.BOLD, 18));       
        add(name);
        
        // Name text field
        nameText =  new JTextField("");
        nameText.setFont(new Font("Arial",Font.BOLD,18));
        nameText.setBounds(300,130,400,30);
        add(nameText);
              
        // Father's name
        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Raleway",Font.BOLD, 18));
        fatherName.setBounds(100,175,200,30);
        add(fatherName);
        
        // father's Name text field
        FatherNameText =  new JTextField("");
        FatherNameText.setFont(new Font("Arial",Font.BOLD,18));
        FatherNameText.setBounds(300,175,400,30);
        add(FatherNameText);
        // date of birth
        JLabel dateOfBirth = new JLabel("Date Of Birth:");
        dateOfBirth.setFont(new Font("Raleway",Font.BOLD, 18));
        dateOfBirth.setBounds(100,220,150,30);
//      dateOfBirth.setForeground(Color.black);
//      dateOfBirth.setForeground(new Color(105,105,105));
        add(dateOfBirth);
        
        dateChooser =  new JDateChooser(); // use to choose the date note : please insert JAr file first
        dateChooser.setBounds(300,220,400,30);
        add(dateChooser);
        
        // gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD, 18));
        gender.setBounds(100,265,150,30);
        add(gender);
        
        // Radio button for gender
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway",Font.BOLD, 18));
        male.setBounds(300,265,100,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway",Font.BOLD, 18));
        female.setBounds(420,265,100,30);
        female.setBackground(Color.white);
        add(female);
        
        transgender = new JRadioButton("Transgender");
        transgender.setFont(new Font("Raleway",Font.BOLD, 18));
        transgender.setBounds(540,265,150,30);
        transgender.setBackground(Color.white);        
        add(transgender);
        // ButtonGroup: use to select only one gender at a time
        // if ButtonGroup is not used then all 3 gender user can select all 3 gender
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(transgender);
               
        // email address
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD, 18));
        email.setBounds(100,310,200,30);
        add(email);
        
        // Email text field
        emailText =  new JTextField("");
        emailText.setFont(new Font("Arial",Font.BOLD,18));
        emailText.setBounds(300,310,400,30);
        add(emailText);
        
        // Marital Status
        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD, 18));
        maritalStatus.setBounds(100,355,200,30);
        add(maritalStatus);
        // radio buttons for marital status
        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway",Font.BOLD, 18));
        married.setBounds(300,355,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway",Font.BOLD, 18));
        unmarried.setBounds(440,355,150,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway",Font.BOLD, 18));
        other.setBounds(610,355,100,30);
        other.setBackground(Color.white);        
        add(other);
        
        // Group marital status
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        // address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD, 18));
        address.setBounds(100,400,200,30);
        add(address);
        
        
        // Address text field
        addressText =  new JTextField("");
        addressText.setFont(new Font("Arial",Font.BOLD,18));
        addressText.setBounds(300,400,400,30);
        add(addressText);
        // city
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD, 18));
        city.setBounds(100,445,150,30);
        add(city);
        
        // city text field
        cityText =  new JTextField("");
        cityText.setFont(new Font("Arial",Font.BOLD,18));
        cityText.setBounds(300,445,400,30);
        add(cityText);
        // state:
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD, 18));
        state.setBounds(100,490,150,30);
        add(state);
        
        // state text field
        // List of states in India (you can add or modify based on your requirements)
        String stateArray[] = {
            "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", 
            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", 
            "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", 
            "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", 
            "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", 
            "Uttar Pradesh", "Uttarakhand", "West Bengal", "Andaman and Nicobar Islands", 
            "Chandigarh", "Dadra and Nagar Haveli", "Lakshadweep", 
            "Delhi", "Puducherry", "Other"
        };

        stateCh = new JComboBox(stateArray);
        stateCh.setFont(new Font("Arial", Font.BOLD, 18));
        stateCh.setBounds(300, 490, 400, 30);
        stateCh.setBackground(Color.white);
        add(stateCh);

        
        // Pin code
        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway",Font.BOLD, 18));
        pinCode.setBounds(100,535,150,30);
        add(pinCode);
        // Pin text field
        pinText =  new JTextField("");
        pinText.setFont(new Font("Arial",Font.BOLD,18));
        pinText.setBounds(300,535,400,30);
        add(pinText);
        
        next =  new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(600,580,100,26);
        next.setFont(new Font("Raleway",Font.BOLD,17));
        next.addActionListener(this);
        add(next);
} 
     @Override
      public void actionPerformed(ActionEvent ae){
        String formno = ""+  FormNo;
        String nameAE = nameText.getText(); // getText() method is used to get value from the text field
        String fatherAE = FatherNameText.getText();
        // Important
        String dobAE = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String genderAE = null;
        if (male.isSelected()){
            genderAE = "Male";
        }
        else if(female.isSelected()){
            genderAE = "Female";
        }
        String emailAE = emailText.getText();
        String maritalAE = null;
        if(married.isSelected()){
            maritalAE = "Married";
        }
        else if(unmarried.isSelected()){
            maritalAE = "Unmarried";
        }
        else if(other.isSelected()){
            maritalAE = "other";
        }  
        String addressAE = addressText.getText();
        String cityAE   = cityText.getText();
        String stateAE = (String) stateCh.getSelectedItem();

     //   String stateAE  =  stateText.getText();
        String pinAE    = pinText.getText();
        try{
            if(nameAE.isEmpty()){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else if(fatherAE.isEmpty()){
                JOptionPane.showMessageDialog(null, "Father name is required");
            }
            else if(dobAE.isEmpty()){
              JOptionPane.showMessageDialog(null, "gender is required");
          }
            else if(genderAE.isEmpty()){
              JOptionPane.showMessageDialog(null, "gender is required");
          }
            else if(emailAE.isEmpty()){
                JOptionPane.showMessageDialog(null, "Email address is required");
            }
            else if(maritalAE.isEmpty()){
                JOptionPane.showMessageDialog(null, "Email address is required");
            }
            else if(addressAE.isEmpty()){
                JOptionPane.showMessageDialog(null, "Address is required");
            }
            else if(cityAE.isEmpty()){
                JOptionPane.showMessageDialog(null, "City is required");
            }
            else if(stateAE.isEmpty()){
                JOptionPane.showMessageDialog(null, "State is required");
            }
            else if(pinAE.isEmpty()){
                JOptionPane.showMessageDialog(null, "Pin code is required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+ formno+"' , '"+nameAE+"','"+fatherAE+"' , '"+dobAE+"' , '"+genderAE+"' , '"+emailAE+"' , '"+maritalAE+"' , '"+addressAE+"' , '"+cityAE+"' , '"+pinAE+"' , '"+stateAE+"')";  
                c.s.executeUpdate(query); // execute this query
                setVisible(false);
                new SignUpSecond(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }  
    }
         
    public static void main(String args[]){
        new SignUpOne(); // creating SignUpOne class anonamous object
        
    }
}

