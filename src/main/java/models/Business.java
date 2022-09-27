package models;

import java.util.Date;
import java.util.Objects;

public class Business {
//Fields
private Date incorpDate;
private String name;
private String state;
private Long custID;
//Constructors

    public Business(Date incorpDate, String name, String state, Long custID) {
        this.incorpDate = incorpDate;
        this.name = name;
        this.state = state;
        this.custID = custID;
    }
//HashCode-Equals & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Business)) return false;
        Business business = (Business) o;
        return Objects.equals(incorpDate, business.incorpDate) && Objects.equals(name, business.name) && Objects.equals(state, business.state) && Objects.equals(custID, business.custID);
    }
    @Override
    public int hashCode() {
        return Objects.hash(incorpDate, name, state, custID);
    }
    @Override
    public String toString() {
        return "business{" +
                "incorpDate=" + incorpDate +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", custID=" + custID +
                '}';
    }

    //Getters & Setters
    public Date getIncorpDate() {
        return incorpDate;
    }
    public void setIncorpDate(Date incorpDate) {
        this.incorpDate = incorpDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Long getCustID() {
        return custID;
    }
    public void setCustID(Long custID) {
        this.custID = custID;
    }
}
