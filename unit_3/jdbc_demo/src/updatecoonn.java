import java.sql.*;

public class updatecoonn {
    public static void main(String[] args) {
        String user = "root";
        String password = "root";
        final String url = "jdbc:mysql://localhost:3306/test";

        Connection c = null;
        Statement s = null;

        try {
            c = DriverManager.getConnection(url, user, password);
            String q = "UPDATE test1 SET name = 'Raj' WHERE id = 101";
            s = c.createStatement();
            s.executeUpdate(q);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
