Assignment 03 Question 1
Name: Ahmad Qwaider
StudentID: 101282073

Instructions:

- Database Setup:

Create a PostgreSQL database named University.
Execute the following SQL to create a students table:

CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    enrollment_date DATE
);


- Application Configuration:

Open StudentDatabaseApp.java (inside assignment03Question1comp3005 package).
Update the following lines with your PostgreSQL details:
private static final String URL = "jdbc:postgresql://localhost:5432/University";
private static final String USER = "postgres";
private static final String PASSWORD = "1234"; // Replace "1234" with your actual password


Compile the Application:

Navigate to the source directory and compile:
javac StudentDatabaseApp.java
Run the Application:
java StudentDatabaseApp


Youtube link: https://youtu.be/5llulxNox8E
