import java.sql.*;
import java.util.*;

public class insertconn {
    public static void main(String[] args) {
        String user = "root";
        String password = "root";
        final String url = "jdbc:mysql://localhost:3306/test";
        
    try {
        Connection c = DriverManager.getConnection(url, user, password);
        String q = "Insert into test1 VALUES(?,?)";
        PreparedStatement ps = c.prepareStatement(q);
        ps.setInt(1, 101);
        ps.setString(2, "Saurabh");
        ps.executeUpdate();

        ps.setInt(1, 102);
        ps.setString(2, "Prashant");
        ps.executeUpdate();

        ps.setInt(1, 103);
        ps.setString(2, "Pranav");
        ps.executeUpdate();

        ps.setInt(1, 104);
        ps.setString(2, "Abhishek");

       int i =  ps.executeUpdate();
        System.out.println("\n" + i  + " record affected");




    } catch (SQLException e) {
        e.printStackTrace();
        
    }

    }
    
}
