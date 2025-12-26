package org.codecomrades.Entity;

public class Emp {
    private int id;
    private String name;
    private double salary;
    private String adress;

    //getter and Setter

    public Emp(int id, String name, double salary, String adress) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.adress = adress;
    }

    public Emp() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
