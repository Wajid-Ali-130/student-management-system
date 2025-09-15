
package Frames;

import Bean.BatchBean;
import DAO.BatchDAO;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class Batch extends javax.swing.JFrame {

    
   private BatchDAO batchDAO;
    private DefaultListModel<String> listModel;
    
   public Batch() {
    initComponents();
    batchDAO = new BatchDAO();
    listModel = new DefaultListModel<>();
    batchlist.setModel(listModel);
    loadPrograms(); // Changed from loadProgramIds()
    loadAllBatches();
}

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        batchidTF = new javax.swing.JTextField();
        batchYearTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTA = new javax.swing.JTextArea();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        batchlist = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        programidComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        groupDescTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Shift");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 210, 110, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Batch List");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 50, 120, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Remarks");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 290, 100, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("Batch");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 40, 130, 40);

        batchidTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchidTFActionPerformed(evt);
            }
        });
        getContentPane().add(batchidTF);
        batchidTF.setBounds(190, 130, 170, 30);

        batchYearTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchYearTFActionPerformed(evt);
            }
        });
        getContentPane().add(batchYearTF);
        batchYearTF.setBounds(190, 170, 170, 30);

        remarksTA.setColumns(20);
        remarksTA.setRows(5);
        jScrollPane1.setViewportView(remarksTA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 290, 170, 80);

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 0, 0));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(170, 390, 72, 50);

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(260, 390, 72, 50);

        clearButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 0, 0));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(350, 390, 72, 50);

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 0, 0));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(440, 390, 72, 50);

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 0, 0));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(80, 390, 72, 50);

        batchlist.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                batchlistValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(batchlist);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(370, 90, 140, 280);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Batch Year");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 170, 100, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Batch_id");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 130, 100, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Evening" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(190, 210, 170, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Program_id");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 90, 100, 30);

        getContentPane().add(programidComboBox);
        programidComboBox.setBounds(190, 90, 170, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Group_desc");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 250, 110, 30);

        groupDescTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupDescTFActionPerformed(evt);
            }
        });
        getContentPane().add(groupDescTF);
        groupDescTF.setBounds(190, 250, 170, 30);

        setSize(new java.awt.Dimension(598, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void batchidTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchidTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchidTFActionPerformed

    private void batchYearTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchYearTFActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        try {
            
            String programInfo = programidComboBox.getSelectedItem().toString();
            int programId = Integer.parseInt(programInfo.split(" - ")[0]);
            // Get values from form
//            int programId = Integer.parseInt(programidComboBox.getSelectedItem().toString());
            int batchId = Integer.parseInt(batchidTF.getText());
            int batchYear = Integer.parseInt(batchYearTF.getText());
            String shift = jComboBox1.getSelectedItem().toString();
            String groupDesc = groupDescTF.getText();
            String remarks = remarksTA.getText();

            // Create BatchBean object
            BatchBean batch = new BatchBean(programId, batchId, batchYear, shift, groupDesc, remarks);

            // Update batch
            if (batchDAO.updateBatch(batch)) {
                JOptionPane.showMessageDialog(this, "Batch updated successfully!");
                loadAllBatches();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update batch!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Batch ID and Year!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        try {
            int batchId = Integer.parseInt(batchidTF.getText());
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete batch ID: " + batchId + "?", 
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (batchDAO.deleteBatch(batchId)) {
                    JOptionPane.showMessageDialog(this, "Batch deleted successfully!");
                    loadAllBatches();
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete batch!");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Batch ID!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        MainFrame ob=new MainFrame();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
         try {
            // Get program ID from the formatted string "ID - Name"
           String programInfo = programidComboBox.getSelectedItem().toString();
           int programId = Integer.parseInt(programInfo.split(" - ")[0]); // Extract ID part

           int batchId = Integer.parseInt(batchidTF.getText());
           int batchYear = Integer.parseInt(batchYearTF.getText());
           String shift = jComboBox1.getSelectedItem().toString();
           String groupDesc = groupDescTF.getText();
           String remarks = remarksTA.getText();

            // Create BatchBean object
            BatchBean batch = new BatchBean(programId, batchId, batchYear, shift, groupDesc, remarks);

            // Add batch
            if (batchDAO.addBatch(batch)) {
                JOptionPane.showMessageDialog(this, "Batch added successfully!");
                loadAllBatches();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add batch!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Batch ID and Year!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void batchlistValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_batchlistValueChanged
        // TODO add your handling code here:
         if (!evt.getValueIsAdjusting()) {
            String selectedValue = (String) batchlist.getSelectedValue();
            if (selectedValue != null) {
                // Extract batch ID from the new format "Batch: XX - Year: YYYY"
                String[] parts = selectedValue.split(" - ");
                if (parts.length >= 1) {
                    String batchIdStr = parts[0].replace("Batch: ", "").trim();
                    try {
                        int batchId = Integer.parseInt(batchIdStr);
                        loadBatchDetails(batchId);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid batch ID format!");
                    }
                }
            }
        }
    }//GEN-LAST:event_batchlistValueChanged

    private void groupDescTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupDescTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupDescTFActionPerformed
    
    
    private void loadPrograms() {
       List<String> programs = batchDAO.getAllPrograms();
       programidComboBox.removeAllItems();
       for (String program : programs) {
           programidComboBox.addItem(program);
       }
    }

    private void loadAllBatches() {
        listModel.clear();
        List<BatchBean> batches = batchDAO.getAllBatches();
        for (BatchBean batch : batches) {
            // Show only batch_id and batch_year
            listModel.addElement("Batch: " + batch.getBatchId() + " - Year: " + batch.getBatchYear());
        }
    }
    
    private void loadBatchDetails(int batchId) {
        BatchBean batch = batchDAO.getBatchById(batchId);
        if (batch != null) {
            // Find and select the correct program in combo box
            String programName = batchDAO.getProgramNameById(batch.getProgramId());
            String programToSelect = batch.getProgramId() + " - " + programName;

            programidComboBox.setSelectedItem(programToSelect);
            batchidTF.setText(String.valueOf(batch.getBatchId()));
            batchYearTF.setText(String.valueOf(batch.getBatchYear()));
            jComboBox1.setSelectedItem(batch.getShift());
            groupDescTF.setText(batch.getGroupDesc());
            remarksTA.setText(batch.getRemarks());
        }
    }
    
    private void clearForm() {
        if (programidComboBox.getItemCount() > 0) {
            programidComboBox.setSelectedIndex(0);
        }
        batchidTF.setText("");
        batchYearTF.setText("");
        jComboBox1.setSelectedIndex(0);
        groupDescTF.setText("");
        remarksTA.setText("");
        batchlist.clearSelection();
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField batchYearTF;
    private javax.swing.JTextField batchidTF;
    private javax.swing.JList batchlist;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField groupDescTF;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> programidComboBox;
    private javax.swing.JTextArea remarksTA;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
