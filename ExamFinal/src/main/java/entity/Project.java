package entity;

public class Project {
    private int projectId;
    private int teamSize;
    private int idManager;
    private int idEmployees;

    public Project(int projectId, int teamSize, int idManager, int idEmployees) {
        this.projectId = projectId;
        this.teamSize = teamSize;
        this.idManager = idManager;
        this.idEmployees = idEmployees;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTeamSizs() {
        return teamSize;
    }

    public void setTeamSizs(int teamSizs) {
        this.teamSize = teamSizs;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public int getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(int idEmployees) {
        this.idEmployees = idEmployees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", teamSizs=" + teamSize +
                ", idManager=" + idManager +
                ", idEmployees=" + idEmployees +
                '}';
    }
}
