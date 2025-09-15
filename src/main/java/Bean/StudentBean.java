package Bean;

public class StudentBean {
    private int studentId;
    private int batchId;
    private String studentName;
    private String surname;
    private String fathersName;
    private String rollNo;
    private String remarks;

    // Default Constructor (Required for Beans)
    public StudentBean() {
    }

    // Parameterized Constructor
   public StudentBean(int batchId, int studentId, String studentName, String fathersName, 
                  String surname, String rollNo, String remarks) {
    this.batchId = batchId;
    this.studentId = studentId;
    this.studentName = studentName;
    this.fathersName = fathersName;
    this.surname = surname;
    this.rollNo = rollNo;
    this.remarks = remarks;
}

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    // toString() for debugging & logging
    @Override
    public String toString() {
        return "StudentBean{" +
                "studentId=" + studentId +
                ", batchId=" + batchId +
                ", studentName='" + studentName + '\'' +
                ", surname='" + surname + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}