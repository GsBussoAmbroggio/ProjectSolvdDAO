package models;

import java.util.Objects;

public class Department {
//Fields
    private Long ID = null;
    private String name;
//Constructors
    public Department(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }
//HashCode-Equals & toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(ID, that.ID) && Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }
    @Override
    public String toString() {
        return "department{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

//Getters & Setters
    public Long getID() {
        return ID;
    }
    public void setID(Long ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
