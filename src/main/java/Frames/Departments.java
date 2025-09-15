
package Frames;

import Bean.DepartmentBean;
import DAO.DepartmentDAO;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;


public class Departments extends javax.swing.JFrame {

    
    public Departments() {
        initComponents();
        populateDepList(); // Load departments when frame opens
    }
    
     private void populateDepList() {
        try {
            Vector<DepartmentBean> departmentVector = DepartmentDAO.getAllDepartments();
            depList.setListData(departmentVector);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading department list: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }   
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        depNameTF = new javax.swing.JTextField();
        facidTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTA = new javax.swing.JTextArea();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        depList = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        depidTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Fac name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 180, 70, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Dep List");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 50, 120, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Remarks");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 220, 60, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("Department");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 40, 140, 30);

        depNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depNameTFActionPerformed(evt);
            }
        });
        getContentPane().add(depNameTF);
        depNameTF.setBounds(150, 180, 210, 30);

        facidTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facidTFActionPerformed(evt);
            }
        });
        getContentPane().add(facidTF);
        facidTF.setBounds(150, 100, 210, 30);

        remarksTA.setColumns(20);
        remarksTA.setRows(5);
        jScrollPane1.setViewportView(remarksTA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 220, 210, 90);

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 0, 0));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(180, 340, 72, 50);

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(270, 340, 72, 50);

        clearButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 0, 0));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(360, 340, 72, 50);

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 0, 0));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(450, 340, 72, 50);

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 0, 0));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(90, 340, 72, 50);

        depList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                depListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(depList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(370, 90, 140, 220);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Dep id");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 140, 60, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Fac id");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 100, 60, 30);

        depidTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depidTFActionPerformed(evt);
            }
        });
        getContentPane().add(depidTF);
        depidTF.setBounds(150, 140, 210, 30);

        setSize(new java.awt.Dimension(598, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
         DepartmentBean selectedBean = (DepartmentBean) depList.getSelectedValue();
        
        if (selectedBean == null) {
            JOptionPane.showMessageDialog(this, "Please select a department from the list to update.", 
                    "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Validation
        String facIdStr = facidTF.getText().trim();
        String depIdStr = depidTF.getText().trim();
        String depName = depNameTF.getText().trim();
        
        if (facIdStr.isEmpty() || depIdStr.isEmpty() || depName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Faculty ID, Department ID and Name cannot be empty.", 
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int facId = Integer.parseInt(facIdStr);
            int depId = Integer.parseInt(depIdStr);
            
            // Create updated department bean
            DepartmentBean updatedDept = new DepartmentBean();
            updatedDept.setFacId(facId);
            updatedDept.setDepId(depId);
            updatedDept.setDepName(depName);
            updatedDept.setRemarks(remarksTA.getText().trim());
            
            DepartmentDAO departmentDAO = new DepartmentDAO();
            
            if (departmentDAO.updateDepartment(updatedDept) > 0) {
                JOptionPane.showMessageDialog(this, "Department Updated Successfully!");
                populateDepList(); // Refresh the list
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update department.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format. Please enter numbers for IDs.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error during update: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
      
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        DepartmentBean selectedBean = (DepartmentBean) depList.getSelectedValue();
       
        if (selectedBean == null) {
            JOptionPane.showMessageDialog(this, "Please select a department from the list to delete.", 
                    "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
         
        int choice = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete '" + selectedBean.getDepName() + "'?", 
                "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if(choice == JOptionPane.YES_OPTION){
            try {
                DepartmentDAO departmentDAO = new DepartmentDAO();
                if(departmentDAO.deleteDepartment(selectedBean.getDepId()) > 0){
                    JOptionPane.showMessageDialog(this, "Department Deleted Successfully!");
                    populateDepList();
                    clearButtonActionPerformed(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete department.", 
                            "Deletion Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database Error during deletion: " + e.getMessage(), 
                        "Database Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        facidTF.setText("");
        depidTF.setText("");
        depNameTF.setText("");
        remarksTA.setText("");
        depList.clearSelection();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        MainFrame ob=new MainFrame();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
       // Validation
        String facIdStr = facidTF.getText().trim();
        String depIdStr = depidTF.getText().trim();
        String depName = depNameTF.getText().trim();
        String remarks = remarksTA.getText().trim();
         
        if (facIdStr.isEmpty() || depIdStr.isEmpty() || depName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Faculty ID, Department ID and Name cannot be empty.", 
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int facId = Integer.parseInt(facIdStr);
            int depId = Integer.parseInt(depIdStr);
            
            DepartmentBean dept = new DepartmentBean();
            dept.setFacId(facId);
            dept.setDepId(depId);
            dept.setDepName(depName);
            dept.setRemarks(remarks);
            
            DepartmentDAO departmentDAO = new DepartmentDAO();

            if (departmentDAO.addDepartment(dept) > 0) {
                JOptionPane.showMessageDialog(this, "Department Added Successfully!");
                populateDepList();
                clearButtonActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add department.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format. Please enter numbers for IDs.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error during insertion: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void depListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_depListValueChanged
        // TODO add your handling code here:
       if (evt.getValueIsAdjusting()) return; // Prevent double events
        
        DepartmentBean bean = (DepartmentBean) depList.getSelectedValue();
        if(bean == null) return;
        
        facidTF.setText(String.valueOf(bean.getFacId()));
        depidTF.setText(String.valueOf(bean.getDepId()));
        depNameTF.setText(bean.getDepName());
        remarksTA.setText(bean.getRemarks());
     
    }//GEN-LAST:event_depListValueChanged

    private void facidTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facidTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facidTFActionPerformed

    private void depNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depNameTFActionPerformed

    private void depidTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depidTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depidTFActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList depList;
    private javax.swing.JTextField depNameTF;
    private javax.swing.JTextField depidTF;
    private javax.swing.JTextField facidTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea remarksTA;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

   
}
