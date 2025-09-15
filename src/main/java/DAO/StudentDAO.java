package DAO;

import Bean.StudentBean;
import DBConnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StudentDAO {

    // Add a new student
    public boolean addStudent(StudentBean student) {
        String sql = "INSERT INTO student (batch_id, student_id, student_name, fathers_name, surname, roll_no, remarks) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, student.getBatchId());
            preparedStatement.setInt(2, student.getStudentId());
            preparedStatement.setString(3, student.getStudentName());
            preparedStatement.setString(4, student.getFathersName());
            preparedStatement.setString(5, student.getSurname());
            preparedStatement.setString(6, student.getRollNo());
            preparedStatement.setString(7, student.getRemarks());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding student: " + e.getMessage());
            return false;
        }
    }

    // Update an existing student
    public boolean updateStudent(StudentBean student) {
        String sql = "UPDATE student SET batch_id=?, student_name=?, fathers_name=?, surname=?, roll_no=?, remarks=? WHERE student_id=?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, student.getBatchId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getFathersName());
            preparedStatement.setString(4, student.getSurname());
            preparedStatement.setString(5, student.getRollNo());
            preparedStatement.setString(6, student.getRemarks());
            preparedStatement.setInt(7, student.getStudentId());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating student: " + e.getMessage());
            return false;
        }
    }

    // Delete a student
    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM student WHERE student_id=?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, studentId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting student: " + e.getMessage());
            return false;
        }
    }

    // Get all students
    public List<StudentBean> getAllStudents() {
        List<StudentBean> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                StudentBean student = new StudentBean();
                student.setBatchId(resultSet.getInt("batch_id"));
                student.setStudentId(resultSet.getInt("student_id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setFathersName(resultSet.getString("fathers_name"));
                student.setSurname(resultSet.getString("surname"));
                student.setRollNo(resultSet.getString("roll_no"));
                student.setRemarks(resultSet.getString("remarks"));
                
                students.add(student);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving students: " + e.getMessage());
        }
        
        return students;
    }

    // Get student by ID
    public StudentBean getStudentById(int studentId) {
        StudentBean student = null;
        String sql = "SELECT * FROM student WHERE student_id=?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, studentId);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new StudentBean();
                    student.setBatchId(resultSet.getInt("batch_id"));
                    student.setStudentId(resultSet.getInt("student_id"));
                    student.setStudentName(resultSet.getString("student_name"));
                    student.setFathersName(resultSet.getString("fathers_name"));
                    student.setSurname(resultSet.getString("surname"));
                    student.setRollNo(resultSet.getString("roll_no"));
                    student.setRemarks(resultSet.getString("remarks"));
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving student: " + e.getMessage());
        }
        
        return student;
    }

    // Get all batch IDs for the combo box
    public List<Integer> getAllBatchIds() {
        List<Integer> batchIds = new ArrayList<>();
        String sql = "SELECT batch_id FROM batch";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                batchIds.add(resultSet.getInt("batch_id"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving batch IDs: " + e.getMessage());
        }
        
        return batchIds;
    }

    // Get all student IDs for the combo box
    public List<Integer> getAllStudentIds() {
        List<Integer> studentIds = new ArrayList<>();
        String sql = "SELECT student_id FROM student";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                studentIds.add(resultSet.getInt("student_id"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving student IDs: " + e.getMessage());
        }
        
        return studentIds;
    }
    
    // In StudentDAO.java - add this method
    public boolean studentIdExists(int studentId) {
        String sql = "SELECT COUNT(*) FROM student WHERE student_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, studentId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error checking student ID: " + e.getMessage());
        }
        return false;
    }
    
    // In StudentDAO.java - Add this method to get student ID by details
    public int getStudentIdByDetails(int batchId, String studentName, String rollNo) {
        String sql = "SELECT student_id FROM student WHERE batch_id = ? AND student_name = ? AND roll_no = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, batchId);
            preparedStatement.setString(2, studentName);
            preparedStatement.setString(3, rollNo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("student_id");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error getting student ID: " + e.getMessage());
        }
        return -1;
    }

    // Database connection method
    private Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }
}