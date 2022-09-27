package models;
import java.util.Date;
import java.util.Objects;

public class Employee{

//Fields
    private Long ID = null;
    private String firstName;
    private String lastName;
    private Date startDate;
    private Date endDate;
    private String title;
    private Long assignedBranchID;
    private Long deptID;
    private Long superiorEmpID;

//Constructor
    public Employee(Long ID, String firstName, String lastName, Date startDate, Date endDate, String title, Long assignedBranchID, Long deptID, Long superiorEmpID) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.assignedBranchID = assignedBranchID;
        this.deptID = deptID;
        this.superiorEmpID = superiorEmpID;
    }
//HashCode-Equals & toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getID(), employee.getID()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getStartDate(), employee.getStartDate()) && Objects.equals(getEndDate(), employee.getEndDate()) && Objects.equals(getTitle(), employee.getTitle()) && Objects.equals(getAssignedBranchID(), employee.getAssignedBranchID()) && Objects.equals(getDeptID(), employee.getDeptID()) && Objects.equals(getSuperiorEmpID(), employee.getSuperiorEmpID());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getID(), getFirstName(), getLastName(), getStartDate(), getEndDate(), getTitle(), getAssignedBranchID(), getDeptID(), getSuperiorEmpID());
    }
    @Override
    public String toString() {
        return "models.employee{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", assignedBranchID=" + assignedBranchID +
                ", deptID=" + deptID +
                ", superiorEmpID=" + superiorEmpID +
                '}';
    }

//Getters & Setters
    public Long getID() {
        return ID;
    }
    public void setID(Long ID) {
        this.ID = ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getAssignedBranchID() {
        return assignedBranchID;
    }
    public void setAssignedBranchID(Long assignedBranchID) {
        this.assignedBranchID = assignedBranchID;
    }
    public Long getDeptID() {
        return deptID;
    }
    public void setDeptID(Long deptID) {
        this.deptID = deptID;
    }
    public Long getSuperiorEmpID() {
        return superiorEmpID;
    }
    public void setSuperiorEmpID(Long superiorEmpID) {
        this.superiorEmpID = superiorEmpID;
    }
}


