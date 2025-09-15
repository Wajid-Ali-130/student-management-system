
package Frames;

import Bean.ProgramBean;
import DAO.ProgramDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class Program extends javax.swing.JFrame {

  private ProgramDAO programDAO;
    private DefaultListModel<String> programListModel;
    
    public Program() {
       initComponents();
       
       // In constructor, after initComponents()
        if (departmentComboBox.getItemCount() > 0) {
            departmentComboBox.setSelectedIndex(0); // Select first item
        }
       
        // Add action listener to departmentComboBox
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            String selectedDept = (String) departmentComboBox.getSelectedItem();
            if (selectedDept != null && !selectedDept.isEmpty()) {
                loadProgramsByDepartment(selectedDept);
            } else {
                loadProgramData(); // Show all programs if no department selected
            }
        }
        });

        // Debug: Check if components are null
        if (programlist == null) {
            JOptionPane.showMessageDialog(this, 
                "Error: programlist is null! Check GUI binding.", 
                "Initialization Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (programidTF == null) {
            JOptionPane.showMessageDialog(this, "Error: programidTF is null!", "Initialization Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // ... similar checks for other fields

        programDAO = new ProgramDAO();
        ProgramListModel customModel = new ProgramListModel();
        programlist.setModel(customModel);

        loadDepartmentData();
        loadProgramData();
    }

    private void loadDepartmentData() {
        DefaultComboBoxModel<String> deptModel = programDAO.loadDepartments();
        departmentComboBox.setModel(deptModel);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        programNameTF = new javax.swing.JTextField();
        programidTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTA = new javax.swing.JTextArea();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        programlist = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        durationInSemTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Prog name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 190, 110, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Program List");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 50, 120, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Remarks");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 290, 100, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("Program");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 40, 130, 40);

        programNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programNameTFActionPerformed(evt);
            }
        });
        getContentPane().add(programNameTF);
        programNameTF.setBounds(190, 190, 170, 30);

        programidTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programidTFActionPerformed(evt);
            }
        });
        getContentPane().add(programidTF);
        programidTF.setBounds(190, 140, 170, 30);

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

        programlist.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                programlistValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(programlist);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(370, 90, 140, 280);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Prog id");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 140, 100, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Department");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 90, 100, 30);

        getContentPane().add(departmentComboBox);
        departmentComboBox.setBounds(190, 90, 170, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Duration In Sem");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 240, 110, 30);

        durationInSemTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationInSemTFActionPerformed(evt);
            }
        });
        getContentPane().add(durationInSemTF);
        durationInSemTF.setBounds(190, 240, 170, 30);

        setSize(new java.awt.Dimension(598, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void programNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programNameTFActionPerformed

    private void programidTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programidTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programidTFActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        try {
         // Validate inputs
         if (programidTF.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Please select a program to update!");
             return;
         }
         if (programNameTF.getText().isEmpty() || durationInSemTF.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Please fill all required fields!");
             return;
         }

         ProgramBean program = new ProgramBean();
         program.setProgId(programidTF.getText());
         program.setProgName(programNameTF.getText());
         program.setDurationInSem(Integer.parseInt(durationInSemTF.getText()));
         program.setRemarks(remarksTA.getText());
         program.setDepartmentid((String) departmentComboBox.getSelectedItem());

            if (programDAO.updateProgram(program)) {
                JOptionPane.showMessageDialog(this, "Program updated successfully!");
                loadProgramData(); // Reload the program list
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update program!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid duration (numbers only)!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
            String progId = programidTF.getText();
        if (!progId.isEmpty()) {
           int confirm = JOptionPane.showConfirmDialog(this, 
               "Are you sure you want to delete program ID: " + progId + "?", 
               "Confirm Delete", JOptionPane.YES_NO_OPTION);

           if (confirm == JOptionPane.YES_OPTION) {
               if (programDAO.deleteProgram(progId)) {
                   JOptionPane.showMessageDialog(this, "Program deleted successfully!");
                   loadProgramData(); // Reload the program list
                   clearForm();
               } else {
                   JOptionPane.showMessageDialog(this, "Failed to delete program!");
               }
           }
        } else {
           JOptionPane.showMessageDialog(this, "Please select a program to delete!");
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
           // Validate inputs
           if (programidTF.getText().isEmpty() || programNameTF.getText().isEmpty() || 
               durationInSemTF.getText().isEmpty()) {
               JOptionPane.showMessageDialog(this, "Please fill all required fields!");
               return;
           }

           // Check if program ID already exists
           ProgramBean existingProgram = programDAO.getProgramById(programidTF.getText());
           if (existingProgram != null) {
               JOptionPane.showMessageDialog(this, "Program ID already exists!");
               return;
           }

           ProgramBean program = new ProgramBean();
           program.setProgId(programidTF.getText());
           program.setProgName(programNameTF.getText());
           program.setDurationInSem(Integer.parseInt(durationInSemTF.getText()));
           program.setRemarks(remarksTA.getText());
           program.setDepartmentid((String) departmentComboBox.getSelectedItem());

           if (programDAO.addProgram(program)) {
               JOptionPane.showMessageDialog(this, "Program added successfully!");
               loadProgramData(); // Reload the program list
               clearForm();
           } else {
               JOptionPane.showMessageDialog(this, "Failed to add program!");
           }
        } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, "Please enter valid duration (numbers only)!");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
           e.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void programlistValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_programlistValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting() && programlist.getSelectedIndex() != -1) {
            try {
                String selectedValue = programlist.getSelectedValue().toString();
                
                // Use regex to extract program ID from parentheses
                Pattern pattern = Pattern.compile("\\((.*?)\\)");
                Matcher matcher = pattern.matcher(selectedValue);
                
                if (matcher.find()) {
                    String progId = matcher.group(1).trim();
                    
                    ProgramBean program = programDAO.getProgramById(progId);
                    if (program != null) {
                        programidTF.setText(program.getProgId());
                        programNameTF.setText(program.getProgName());
                        durationInSemTF.setText(String.valueOf(program.getDurationInSem()));
                        remarksTA.setText(program.getRemarks());
                        
                        // Set department combobox
                        departmentComboBox.setSelectedItem(program.getDepartmentid());
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error loading program details: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_programlistValueChanged

    private void durationInSemTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationInSemTFActionPerformed
        // TODO add your handling code here:
        // Input validation for duration field
        String durationText = durationInSemTF.getText();
        if (!durationText.matches("\\d*")) {
            durationInSemTF.setText(durationText.replaceAll("[^\\d]", ""));
        }
    }//GEN-LAST:event_durationInSemTFActionPerformed
    
    // Add this helper method to clear the form
    private void clearForm() {
        programidTF.setText("");
        programNameTF.setText("");
        durationInSemTF.setText("");
        remarksTA.setText("");
        if (departmentComboBox.getItemCount() > 0) {
            departmentComboBox.setSelectedIndex(0);
        }
        programlist.clearSelection();
    }
   
    // Add this helper method to load program data
    private void loadProgramData() {
         try {
            System.out.println("Loading all programs...");
            List<ProgramBean> programs = programDAO.getAllPrograms();
            ProgramListModel model = (ProgramListModel) programlist.getModel();
            model.setPrograms(programs);
            System.out.println("Loaded " + programs.size() + " total programs.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading programs: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> departmentComboBox;
    private javax.swing.JTextField durationInSemTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField programNameTF;
    private javax.swing.JTextField programidTF;
    private javax.swing.JList programlist;
    private javax.swing.JTextArea remarksTA;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    // Add this inner class inside your Program class
    class ProgramListModel extends AbstractListModel<String> {
        private List<ProgramBean> programs = new ArrayList<>();

        public void setPrograms(List<ProgramBean> programs) {
            this.programs.clear();
            this.programs.addAll(programs);
            fireContentsChanged(this, 0, getSize());
        }

        @Override
        public int getSize() {
            return programs.size();
        }

        @Override
        public String getElementAt(int index) {
            ProgramBean program = programs.get(index);
            return program.getProgName() + " (" + program.getProgId() + ")";
        }

        public ProgramBean getProgramAt(int index) {
            return programs.get(index);
        }
    }
    
    private void loadProgramsByDepartment(String departmentName) {
    try {
        System.out.println("Loading programs for department: " + departmentName);
        
        ProgramListModel model = (ProgramListModel) programlist.getModel();
        List<ProgramBean> programs = programDAO.getProgramsByDepartment(departmentName);

            model.setPrograms(programs); // Update the model
            System.out.println("Loaded " + programs.size() + " programs for department.");
        } catch (Exception e) {
            System.out.println("Error loading programs by department: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading programs: " + e.getMessage());
        }
    }
}
