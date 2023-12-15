import java.sql.*;
import java.util.*;

public class showconn {
    public static void main(String[] args) {
        String user = "root";
        String password = "root";
        final String url = "jdbc:mysql://localhost:3306/test";
        try {
            Connection c = DriverManager.getConnection(url, user, password);
            String q = "SELECT * FROM test1 order by id desc";
            Statement st = c.createStatement();
            ResultSet res = st.executeQuery(q);
            System.out.println("\n\nALL Records: \n");
               while (res.next()) {
                System.out.println(res.getInt(1) + "|" + res.getString(2));
                
               }
            //    res.last();
            //    do {
            //        System.out.println(res.getInt(1) + "|" + res.getString(2));
            //    } while (res.previous());
               
            
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }
    

}

        