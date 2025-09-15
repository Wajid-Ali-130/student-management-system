package DAO;

import Bean.ProgramBean;
import DBConnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ProgramDAO {
    
    private Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }

    // Load departments into combo box from database
    public DefaultComboBoxModel<String> loadDepartments() {
        DefaultComboBoxModel<String> deptModel = new DefaultComboBoxModel<>();
        String sql = "SELECT dep_name FROM departments ORDER BY dep_name";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                deptModel.addElement(rs.getString("dep_name"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading departments: " + e.getMessage());
            
            // Fallback default departments
            deptModel.addElement("Computer Science");
            deptModel.addElement("Mathematics");
            deptModel.addElement("Physics");
            deptModel.addElement("Engineering");
            deptModel.addElement("Business");
        }
        
        return deptModel;
    }

    // Get department ID from department name
    private int getDepartmentId(String departmentName) throws SQLException {
        String sql = "SELECT dep_id FROM departments WHERE dep_name = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, departmentName);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("dep_id");
            } else {
                throw new SQLException("Department not found: " + departmentName);
            }
        }
    }

    public boolean addProgram(ProgramBean program) {
        String sql = "INSERT INTO program (program_id, program_name, semester_duration, remarks, dep_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            // Handle both numeric and string program IDs
            try {
                ps.setInt(1, Integer.parseInt(program.getProgId()));
            } catch (NumberFormatException e) {
                ps.setString(1, program.getProgId()); // Use string if not numeric
            }
            ps.setString(2, program.getProgName());
            ps.setInt(3, program.getDurationInSem());
            ps.setString(4, program.getRemarks());
            ps.setInt(5, getDepartmentId(program.getDepartmentid()));

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding program: " + e.getMessage());
            return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid program ID format");
            return false;
        }
    }


    public List<ProgramBean> getAllPrograms() {
    List<ProgramBean> list = new ArrayList<>();
    
    try {
        Connection con = getConnection();
        System.out.println("Database connection established: " + (con != null));
        
        String sql = "SELECT p.*, d.dep_name FROM program p " +
                    "LEFT JOIN departments d ON p.dep_id = d.dep_id " +
                    "ORDER BY p.program_name";
        
        System.out.println("Executing SQL: " + sql);
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        
        System.out.println("=== ResultSet Columns ===");
        for (int i = 1; i <= columnCount; i++) {
            System.out.println("Column " + i + ": " + metaData.getColumnName(i));
        }
        
        int count = 0;
        while (rs.next()) {
            count++;
            ProgramBean program = new ProgramBean();
            
            // Use getString for program_id to handle both numbers and text
            program.setProgId(rs.getString("program_id"));
            program.setProgName(rs.getString("program_name"));
            program.setDurationInSem(rs.getInt("semester_duration"));
            program.setRemarks(rs.getString("remarks"));
            program.setDepartmentid(rs.getString("dep_name"));
            
            System.out.println("Program " + count + ": " + program.getProgName() + " (ID: " + program.getProgId() + ")");
            list.add(program);
        }
        
        System.out.println("Total programs found: " + count);
        rs.close();
        st.close();
        con.close();
        
    } catch (SQLException e) {
        System.out.println("SQL Error: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("Error Code: " + e.getErrorCode());
        e.printStackTrace();
    }
    
    return list;
}
    
     // UPDATE - Update existing program
    public boolean updateProgram(ProgramBean program) {
        String sql = "UPDATE program SET program_name = ?, semester_duration = ?, remarks = ?, dep_id = ? WHERE program_id = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, program.getProgName());
            ps.setInt(2, program.getDurationInSem());
            ps.setString(3, program.getRemarks());
            ps.setInt(4, getDepartmentId(program.getDepartmentid()));
            ps.setInt(5, Integer.parseInt(program.getProgId()));

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating program: " + e.getMessage());
            return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid program ID format");
            return false;
        }
    }

    // DELETE - Delete program by ID
    public boolean deleteProgram(String progId) {
        String sql = "DELETE FROM program WHERE program_id = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, Integer.parseInt(progId));
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting program: " + e.getMessage());
            return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid program ID format");
            return false;
        }
    }

    // Check if program ID already exists
    public boolean programExists(String progId) {
        String sql = "SELECT COUNT(*) FROM program WHERE program_id = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, Integer.parseInt(progId));
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid program ID format");
        }
        return false;
    }

    // Search programs by name
    public List<ProgramBean> searchProgramsByName(String searchTerm) {
        List<ProgramBean> list = new ArrayList<>();
        String sql = "SELECT p.*, d.dep_name FROM program p " +
                    "LEFT JOIN departments d ON p.dep_id = d.dep_id " +
                    "WHERE p.program_name LIKE ? " +
                    "ORDER BY p.program_name";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, "%" + searchTerm + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProgramBean program = new ProgramBean();
                program.setProgId(String.valueOf(rs.getInt("program_id")));
                program.setProgName(rs.getString("program_name"));
                program.setDurationInSem(rs.getInt("semester_duration"));
                program.setRemarks(rs.getString("remarks"));
                program.setDepartmentid(rs.getString("dep_id"));
                list.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error searching programs: " + e.getMessage());
        }
        return list;
    }

    // Get programs by department
    public List<ProgramBean> getProgramsByDepartment(String departmentName) {
     List<ProgramBean> list = new ArrayList<>();
     String sql = "SELECT p.*, d.dep_name FROM program p LEFT JOIN departments d ON p.dep_id = d.dep_id WHERE d.dep_name = ? ORDER BY p.program_name";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, departmentName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProgramBean program = new ProgramBean();
                program.setProgId(String.valueOf(rs.getInt("program_id")));
                program.setProgName(rs.getString("program_name"));
                program.setDurationInSem(rs.getInt("semester_duration"));
                program.setRemarks(rs.getString("remarks"));
                program.setDepartmentid(rs.getString("dep_name")); // ← This should be the actual dep_name
                list.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error getting programs by department: " + e.getMessage());
        }
     return list;
    }
    
    public ProgramBean getProgramById(String progId) {
        String sql = "SELECT p.*, d.dep_name FROM program p " +
                    "LEFT JOIN departments d ON p.dep_id = d.dep_id " +
                    "WHERE p.program_id = ?";
            try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(progId));
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    ProgramBean program = new ProgramBean();
                    program.setProgId(rs.getString("program_id"));
                    program.setProgName(rs.getString("program_name"));
                    program.setDurationInSem(rs.getInt("semester_duration"));
                    program.setRemarks(rs.getString("remarks"));
                    program.setDepartmentid(rs.getString("dep_name"));
                    return program;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    return null;
    }

}

