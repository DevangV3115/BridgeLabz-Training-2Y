package com.tech.jdbc_project;

import java.sql.*;

public class StudentService {

   String[] ids = new String[100];
    String[] names = new String[100];
    String[] courses = new String[100];
    int count = 0;

    public void loadStudents() {
        count = 0;
        try {
            Connection conn = DBUtil.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                ids[count] = rs.getString(1);
                names[count] = rs.getString(2);
                courses[count] = rs.getString(3);
                count++;
            }
        } catch (Exception e) { }
    }

    public boolean addStudent(String id, String name, String course) {
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.executeUpdate();

            loadStudents(); 
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void viewStudents() {
        loadStudents();
        if (count == 0) {
            System.out.println("No students found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(ids[i] + " | " + names[i] + " | " + courses[i]);
        }
    }

    public boolean updateStudent(String id, String newName, String newCourse) {
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE students SET name=?, course=? WHERE id=?"
            );
            ps.setString(1, newName);
            ps.setString(2, newCourse);
            ps.setString(3, id);
            ps.executeUpdate();
            loadStudents();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteStudent(String id) {
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM students WHERE id=?"
            );
            ps.setString(1, id);
            ps.executeUpdate();
            loadStudents();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
