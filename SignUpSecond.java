package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUpSecond extends JFrame implements ActionListener {
    JComboBox religionCh, categoryCh, incomeCh,educationCh,occupationCh;
    JTextField panNumberText,aadharText;
    JRadioButton yesSeniorCitizen, noSeniorCitizen, yesExistingAccount,noExistingAccount; 
    JButton nextButton2;
    String formNo;

    SignUpSecond(String formNo){
        this.formNo = formNo;
        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(800,675);
        setLocation(200,1);
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        JLabel page2 = new JLabel("Page 2: Additional Details");
        page2.setFont(new Font("Raleway",Font.BOLD,18));
        page2.setBounds(300,10,250,30);
        add(page2);
        // Religion
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("iCON/iCON.jpg")); // to get image
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2); // converted to again in imageIcon as we can't pass a image obj in label
        JLabel label = new JLabel(i3);// cann't add anything directly in the frame , that why JLabel is used
        label.setBounds(20,5,100,100);
        add(label);
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,18));
        religion.setBounds(100,130,100,30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim","Sikh", "Christian", "Buddhist", "Jain","other"};
        religionCh = new JComboBox(valReligion);
        religionCh.setFont(new Font("Raleway",Font.BOLD,18));
        religionCh.setBounds(300,130,400,30);
        religionCh.setBackground(Color.white);
        add(religionCh);
        //Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,18));
        category.setBounds(100,175,100,30);
        add(category);
        
        String categoryArray[] = {"General", "OBC","NCL OBC","SC", "ST", "EWS (Economically Weaker Section)", "Other"};
        categoryCh = new JComboBox(categoryArray);
        categoryCh.setFont(new Font("Raleway",Font.BOLD,18));
        categoryCh.setBounds(300,175,400,30);
        categoryCh.setBackground(Color.white);
        add(categoryCh);
        
        //  Income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,18));
        income.setBounds(100,220,100,30);
        add(income);
        
        String incomeArray[] = {"Null", 
                                "< 1,50,000", 
                                "< 2,50,000", 
                                "< 5,00,000", 
                                "< 10,00,000", 
                                "< 15,00,000", 
                                "< 20,00,000", 
                                "< 30,00,000", 
                                "Above 30,00,000"};
        incomeCh = new JComboBox(incomeArray);
        incomeCh.setFont(new Font("Raleway",Font.BOLD,18));
        incomeCh.setBounds(300,220,400,30);
        incomeCh.setBackground(Color.white);
        add(incomeCh);
        
        // Educational Qualification
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,18));
        education.setBounds(100,265,150,30);
        add(education);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,18));
        qualification.setBounds(100,285,150,30);
        add(qualification);
        
        String educationArray[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctorate", 
                                   "Diploma", "Professional Degree", "High School", "Other"};
        educationCh = new JComboBox(educationArray);
        educationCh.setFont(new Font("Raleway",Font.BOLD,18));
        educationCh.setBounds(300,265,400,30);
        educationCh.setBackground(Color.white);
        add(educationCh);
        
        // Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,18));
        occupation.setBounds(100,320,150,30);
        add(occupation);
        
        String occupationArray[] = {"Salaried", "Self-Employed", "Business", "Student", 
                                "Retired", "Unemployed", "Freelancer", "Housewife", 
                                "Agriculture", "Government Employee", "Private Sector Employee", "Other"};
        occupationCh = new JComboBox(occupationArray);
        occupationCh.setFont(new Font("Raleway",Font.BOLD,18));
        occupationCh.setBounds(300,320,400,30);
        occupationCh.setBackground(Color.white);
        add(occupationCh);
        
        // PAN Number
        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Raleway",Font.BOLD,18));
        panNumber.setBounds(100,365,150,30);
        add(panNumber);
        // adding text field for Pan Number
        panNumberText = new JTextField();
        panNumberText.setFont(new Font("Raleway",Font.BOLD,18));
        panNumberText.setBounds(300,365,400,30);
        add(panNumberText);
        // Aadhar Number
        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,18));
        aadharNumber.setBounds(100,410,150,30);
        add(aadharNumber);
        // adding text field for Aadhar card
        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway",Font.BOLD,18));
        aadharText.setBounds(300,410,400,30);
        add(aadharText);
        // Senior Citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        seniorCitizen.setBounds(100,455,150,30);
        add(seniorCitizen);
        
        // set radio button for senior citizen
        yesSeniorCitizen = new JRadioButton("Yes");
        yesSeniorCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        yesSeniorCitizen.setBounds(300,455,100,30);
        yesSeniorCitizen.setBackground(Color.white);
        add(yesSeniorCitizen);
        
        noSeniorCitizen = new JRadioButton("No");
        noSeniorCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        noSeniorCitizen.setBounds(500,455,100,30);
        noSeniorCitizen.setBackground(Color.white);
        add(noSeniorCitizen);
        
        // Group Button
        ButtonGroup YNSeniorCitizen =  new ButtonGroup();
        YNSeniorCitizen.add(yesSeniorCitizen);
        YNSeniorCitizen.add(noSeniorCitizen);
        
        // Existing Account
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway",Font.BOLD,18));
        existingAccount.setBounds(100,500,200,30);
        add(existingAccount);
        
        // set radio button for Existing account
        yesExistingAccount = new JRadioButton("Yes");
        yesExistingAccount.setFont(new Font("Raleway",Font.BOLD,18));
        yesExistingAccount.setBounds(300,500,100,30);
        yesExistingAccount.setBackground(Color.white);
        add(yesExistingAccount);
        
        noExistingAccount = new JRadioButton("No");
        noExistingAccount.setFont(new Font("Raleway",Font.BOLD,18));
        noExistingAccount.setBounds(500,500,100,30);
        noExistingAccount.setBackground(Color.white);
        add(noExistingAccount);
        
        // Group Button
        ButtonGroup accountExistance =  new ButtonGroup();
        accountExistance.add(yesExistingAccount);
        accountExistance.add(noExistingAccount);
        
        nextButton2 = new JButton("Next");
        nextButton2.setBounds(600,545,100,30);
        nextButton2.setFont(new Font("Raleway",Font.BOLD,20));
        nextButton2.setBackground(Color.BLACK);
        nextButton2.setForeground(Color.white); // use to set the color of text written on button
        nextButton2.addActionListener(this);
        add(nextButton2);               
    }
    @Override
    public void actionPerformed(ActionEvent AE)
    {
        String sReligion = (String) religionCh.getSelectedItem();
        String sCategory =  (String) categoryCh.getSelectedItem();
        String sIncome = (String) incomeCh.getSelectedItem();
        String sEducation = (String) educationCh.getSelectedItem();
        String sOccupationCh = (String) occupationCh.getSelectedItem();
        String sPan =  panNumberText.getText();
        String sAadhar = aadharText.getText();
        String sSeniorCitizen = yesSeniorCitizen.isSelected() ? "Yes" : "No";
        String sExistingAccount = yesExistingAccount.isSelected() ? "Yes" : "No"; 
        try{
            Conn c = new Conn();
            String query = "insert into signupTwo values('"+ formNo+"' , '"+sReligion+"','"+sCategory+"' "
                    + ", '"+sIncome+"' , '"+sEducation+"' , '"+sOccupationCh+"' , '"+sPan+"' , '"+sAadhar+"' , '"+sSeniorCitizen+"' , '"+sExistingAccount+"')";  

            c.s.executeUpdate(query);
            // Create object of SignUpThird class
            setVisible(false);
            new SignUpThird(formNo).setVisible(true);          
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignUpSecond("");
    }
    
}
