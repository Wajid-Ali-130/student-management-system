package Bean;

public class ProgramBean {
    private String progId;
    private String departmentid; // Now using department instead of faculty/department
    private String progName;
    private int durationInSem;
    private String remarks;

    public String getProgId() {
        return progId;
    }

    public void setProgId(String progId) {
        this.progId = progId;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String department) {
        this.departmentid = department;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public int getDurationInSem() {
        return durationInSem;
    }

    public void setDurationInSem(int durationInSem) {
        this.durationInSem = durationInSem;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    @Override
    public String toString(){
       return progId +". "+ progName ;
    }
}