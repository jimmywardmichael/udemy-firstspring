package com.employee.EmployeeApplication.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
int employeeId;
private String employeeName;
private String employeeCity;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "fk_spouse")
private Spouse spouse;
@OneToMany(cascade = CascadeType.ALL)
private List<Address> addresses;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "employee_project" ,
        joinColumns = @JoinColumn(name = "fk_employee"),
        inverseJoinColumns = @JoinColumn(name = "fk_project"))
private List<Project> projects;


    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public Employee(int employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public Employee() {

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
     public void removeProject(Project project){
        this.projects.remove(project);
        project.getEmployees().remove(this);
    }
    public void addProject(Project project){
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
