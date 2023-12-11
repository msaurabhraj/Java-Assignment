import java.sql.*;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "root";
        String sql = "SELECT * FROM STUDENT";

        try {
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                System.out.println("\n\nALL Records: \n");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " | " 
                        + rs.getString(2) + "|" + rs.getString(3)+ "|"  + rs.getString(4));
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}