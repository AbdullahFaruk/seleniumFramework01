package com.paxovision.conceptual;

/**
 * Created by shawon on 3/13/16.
 */
public class Employee {

    String firstName;
    String lastName;
    int age;
    String designation;
    String department;
    double salary;

    // This is the constructor of the class Employee
    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // Assign the age of the Employee  to the variable age.
    public void empAge(int empAge){
        age =  empAge;
    }
    /* Assign the designation to the variable designation.*/
    public void empDesignation(String empDesig){
        designation = empDesig;
    }

    public void empDepartment(String empDepartment ){
        department = empDepartment;
    }

    /* Assign the salary to the variable	salary.*/
    public void empSalary(double empSalary){
        salary = empSalary;
    }
    /* Print the Employee details */
    public void printEmployee(){
        System.out.println("First Name:"+ firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age:" + age );
        System.out.println("Designation:" + designation );
        System.out.println("Department: " + department);
        System.out.println("Salary:" + salary);
    }


}
