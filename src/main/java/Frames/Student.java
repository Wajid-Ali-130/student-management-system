
package Frames;

import Bean.StudentBean;
import DAO.BatchDAO;
import DAO.StudentDAO;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class Student extends javax.swing.JFrame {

    
    private StudentDAO studentDAO;
    private DefaultListModel<String> listModel;
    
   public Student() {
        initComponents();
        studentDAO = new StudentDAO();
        listModel = new DefaultListModel<>();
        studentList.setModel(listModel);
        loadBatchIds();  // Only need to load batch IDs now
        loadAllStudents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fathersNameTF = new javax.swing.JTextField();
        studentIdTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTA = new javax.swing.JTextArea();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentList = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        batchIdComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        surnameTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rollNoTF = new javax.swing.JTextField();
        studentNameTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Fathers_name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 210, 110, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Student List");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 50, 120, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Remarks");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 330, 100, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("Student");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 40, 130, 40);

        fathersNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fathersNameTFActionPerformed(evt);
            }
        });
        getContentPane().add(fathersNameTF);
        fathersNameTF.setBounds(190, 210, 170, 30);

        studentIdTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIdTFActionPerformed(evt);
            }
        });
        getContentPane().add(studentIdTF);
        studentIdTF.setBounds(190, 130, 170, 30);

        remarksTA.setColumns(20);
        remarksTA.setRows(5);
        jScrollPane1.setViewportView(remarksTA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 330, 170, 60);

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 0, 0));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(170, 410, 72, 50);

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(260, 410, 72, 50);

        clearButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 0, 0));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(350, 410, 72, 50);

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 0, 0));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(440, 410, 72, 50);

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 0, 0));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(80, 410, 72, 50);

        studentList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                studentListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(studentList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(370, 90, 140, 300);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Student_name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 170, 100, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Student_id");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 130, 100, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Batch_id");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 90, 100, 30);

        getContentPane().add(batchIdComboBox);
        batchIdComboBox.setBounds(190, 90, 170, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Surname");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 250, 110, 30);

        surnameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTFActionPerformed(evt);
            }
        });
        getContentPane().add(surnameTF);
        surnameTF.setBounds(190, 250, 170, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Roll_no");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(70, 290, 110, 30);

        rollNoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNoTFActionPerformed(evt);
            }
        });
        getContentPane().add(rollNoTF);
        rollNoTF.setBounds(190, 290, 170, 30);

        studentNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameTFActionPerformed(evt);
            }
        });
        getContentPane().add(studentNameTF);
        studentNameTF.setBounds(190, 170, 170, 30);

        setSize(new java.awt.Dimension(598, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fathersNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fathersNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fathersNameTFActionPerformed

    private void studentIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIdTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIdTFActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
          try {
                String selectedValue = (String) studentList.getSelectedValue();
                if (selectedValue == null) {
                    JOptionPane.showMessageDialog(this, "Please select a student to update!");
                    return;
                }

                // Extract student ID from list
                String[] parts = selectedValue.split(" - ");
                if (parts.length >= 2) {
                    String idPart = parts[1].replace("ID: ", "").trim();
                    int selectedId = Integer.parseInt(idPart);

                    // Get values from form
                    int batchId = Integer.parseInt(batchIdComboBox.getSelectedItem().toString());
                    int studentId = Integer.parseInt(studentIdTF.getText()); // Get from TextField
                    String studentName = studentNameTF.getText();
                    String fathersName = fathersNameTF.getText();
                    String surname = surnameTF.getText();
                    String rollNo = rollNoTF.getText();
                    String remarks = remarksTA.getText();

                    // Validate
                    if (studentName.isEmpty() || fathersName.isEmpty() || surname.isEmpty() || rollNo.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill all required fields!");
                        return;
                    }

                    // Create StudentBean object
                    StudentBean student = new StudentBean(batchId, studentId, studentName, fathersName, surname, rollNo, remarks);
                    student.setStudentId(selectedId); // Keep the original ID for update

                    if (studentDAO.updateStudent(student)) {
                        JOptionPane.showMessageDialog(this, "Student updated successfully!");
                        loadAllStudents();
                        clearFields();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        try {
            String selectedValue = (String) studentList.getSelectedValue();
            if (selectedValue == null) {
                JOptionPane.showMessageDialog(this, "Please select a student to delete!");
                return;
            }

            // EXTRACT FROM NEW FORMAT: "Batch: XX - Name: YYY - Roll: ZZZ"
            String[] parts = selectedValue.split(" - ");
            if (parts.length >= 3) {
                int batchId = Integer.parseInt(parts[0].replace("Batch: ", "").trim());
                String studentName = parts[1].replace("Name: ", "").trim();
                String rollNo = parts[2].replace("Roll: ", "").trim();

                // Get the actual student ID
                int studentId = studentDAO.getStudentIdByDetails(batchId, studentName, rollNo);

                if (studentId == -1) {
                    JOptionPane.showMessageDialog(this, "Student not found!");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you want to delete: " + studentName + " (Roll: " + rollNo + ")?", 
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    if (studentDAO.deleteStudent(studentId)) {
                        JOptionPane.showMessageDialog(this, "Student deleted successfully!");
                        loadAllStudents();
                        clearFields();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clearFields();
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
                // Get values from form
                int batchId = Integer.parseInt(batchIdComboBox.getSelectedItem().toString());
                int studentId = Integer.parseInt(studentIdTF.getText());
                String studentName = studentNameTF.getText();
                String fathersName = fathersNameTF.getText();
                String surname = surnameTF.getText();
                String rollNo = rollNoTF.getText();
                String remarks = remarksTA.getText();

                // Validate required fields
                if (studentName.isEmpty() || fathersName.isEmpty() || surname.isEmpty() || rollNo.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all required fields!");
                    return;
                }

                // Check if the batch exists
                BatchDAO batchDAO = new BatchDAO();
                if (!batchDAO.batchExists(batchId)) {
                    JOptionPane.showMessageDialog(this, 
                        "Error: Batch ID " + batchId + " does not exist!\n" +
                        "Please select a valid batch from the dropdown.");
                    return;
                }

                // Check if student ID already exists
                if (studentDAO.studentIdExists(studentId)) {
                    JOptionPane.showMessageDialog(this, 
                        "Error: Student ID " + studentId + " already exists!\n" +
                        "Please use a different student ID.");
                    return;
                }

                // Create StudentBean object
                StudentBean student = new StudentBean(batchId, studentId, studentName, fathersName, surname, rollNo, remarks);

                // Add student to database
                if (studentDAO.addStudent(student)) {
                    JOptionPane.showMessageDialog(this, "Student added successfully!");
                    loadAllStudents();  // Refresh the list
                    clearFields();        // Clear the form
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add student!");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Batch ID and Student ID!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
    }//GEN-LAST:event_addButtonActionPerformed

    private void studentListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_studentListValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) {
            String selectedValue = (String) studentList.getSelectedValue();
            if (selectedValue != null) {
                // EXTRACT FROM NEW FORMAT: "Batch: XX - Name: YYY - Roll: ZZZ"
                String[] parts = selectedValue.split(" - ");
                if (parts.length >= 3) {
                    try {
                        int batchId = Integer.parseInt(parts[0].replace("Batch: ", "").trim());
                        String studentName = parts[1].replace("Name: ", "").trim();
                        String rollNo = parts[2].replace("Roll: ", "").trim();

                        // Get the actual student ID from database
                        int studentId = studentDAO.getStudentIdByDetails(batchId, studentName, rollNo);

                        if (studentId != -1) {
                            loadStudentDetails(studentId);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid format!");
                    }
                }
            }
        }
    }//GEN-LAST:event_studentListValueChanged

    private void surnameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTFActionPerformed

    private void rollNoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollNoTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rollNoTFActionPerformed

    private void studentNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameTFActionPerformed
    
    
    private void loadStudentList() {
        StudentDAO dao = new StudentDAO();
        List<StudentBean> students = dao.getAllStudents();

        DefaultListModel<String> model = new DefaultListModel<>();
        for (StudentBean s : students) {
            model.addElement(s.getStudentName() + " (" + s.getStudentId() + ")");
        }
        studentList.setModel(model);
    }
    
    private void loadStudentDetails(int studentId) {
        StudentBean student = studentDAO.getStudentById(studentId);
        if (student != null) {
            batchIdComboBox.setSelectedItem(String.valueOf(student.getBatchId()));
            studentIdTF.setText(String.valueOf(student.getStudentId()));
            studentNameTF.setText(student.getStudentName());
            fathersNameTF.setText(student.getFathersName());
            surnameTF.setText(student.getSurname());
            rollNoTF.setText(student.getRollNo());
            remarksTA.setText(student.getRemarks());
        }
    }
    
    private void loadBatchIds() {
        try {
            List<Integer> batchIds = studentDAO.getAllBatchIds();
            batchIdComboBox.removeAllItems();

            if (batchIds.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "No batches found! Please add batches first before adding students.");
                batchIdComboBox.addItem("No batches available");
            } else {
                for (Integer id : batchIds) {
                    batchIdComboBox.addItem(String.valueOf(id));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading batches: " + e.getMessage());
            batchIdComboBox.addItem("Error loading batches");
        }
    }

    

   private void loadAllStudents() {
        try {
            listModel.clear();
            List<StudentBean> students = studentDAO.getAllStudents();
            for (StudentBean student : students) {
                // CHANGE THIS LINE - Show batch, name, and roll number
                listModel.addElement("Batch: " + student.getBatchId() + 
                                   " - Name: " + student.getStudentName() + 
                                   " - Roll: " + student.getRollNo());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading students: " + e.getMessage());
        }
    }
    
 
    private void clearFields() {
        if (batchIdComboBox.getItemCount() > 0) batchIdComboBox.setSelectedIndex(0);
            studentIdTF.setText(""); // Clear text field instead of combo box
            studentNameTF.setText("");
            fathersNameTF.setText("");
            surnameTF.setText("");
            rollNoTF.setText("");
            remarksTA.setText("");
            studentList.clearSelection();
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> batchIdComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField fathersNameTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea remarksTA;
    private javax.swing.JTextField rollNoTF;
    private javax.swing.JTextField studentIdTF;
    private javax.swing.JList studentList;
    private javax.swing.JTextField studentNameTF;
    private javax.swing.JTextField surnameTF;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
