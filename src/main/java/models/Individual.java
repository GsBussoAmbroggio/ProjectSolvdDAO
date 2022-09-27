package models;

import java.util.Date;
import java.util.Objects;

public class Individual {
//Fields
    private Date birthDate;
    private String firstName;
    private String lastName;
    private Long custID;

//Constructors
    public Individual(Date birthDate, String firstName, String lastName, Long custID) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.custID = custID;
    }
//HashCode-Equals & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Individual)) return false;
        Individual that = (Individual) o;
        return Objects.equals(birthDate, that.birthDate) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(custID, that.custID);
    }
    @Override
    public int hashCode() {
        return Objects.hash(birthDate, firstName, lastName, custID);
    }
    @Override
    public String toString() {
        return "individual{" +
                "birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", custID=" + custID +
                '}';
    }

//Getters & Setters

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
    public Long getCustID() {
        return custID;
    }
    public void setCustID(Long custID) {
        this.custID = custID;
    }
}
