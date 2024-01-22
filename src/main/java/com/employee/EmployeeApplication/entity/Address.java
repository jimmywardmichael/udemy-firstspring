package com.employee.EmployeeApplication.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String line1;
    private String line2;
    private String zipcode;
    private String city;
    private String state;
    private String country;
//    public Address(String line1, String line2, String zipcode, String city, String state, String country) {
//        this.line1 = line1;
//        this.line2 = line2;
//        this.zipcode = zipcode;
//        this.city = city;
//        this.state = state;
//        this.country = country;
//    }

@JsonIgnore
@ManyToOne
    private Employee employee;

    public Address(String line1, String line2, String zipcode, String city, String state, String country, Employee employee) {
        this.line1 = line1;
        this.line2 = line2;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.employee = employee;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address() {

    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
