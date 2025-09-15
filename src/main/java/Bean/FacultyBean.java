package Bean;

public class FacultyBean {

    // Properties corresponding to the UI fields and database columns.
    private int facultyId;
    private String facultyName;
    private String remarks;

    // Default constructor
    public FacultyBean() {
    }

    // Parameterized constructor
    public FacultyBean(int facultyId, String facultyName, String remarks) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.remarks = remarks;
    }

    // Getter for facultyId
    public int getFacultyId() {
        return facultyId;
    }

    // Setter for facultyId
    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    // Getter for facultyName
    public String getFacultyName() {
        return facultyName;
    }

    // Setter for facultyName
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    // Getter for remarks
    public String getRemarks() {
        return remarks;
    }

    // Setter for remarks
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Overriding the toString() method is useful for components like JList,
     * which call this method to determine what text to display for each object.
     *
     * @return The name of the faculty.
     */
    @Override
    public String toString() {
        return facultyId +". " + facultyName;
    }
}