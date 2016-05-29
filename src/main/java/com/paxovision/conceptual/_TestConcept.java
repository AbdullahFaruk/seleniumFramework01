package com.paxovision.conceptual;

/**
 * Array and List Interface
 */
public class _TestConcept {

    //creating constructor

    /*public _TestConcept(String nameOfMyObject){

        System.out.println("The firstName of My oBject is: " + nameOfMyObject);

    }
    public static void main(String [] args){
        _TestConcept testObject = new _TestConcept("Login Link");

    }*/

    public static void main (String [] args){

      /* Create two objects using constructor */
            Employee empOne = new Employee("James","Smith");
            Employee empTwo = new Employee("Mary", "Anne");

            // Invoking methods for each object created
            empOne.empAge(26);
            empOne.empDesignation("Senior Software Engineer");
            empOne.empSalary(1000);
            empOne.empDepartment("QA");
            empOne.printEmployee();

            System.out.println("**********************************" + "**************************");

            empTwo.empAge(21);
            empTwo.empDesignation("Software Engineer");
            empTwo.empDepartment("QA");
            empTwo.empSalary(500);
            empTwo.printEmployee();
        }



}
