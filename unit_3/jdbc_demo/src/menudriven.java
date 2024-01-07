import java.sql.*;
import java.util.Scanner;

public class menudriven {
    private static final String url = "jdbc:mysql://localhost:3306/student";
    private static final String user = "root";
    private static final String password = "root";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            int choice;
            do {
                System.out.println("Choose an option:");
                System.out.println("1. Create Table");
                System.out.println("2. Describe Table");
                System.out.println("3. Insert Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Update Data");
                System.out.println("6. Select Data");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    choice = -1;
                }

                switch (choice) {
                    case 1:
                        createTable(statement);
                        break;
                    case 2:
                        describeTable(statement);
                        break;
                    case 3:
                        insertData(statement);
                        break;
                    case 4:
                        deleteData(statement);
                        break;
                    case 5:
                        updateData(statement);
                        break;
                    case 6:
                        selectData(statement);
                        break;
                    case 7:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 7);

            statement.close();
            connection.close();
            scanner.close(); // Close the scanner when no longer needed
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Statement statement) {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();
        System.out.print("Enter columns with data types (e.g., id INT, name VARCHAR(255), age INT): ");
        String columns = scanner.nextLine();

        String createQuery = "CREATE TABLE " + tableName + " (" + columns + ")";
        executeUpdate(statement, createQuery, "Table created successfully.");
    }

    private static void describeTable(Statement statement) {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();
        String descQuery = "DESC " + tableName;
        executeQueryAndPrint(statement, descQuery, "Table structure:");
    }

    private static void insertData(Statement statement) {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();
        System.out.print("Enter values separated by commas (e.g., 'John Doe', 25): ");
        String values = scanner.nextLine();

        String insertQuery = "INSERT INTO " + tableName + " VALUES (" + values + ")";
        executeUpdate(statement, insertQuery, "Data inserted successfully.");
    }

    private static void deleteData(Statement statement) {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();
        System.out.print("Enter condition for deletion (e.g., id=1): ");
        String condition = scanner.nextLine();

        String deleteQuery = "DELETE FROM " + tableName + " WHERE " + condition;
        executeUpdate(statement, deleteQuery, "Data deleted successfully.");
    }

    private static void updateData(Statement statement) {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();
        System.out.print("Enter column to update: ");
        String columnName = scanner.nextLine();
        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();
        System.out.print("Enter condition (e.g., id=1): ");
        String condition = scanner.nextLine();

        if (!newValue.matches("\\d+")) {
            newValue = "'" + newValue + "'";
        }

        String updateQuery = "UPDATE " + tableName + " SET " + columnName + "=" + newValue + " WHERE " + condition;
        executeUpdate(statement, updateQuery, "Data updated successfully.");
    }

    private static void selectData(Statement statement) {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();

        String selectQuery = "SELECT * FROM " + tableName;
        executeQueryAndPrint(statement, selectQuery, "Query result:");
    }

    private static void executeUpdate(Statement statement, String query, String successMessage) {
        try {
            statement.executeUpdate(query);
            System.out.println(successMessage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQueryAndPrint(Statement statement, String query, String header) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println(header);

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + " | ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
