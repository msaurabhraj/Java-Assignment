import java.sql.*;

public class deleteconn {
   public static void main(String[] args) {
        String user = "root";
        String password = "root";
        final String url = "jdbc:mysql://localhost:3306/test";

        Connection c = null;
        Statement s = null;

        try {
            c = DriverManager.getConnection(url, user, password);
            String q = "DELETE FROM test1 WHERE id = 102";
            s = c.createStatement();
            s.executeUpdate(q);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }   
}
