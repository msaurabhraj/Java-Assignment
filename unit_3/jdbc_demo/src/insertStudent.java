import java.sql.*;
import java.util.*;

public class insertStudent {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "root";

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Phone Number: ");
            String phone = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setString(4, address);
                int i = ps.executeUpdate();

                System.out.println("\n" + i + " record affected.");

                // Ask the user if they want to insert another record
                System.out.print("Do you want to insert another record? (Y/N): ");
                String continueInput = sc.nextLine();

                // If user enters anything other than 'Y' or 'y', exit the loop
                if (!continueInput.equalsIgnoreCase("Y")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);

        sc.close();
    }
}
