// Class invariant: All employees have a name,
//                  hire date, non-negative wage
//                  rate and a non-negative
//                  number of hours worked.  
//                  A name string of "No name"
//                  indicates no real name
//                  specified yet.
public class HourlyEmployee extends Employee {
    private double wageRate;
    private double hours;  // for the month
    
    // HourlyEmployee() - A default constructor
    public HourlyEmployee() {
        // Call the base class's constructor
        super(); 
        wageRate = 0;
        hours = 0;
    }
    
    // HourlyEmployee() - A conversion constructor
    // Precondition: Neither theName nor theDate is
    //               null; theWageRate and theHours
    //               are non-negative.
    public HourlyEmployee(String theName,Date theDate, double theWageRate,
                               double theHours) {
        // Use the base class’s conversion
        // constructor
        super(theName, theDate); 
        if ((theWageRate >= 0) && (theHours >= 0)) {
            wageRate = theWageRate;
            hours = theHours;
        }
        else {
            System.out.println("Fatal error: creating an illegal hourly employee.");
            System.exit(0);
        }
    }
    
    // HourlyEmployee() - Copy constructor
    public HourlyEmployee(HourlyEmployee originalObject)  {
        super(originalObject); // the base class’s
                               // copy constructor
        wageRate = originalObject.wageRate;
        hours = originalObject.hours;
    }
    
    // The accessor of the derived class
    public double getRate() {
        return wageRate;
    }
    
    public double getHours() {
        return hours;
    }
    
    // getPay() - this accessor will be different
    //            in the other derived classes
    public double getPay() {
        return wageRate * hours;
    }
    
    // setHours() - A mutator for hours
    // Precondition: hoursWorked is non-negative
    public void setHours(double hoursWorked)  {
        if (hoursWorked >= 0 )
            hours = hoursWorked;
        else {
            System.out.println
            ("Fatal error: Negative hours worked");
            System.exit(0);
        }
    }
    
    // setRate() - A mutator for wageRate
    // Precondition: newWageRate is non-negative
    public void setRate(double newWageRate)  {
        if (newWageRate >= 0 )
            wageRate = newWageRate;
        else {
            System.out.println("Fatal error: Negative wage rate");
            System.exit(0);
        }
    } 
    
    // toString() - overwrites the base class's
    //     toString method
    public String toString() {
        return (getName() + " "  + getHireDate().toString()
               + "\n" + wageRate + " per hour for " 
               + hours + " hours.");
    }
    
    //equals() - Overrides the base class's equals
    //           method
    public boolean equals(HourlyEmployee other)  {
        return(getName().equals(other.getName())
            && getHireDate().equals(other.getHireDate())
            && wageRate == other.wageRate
            && hours == other.hours);
    }
}