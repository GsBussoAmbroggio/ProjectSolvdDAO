package models;

import java.util.Date;
import java.util.Objects;

public class Officer extends AbstractEntity  {
//Field
private Long officerID;
private Date startDate;
private Date endDate;
private String firstName;
private String lastName;
private String title;
private Long custID;

//Constructors
    public Officer(Long officerID, Date endDate, String firstName, String lastName, Date startDate, String title, Long custID) {
        this.officerID = officerID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.custID = custID;
    }

//HashCode-Equals & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Officer)) return false;
        Officer officer = (Officer) o;
        return Objects.equals(officerID, officer.officerID) && Objects.equals(startDate, officer.startDate) && Objects.equals(endDate, officer.endDate) && Objects.equals(firstName, officer.firstName) && Objects.equals(lastName, officer.lastName) && Objects.equals(title, officer.title) && Objects.equals(custID, officer.custID);
    }
    @Override
    public int hashCode() {
        return Objects.hash(officerID, startDate, endDate, firstName, lastName, title, custID);
    }
    @Override
    public String toString() {
        return "officer{" +
                "officerID=" + officerID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", custID=" + custID +
                '}';
    }

//Getters & Setters

    public Long getOfficerID() {
        return officerID;
    }
    public void setOfficerID(Long officerID) {
        this.officerID = officerID;
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getCustID() {
        return custID;
    }
    public void setCustID(Long custID) {
        this.custID = custID;
    }
}

