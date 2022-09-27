package models;

import java.util.Date;
import java.util.Objects;

public class Product {
//Fields
    private String productCD;
    private Date dateOffered;
    private Date dateRetired;
    private String name;
    private String productType;
//Constructors
    public Product(String productCD, Date dateOffered, Date dateRetired, String name, String productType) {
        this.productCD = productCD;
        this.dateOffered = dateOffered;
        this.dateRetired = dateRetired;
        this.name = name;
        this.productType = productType;
    }

//HashCode-Equals & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(productCD, product.productCD) && Objects.equals(dateOffered, product.dateOffered) && Objects.equals(dateRetired, product.dateRetired) && Objects.equals(name, product.name) && Objects.equals(productType, product.productType);
    }
    @Override
    public int hashCode() {
        return Objects.hash(productCD, dateOffered, dateRetired, name, productType);
    }
    @Override
    public String toString() {
        return "product{" +
                "productCD='" + productCD + '\'' +
                ", dateOffered=" + dateOffered +
                ", dateRetired=" + dateRetired +
                ", name='" + name + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }

//Getters & Setters
    public String getProductCD() {
        return productCD;
    }
    public void setProductCD(String productCD) {
        this.productCD = productCD;
    }
    public Date getDateOffered() {
        return dateOffered;
    }
    public void setDateOffered(Date dateOffered) {
        this.dateOffered = dateOffered;
    }
    public Date getDateRetired() {
        return dateRetired;
    }
    public void setDateRetired(Date dateRetired) {
        this.dateRetired = dateRetired;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
}
