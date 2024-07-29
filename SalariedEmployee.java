// Class invariant: All employees have a name,
//                  hire date and non-negative
//                  salary.
//                  A name string of "No name"
//                  indicates no real name
//                  specified yet.
//                  A hire date of January 1,
//                  1000 indicated no real hire
//                  date specified yet.
public class SalariedEmployee extends Employee {
  private double salary; // annual
 // SalariedEmployee() - A default constructor
  public SalariedEmployee() {
    // Call the base class's constructor
    super();
    salary = 0;
  }
  // SalariedEmployee() - A conversion
  //                      constructor
  // Precondition: Neither theName nor theDate is
  //               null; theSalary is  non-
  //               negative.
  public SalariedEmployee(String theName, 
             Date theDate,   double theSalary) {
    // using the base class’s conversion
    // constructor
    super(theName, theDate);

        if (theSalary >= 0) {
      salary = theSalary;
    }
    else {
      System.out.println
            ("Fatal error: Negative salary.");
      System.exit(0);
    }
  }
  // SalariedEmployee() - Copy constructor
  public SalariedEmployee
        (SalariedEmployee originalObject)  {
    super(originalObject); 
    salary = originalObject.salary;
  }
  
  // getSalary() - An accessor
  public double getSalary() {
    return salary;
  }
  // getPay() - this accessor will be different
  //            in the other derived classes and
  //            is also from different from
  //            HourlyEmployee
  public double getPay() {
    return salary / 12;
  }
    // setSalary() - A mutator for salary
  // Precondition: salary is non-negative
  public void setSalary(double newSalary)  {
    if (salary >= 0 )
      salary = newSalary;
    else {
      System.out.println
         ("Fatal error: Negative salary");
      System.exit(0);
    }
  }
  // toString() - overwrites the base class's 
  //              toString method
  public String toString() {
    return (getName() + " "  
              + getHireDate().toString()
              + "\n" + salary + " per year");
  }
  //equals() - Overrides the base class's equals
  //           method
  public boolean equals(SalariedEmployee other)  {
    return(getName().equals(other.getName()) &&
          getHireDate().equals(other.getHireDate())
             && salary == other.salary);
  }
}
