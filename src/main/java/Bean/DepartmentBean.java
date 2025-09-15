package Bean;

public class DepartmentBean {
    private int facId;
    private int depId;
    private String depName;
    private String remarks;

    public DepartmentBean() {
    }

    public DepartmentBean(int facId, int depId, String depName, String remarks) {
        this.facId = facId;
        this.depId = depId;
        this.depName = depName;
        this.remarks = remarks;
    }

    // Getters and setters
    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return depId + ". " + depName ;
    }
}