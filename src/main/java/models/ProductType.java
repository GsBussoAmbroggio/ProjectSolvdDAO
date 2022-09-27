package models;

import java.util.Objects;

public class ProductType {
//Fields
private String productType;
private String name;
//Constructors
    public ProductType(String productType, String name) {
        this.productType = productType;
        this.name = name;
    }
//HashCode-Equals & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductType)) return false;
        ProductType that = (ProductType) o;
        return Objects.equals(productType, that.productType) && Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(productType, name);
    }
    @Override
    public String toString() {
        return "productType{" +
                "productType='" + productType + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

//Getters & Setters
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
