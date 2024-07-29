import java.util.Scanner;

public class Employee {
  private String name;
  private Date hireDate; // The previously
			 // defined Date class
  
  // Employee() - A default constructor
  public Employee() {
    name = "no name";
    // A placeholder
    hireDate = new Date("January", 1, 1000); 
  }
  
  // Employee() - A conversion constructor
  // Precondition: Neither theName nor theDate
  //               is null
  public Employee(String theName, Date theDate)  {
    if (theName == null || theDate == null) {
      System.out.println
           ("Fatal error creating employee");
      System.exit(0);
    }
    name = theName;
    hireDate = new Date(theDate);
  }
  
  // Employee() - A copy constructor
  public Employee(Employee originalObject) {
    name = originalObject.name;
    hireDate = new Date(originalObject.hireDate);
  }

  // The accessors
  public String getName() {
    return name;
  }
  
  public Date getHireDate() {
    return new Date(hireDate);
  }
  
  // setName() - A mutator for name
  // Precondition newName is not null
  public void setName(String newName) {
    if (newName == null) {
      System.out.println
          ("Fatal error setting employee name.");
      System.exit(0);
    }
    else
      name = newName;
  }

 
  // setHireDate() - A mutator for hireDate
  // Precondition newHireDate is not null
  public void setHireDate(Date newHireDate) {    
    if (newHireDate == null) {
      System.out.println
          ("Fatal error setting employee name.");
      System.exit(0);
    }
    else
      hireDate = newHireDate;
  }
  public String toString() {
    return (name + " " + hireDate.toString());
  }
  
  public boolean equals(Employee otherEmployee) {
    return (name.equals(otherEmployee.name) && hireDate.equals(otherEmployee.hireDate));
  }
}

