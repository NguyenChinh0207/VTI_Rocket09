package entity;

public class Employee extends User{
    private int projectId;
    private String ProSkill;

    public Employee(int id,String fullName, String email, String passWord, Role role, int projectId, String proSkill) {
        super(id,fullName, email, passWord, role);
        this.projectId = projectId;
        ProSkill = proSkill;
    }


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public String toString() {
        return "EmployeeID=" + getId() + ", FullName=" + getFullName()
                + ", Email=" + getEmail() + ", PassWord=" + getPassWord() +",projectId="+projectId +",  ProSkill= "+ProSkill
                + "}";
    }
}
