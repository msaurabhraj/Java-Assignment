import java.sql.*;
import java.util.Scanner;

public class App {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Studentss";
    static final String USER = "root";
    static final String PASS = "root";

    static Connection connection;
    static Statement statement;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            createTable();

            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\n1. Add Student Records");
                System.out.println("2. Calculate CGPA and Grade");
                System.out.println("3. List MCA students with 8 CGPA and specified percentages");
                System.out.println("4. Display Student with Highest Scores");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudentRecords();
                        break;
                    case 2:
                        calculateCGPAandGrade();
                        break;
                    case 3:
                        listStudentsWithCriteria();
                        break;
                    case 4:
                        displayStudentWithHighestScores();
                        break;
                }
            } while (choice != 5);


            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable() {
        try {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS student (" +
                    "SRN VARCHAR(10) PRIMARY KEY," +
                    "Name VARCHAR(50)," +
                    "Semester INT," +
                    "Program VARCHAR(20)," +
                    "Course1 INT," +
                    "Course2 INT," +
                    "Course3 INT," +
                    "Course4 INT," +
                    "Course5 INT," +
                    "Course6 INT," +
                    "CGPA DECIMAL(4, 2)," +
                    "Grade CHAR(1)" +
                    ")";
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addStudentRecords() {
        try {
            // Inserting 10 sample records directly
            String[] srns = {"SRN1", "SRN2", "SRN3", "SRN4", "SRN5", "SRN6", "SRN7", "SRN8", "SRN9", "SRN10"};
            String[] names = {"Saurabh", "Prashant", "Pranav", "Abhishek", "Shruti", "Anusha", "Jigyah", "Suraj", "Vibhav", "Harry"};
            int[] semesters = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
            String[] programs = {"MCA", "MCA", "MCA", "MCA", "MCA", "MCA", "MCA", "MCA", "MCA", "MCA"};
            int[] course1 = {90, 85, 95, 90, 88, 92, 82, 87, 95, 89};
            int[] course2 = {95, 88, 97, 92, 90, 94, 80, 92, 97, 91};
            int[] course3 = {98, 80, 90, 88, 45, 50, 35, 50, 2, 27};
            int[] course4 = {92, 90, 95, 94, 88, 96, 89, 93, 98, 94};
            int[] course5 = {90, 99, 98, 40, 67, 24, 56, 89, 26, 13};
            int[] course6 = {97, 89, 97, 89, 16, 13, 29, 52, 24, 10};

            for (int i = 0; i < 10; i++) {
                String insertSQL = "INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, NULL)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                    preparedStatement.setString(1, srns[i]);
                    preparedStatement.setString(2, names[i]);
                    preparedStatement.setInt(3, semesters[i]);
                    preparedStatement.setString(4, programs[i]);
                    preparedStatement.setInt(5, course1[i]);
                    preparedStatement.setInt(6, course2[i]);
                    preparedStatement.setInt(7, course3[i]);
                    preparedStatement.setInt(8, course4[i]);
                    preparedStatement.setInt(9, course5[i]);
                    preparedStatement.setInt(10, course6[i]);

                    int affectedRows = preparedStatement.executeUpdate();
                    if (affectedRows > 0) {
                        System.out.println("Student record added successfully.");
                    } else {
                        System.out.println("Error adding student record.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void calculateCGPAandGrade() {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            while (resultSet.next()) {
                String srn = resultSet.getString("SRN");
                int course1 = resultSet.getInt("Course1");
                int course2 = resultSet.getInt("Course2");
                int course3 = resultSet.getInt("Course3");
                int course4 = resultSet.getInt("Course4");
                int course5 = resultSet.getInt("Course5");
                int course6 = resultSet.getInt("Course6");

                double percentage = ((course1 + course2 + course3 + course4 + course5 + course6) / 600.0) * 100;
                double cgpa = (percentage / 10.0) ; 

                String grade;
                if (cgpa >= 9.0) {
                    grade = "A";
                } else if (cgpa >= 8.0) {
                    grade = "B";
                } else {
                    grade = "C";
                }

                // Update the table with CGPA and Grade
                String updateSQL = "UPDATE student SET CGPA = ?, Grade = ? WHERE SRN = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateSQL)) {
                    updateStatement.setDouble(1, cgpa);
                    updateStatement.setString(2, grade);
                    updateStatement.setString(3, srn);

                    int updatedRows = updateStatement.executeUpdate();
                    if (updatedRows > 0) {
                        System.out.println("CGPA and Grade updated for SRN: " + srn);
                    } else {
                        System.out.println("Error updating CGPA and Grade for SRN: " + srn);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void listStudentsWithCriteria() {
        try {
            // Fetch MCA students with 8 CGPA and specified percentages
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE Program = 'MCA' AND CGPA >= 8.0");
            System.out.println("SRN: " + " | " + "Name" + " | " + "CGPA");
            while (resultSet.next()) {
                // Retrieve and display student details
                System.out.println(resultSet.getString("SRN") +" | " + resultSet.getString("Name") + " | " + resultSet.getDouble("CGPA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayStudentWithHighestScores() {
        try {
            // Fetch student with the highest scores in all six courses
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student " +
                    "ORDER BY Course1 + Course2 + Course3 + Course4 + Course5 + Course6 DESC LIMIT 1");

            if (resultSet.next()) {
                System.out.println("SRN: " + resultSet.getString("SRN"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Semester: " + resultSet.getInt("Semester"));
                System.out.println("Program: " + resultSet.getString("Program"));
                System.out.println("CGPA: " + resultSet.getDouble("CGPA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
