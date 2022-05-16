package model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    private int id;

    private String firstName;
    private String title;
    private double salary;


    public Employee() {
    }

    public Employee(int id, String firstName, String title, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.title = title;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
