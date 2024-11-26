
package bank.management.system;

import java.sql.*;
public class Conn {
    Connection c; // define variable globally
    Statement s;
    public Conn(){        

        // Steps for JDBC connectivity
        // Step 1 Register drivers
        // Step 2 Create Connection
        // Step 3 Create statement
        // step 4 Execute Query
        // step 5 Close Connection
        try{
            // Step 1: Register driver (optional in newer versions)
            // Class.forName("com.mysql.cj.jdbc.Driver"); // Uncomment if needed
            // step 1deiver name com.mysql.cj.jdbc.Driver
            // don't need to write above lib after adding mysql-connector in libraray
           // step 2 create connection
           c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Siot@129abde");
           s = c.createStatement();
           
        }
        catch(Exception e){
        System.out.println(e);
    }
    }
    
}
