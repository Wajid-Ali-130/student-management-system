package DAO;

import Bean.FacultyBean;
import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Data Access Object (DAO) for the Faculty entity.
 * This class handles all CRUD (Create, Read, Update, Delete) operations
 * for faculty data in the database.
 */
public class FacultyDAO {

   
    public int addFaculty(FacultyBean bean) throws SQLException {
        String sql = "INSERT INTO faculty (fac_id, fac_name, remarks) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, bean.getFacultyId());
            pstmt.setString(2, bean.getFacultyName());
            pstmt.setString(3, bean.getRemarks());

            return pstmt.executeUpdate();
        }
    }

    /**
     * Updates an existing faculty record in the database.
     *
     */
    public int updateFaculty(FacultyBean bean) throws SQLException {
        String sql = "UPDATE faculty SET fac_name = ?, remarks = ? WHERE fac_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, bean.getFacultyName());
            pstmt.setString(2, bean.getRemarks());
            pstmt.setInt(3, bean.getFacultyId());

            return pstmt.executeUpdate();
        }
    }

    /**
     * Deletes a faculty record from the database based on its ID.
     */
    public int deleteFaculty(int facultyId) throws SQLException {
        String sql = "DELETE FROM faculty WHERE fac_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, facultyId);

            return pstmt.executeUpdate();
        }
    }


    public static Vector<FacultyBean> getAllFaculty() throws SQLException {
        String sql = "SELECT fac_id, fac_name, remarks FROM faculty";
        Vector<FacultyBean> facultyList = new Vector<>();

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("fac_id");
                String name = rs.getString("fac_name");
                String remarks = rs.getString("remarks");
                
                facultyList.add(new FacultyBean(id, name, remarks));
            }
        }
        return facultyList;
    }
}