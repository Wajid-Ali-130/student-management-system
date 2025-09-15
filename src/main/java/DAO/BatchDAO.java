package DAO;

import Bean.BatchBean;
import DBConnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BatchDAO {
   

    // Add a new batch
    public boolean addBatch(BatchBean batch) {
        String sql = "INSERT INTO batch (program_id, batch_id, batch_year, shift, group_desc, remarks) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, batch.getProgramId());
            preparedStatement.setInt(2, batch.getBatchId());
            preparedStatement.setInt(3, batch.getBatchYear());
            preparedStatement.setString(4, batch.getShift());
            preparedStatement.setString(5, batch.getGroupDesc());
            preparedStatement.setString(6, batch.getRemarks());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding batch: " + e.getMessage());
            return false;
        }
    }

    // Update an existing batch
    public boolean updateBatch(BatchBean batch) {
        String sql = "UPDATE batch SET program_id=?, batch_year=?, shift=?, group_desc=?, remarks=? WHERE batch_id=?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, batch.getProgramId());
            preparedStatement.setInt(2, batch.getBatchYear());
            preparedStatement.setString(3, batch.getShift());
            preparedStatement.setString(4, batch.getGroupDesc());
            preparedStatement.setString(5, batch.getRemarks());
            preparedStatement.setInt(6, batch.getBatchId());
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating batch: " + e.getMessage());
            return false;
        }
    }

    // Delete a batch
    public boolean deleteBatch(int batchId) {
        String sql = "DELETE FROM batch WHERE batch_id=?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, batchId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting batch: " + e.getMessage());
            return false;
        }
    }

    // Get all batches
    public List<BatchBean> getAllBatches() {
        List<BatchBean> batches = new ArrayList<>();
        String sql = "SELECT * FROM batch";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                BatchBean batch = new BatchBean();
                batch.setProgramId(resultSet.getInt("program_id"));
                batch.setBatchId(resultSet.getInt("batch_id"));
                batch.setBatchYear(resultSet.getInt("batch_year"));
                batch.setShift(resultSet.getString("shift"));
                batch.setGroupDesc(resultSet.getString("group_desc"));
                batch.setRemarks(resultSet.getString("remarks"));
                
                batches.add(batch);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving batches: " + e.getMessage());
        }
        
        return batches;
    }

    // Get batch by ID
    public BatchBean getBatchById(int batchId) {
        BatchBean batch = null;
        String sql = "SELECT * FROM batch WHERE batch_id=?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, batchId);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    batch = new BatchBean();
                    batch.setProgramId(resultSet.getInt("program_id"));
                    batch.setBatchId(resultSet.getInt("batch_id"));
                    batch.setBatchYear(resultSet.getInt("batch_year"));
                    batch.setShift(resultSet.getString("shift"));
                    batch.setGroupDesc(resultSet.getString("group_desc"));
                    batch.setRemarks(resultSet.getString("remarks"));
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving batch: " + e.getMessage());
        }
        
        return batch;
    }

    // Get all program IDs for the combo box
    public List<Integer> getAllProgramIds() {
        List<Integer> programIds = new ArrayList<>();
        String sql = "SELECT program_id FROM program";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                programIds.add(resultSet.getInt("program_id"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving program IDs: " + e.getMessage());
        }
        
        return programIds;
    }
    
        // Get all programs with ID and name for the combo box
    public List<String> getAllPrograms() {
        List<String> programs = new ArrayList<>();
        String sql = "SELECT program_id, program_name FROM program";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("program_id");
                String name = resultSet.getString("program_name");
                programs.add(id + " - " + name); // Format: "ID - Name"
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving programs: " + e.getMessage());
        }

        return programs;
    }

    // Get program name by ID (optional, useful for display)
    public String getProgramNameById(int programId) {
        String programName = "";
        String sql = "SELECT program_name FROM program WHERE program_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, programId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    programName = resultSet.getString("program_name");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving program name: " + e.getMessage());
        }

        return programName;
    }

    // Database connection method
    private Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }

    // Remove closeResources() method since we're using try-with-resources
    // Resources are automatically closed by try-with-resources

   // In BatchDAO.java - replace the entire method with this:
    public boolean batchExists(int batchId) {
        String sql = "SELECT COUNT(*) FROM batch WHERE batch_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, batchId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // If count is greater than 0, the batch exists
                    return resultSet.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error checking batch existence: " + e.getMessage());
        }

        return false; // Return false if any error occurs or no batch found
    }
}