package com.example.java8.domain;

public class Employee {
    private int empId;
    private String name;
    private String ssn;
    private double salary;

    public Employee(int empId,String name,String ssn, double salary){
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

   /* public void setEmpId(int empId) {
        this.empId = empId;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    /*public void setSsn(String ssn) {
        this.ssn = ssn;
    }*/

    public double getSalary() {
        return salary;
    }

    /*public void setSalary(double salary) {
        this.salary = salary;
    }*/

    public double raiseSalary(double increase){
        salary+=increase;
        return salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Id: ");
        sb.append(empId)
                .append(" Name: ")
                .append(name)
                .append(" Ssn: ")
                .append(ssn)
                .append(" Salary: ")
                .append(salary);
        return sb.toString();
    }
}
