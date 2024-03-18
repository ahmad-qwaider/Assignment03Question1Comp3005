package Assignment03Question1Comp3005;

import java.sql.*;

public class StudentDatabaseApp {

    // Database connection parameters
    private static final String URL = "jdbc:postgresql://localhost:5432/University";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    // Establishes a connection to the PostgreSQL database using the provided URL, user, and password.
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Retrieves and displays all student records from the 'students' table.
    public static void getAllStudents() {
        String query = "SELECT * FROM students";

        // Attempt to connect to the database and execute the SELECT query
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Iterate through the result set and print each record
            while (rs.next()) {
                System.out.println(rs.getInt("student_id") + "\t" +
                        rs.getString("first_name") + "\t" +
                        rs.getString("last_name") + "\t" +
                        rs.getString("email") + "\t" +
                        rs.getDate("enrollment_date"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Adds a new student record to the 'students' table with the given details.
    public static void addStudent(String first_name, String last_name, String email, String enrollment_date) {

        // SQL statement with placeholders for inserting a new student record
        String SQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?);";

        // Attempt to connect to the database and prepare the INSERT statement
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            // Set the values for each placeholder based on the method parameters
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setDate(4, Date.valueOf(enrollment_date)); // Convert String to SQL Date

            // Execute the statement and check if a row was added
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("A new student was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Updates the email address for the student with the specified student_id.
    public static void updateStudentEmail(int student_id, String new_email) {
        String SQL = "UPDATE students SET email = ? WHERE student_id = ?;";

        // Attempt to connect to the database and prepare the UPDATE statement
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            // Set the new email and student_id in the prepared statement
            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);

            // Execute the statement and check if a row was affected
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Student email updated successfully!");
            } else {
                System.out.println("Student with ID " + student_id + " not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Deletes the record of the student with the specified student_id.
    public static void deleteStudent(int student_id) {
        String SQL = "DELETE FROM students WHERE student_id = ?;";

        // Attempt to connect to the database and prepare the DELETE statement
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            // Set the student_id in the prepared statement
            pstmt.setInt(1, student_id);

            // Execute the statement and check if a row was affected
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student with ID " + student_id + " not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Example operations to demonstrate functionality
        getAllStudents();

//        addStudent("ahmad", "kalaka", "ahmad@example.com", "2022-01-01");
//        getAllStudents();
//
//        updateStudentEmail(8, "new.jane.smith@example.com");
//        getAllStudents();
//
//        deleteStudent(8);
//        getAllStudents();
    }
}
