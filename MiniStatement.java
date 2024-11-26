package bank.management.system;
import javax.swing.*;
import java.awt.*; // color class is inside AWT 

public class MiniStatement extends JFrame{
    MiniStatement(){
        setSize(450,600);
        setLocation(10,10);
        getContentPane().setBackground(Color.white); // import AWT class
        setVisible(true);
        
        

}

    public static void main(String args[]){
        new MiniStatement();
}}
