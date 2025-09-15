package DAO;

import Bean.DepartmentBean;
import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DepartmentDAO {

    public int addDepartment(DepartmentBean department) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try {
            con = DBConnection.getConnection();
            String query = "INSERT INTO departments (fac_id, dep_id, dep_name, remarks) VALUES (?, ?, ?, ?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, department.getFacId());
            preparedStatement.setInt(2, department.getDepId());
            preparedStatement.setString(3, department.getDepName());
            preparedStatement.setString(4, department.getRemarks());

            return preparedStatement.executeUpdate();
        } finally {
            // Close resources
            if (preparedStatement != null) preparedStatement.close();
            if (con != null) con.close();
        }
    }

    public int updateDepartment(DepartmentBean department) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try {
            con = DBConnection.getConnection();
            String query = "UPDATE departments SET fac_id = ?, dep_name = ?, remarks = ? WHERE dep_id = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, department.getFacId());
            preparedStatement.setString(2, department.getDepName());
            preparedStatement.setString(3, department.getRemarks());
            preparedStatement.setInt(4, department.getDepId());

            return preparedStatement.executeUpdate();
        } finally {
            // Close resources
            if (preparedStatement != null) preparedStatement.close();
            if (con != null) con.close();
        }
    }

    public int deleteDepartment(int departmentId) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try {
            con = DBConnection.getConnection();
            String query = "DELETE FROM departments WHERE dep_id = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, departmentId);

            return preparedStatement.executeUpdate();
        } finally {
            // Close resources
            if (preparedStatement != null) preparedStatement.close();
            if (con != null) con.close();
        }
    }
    
    public static Vector<DepartmentBean> getAllDepartments() throws SQLException {
        Vector<DepartmentBean> depList = new Vector<>();
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.getConnection();
            String query = "SELECT * FROM departments";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                DepartmentBean bean = new DepartmentBean();
                bean.setDepId(resultSet.getInt("dep_id"));
                bean.setFacId(resultSet.getInt("fac_id"));
                bean.setDepName(resultSet.getString("dep_name"));
                bean.setRemarks(resultSet.getString("remarks"));
                depList.add(bean);
            }
        } finally {
            // Close resources
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (con != null) con.close();
        }
        return depList;
    }
    
    public DepartmentBean getDepartmentById(int departmentId) throws SQLException {
        DepartmentBean bean = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.getConnection();
            String query = "SELECT * FROM departments WHERE dep_id = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, departmentId);
            
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bean = new DepartmentBean();
                bean.setDepId(resultSet.getInt("dep_id"));
                bean.setFacId(resultSet.getInt("fac_id"));
                bean.setDepName(resultSet.getString("dep_name"));
                bean.setRemarks(resultSet.getString("remarks"));
            }
        } finally {
            // Close resources
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (con != null) con.close();
        }
        return bean;
    }
}