import java.sql.*;

public class conn {
    public static void main(String[] args) {
        String user = "root";
        String password = "root";
        final String url = "jdbc:mysql://localhost:3306/test";
    
    try{
        Connection c = DriverManager.getConnection(url, user, password);

        if(c!=null){
            System.out.println("success");
            String q ="create table  test1(id int, name varchar(20))";
            Statement s = c.createStatement();
            s.execute(q);
        }
        else
            System.out.println("Fail");

    }
    catch(SQLException e){
        e.printStackTrace();

    }
    
} }
