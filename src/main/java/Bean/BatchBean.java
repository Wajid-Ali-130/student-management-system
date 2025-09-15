package Bean;

public class BatchBean {
    private int programId;
    private int batchId;
    private int batchYear;
    private String shift;
    private String groupDesc;
    private String remarks;

    // Default Constructor
    public BatchBean() {
    }

    // Parameterized Constructor
    public BatchBean(int programId, int batchId, int batchYear, String shift, String groupDesc, String remarks) {
        this.programId = programId;
        this.batchId = batchId;
        this.batchYear = batchYear;
        this.shift = shift;
        this.groupDesc = groupDesc;
        this.remarks = remarks;
    }

    // Getters and Setters
    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getBatchYear() {
        return batchYear;
    }

    public void setBatchYear(int batchYear) {
        this.batchYear = batchYear;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
//    public String toString(){
//        return     
//    }
}