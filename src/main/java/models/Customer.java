package models;

import java.util.Objects;

public class Customer {
//Fields
    private Long custID;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String ocupation;
    private String custType;
//Constructors

    public Customer(Long custID, String address, String city, String state, String postalCode, String ocupation, String custType) {
        this.custID = custID;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.ocupation = ocupation;
        this.custType = custType;
    }


//HashCode-Equals & toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(custID, customer.custID) && Objects.equals(address, customer.address) && Objects.equals(city, customer.city) && Objects.equals(state, customer.state) && Objects.equals(postalCode, customer.postalCode) && Objects.equals(ocupation, customer.ocupation) && Objects.equals(custType, customer.custType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custID, address, city, state, postalCode, ocupation, custType);
    }

    //Getters & Setters
    public Long getCustID() {
        return custID;
    }
    public void setCustID(Long custID) {
        this.custID = custID;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getOcupation() {
        return ocupation;
    }
    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }
    public String getCustType() {
        return custType;
    }
    public void setCustType(String custType) {
        this.custType = custType;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
