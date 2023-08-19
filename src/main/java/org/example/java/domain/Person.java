package org.example.java.domain;

public class Person {

    private Long id;
    private String name;
    private String address;
    private String city;

    public Person() {}

    public Person(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", endereco='" + getAddress() + "'" +
                ", city='" + getCity() + "'" +
                "}";
    }

}
