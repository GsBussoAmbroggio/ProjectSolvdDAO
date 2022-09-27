package models;

import java.util.Objects;

public class Branch {
//Fields
    private Long branchID;
    private String address;
    private String name;
    private String city;
    private String state;
    private String zipCode;

//Constructors
    public Branch(Long branchID, String address, String name, String city, String state, String zipCode) {
        this.branchID = branchID;
        this.address = address;
        this.name = name;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

//HashCode-Equals & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchID, branch.branchID) && Objects.equals(address, branch.address) && Objects.equals(name, branch.name) && Objects.equals(city, branch.city) && Objects.equals(state, branch.state) && Objects.equals(zipCode, branch.zipCode);
    }
    @Override
    public int hashCode() {
        return Objects.hash(branchID, address, name, city, state, zipCode);
    }
    @Override
    public String toString() {
        return "branch{" +
                "branchID=" + branchID +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

//Getters & Setters

    public Long getBranchID() {
        return branchID;
    }
    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
