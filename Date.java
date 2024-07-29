
import java.util.Scanner;

public class Date  {
    private String month;
    private int day;
    private int year;  // A four-digit number
    //  Date() - A default constructor for the
    //           class
    public Date()  {
        month = "January";
        day = 1;
        year = 1000;
    }
    
    // Date() - A constructor that accepts the 
    //          month in numeric format
    public Date(int monthInt, int day, int year)  {
        setDate(monthInt, day, year);
    }
    
    // Date() - A constructor that accepts the 
    //          month in string format
    public Date(String monthString, int day, int year)  {
        setDate(monthString, day, year);
    }
    
    //Date() - A constructor that assumes that the
    //         day is the first day of the
    //         specified  year
    public Date(int year)  {
        setDate(1, 1, year);
    }
    
    // Date() - An copy constructor
    public Date (Date aDate)  {
        if (aDate == null)  {
            // Not a real date
            System.out.println("Fatal error.");
            System.exit(0);
        }
        
        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }
    
    // dateOK() - Returns true if the date is valid
    //            Returns false if the date is
    //            invalid
    //            Assumes that the month is in
    //            numeric format
    public boolean dateOK(int monthInt, int dayInt, int yearInt)  {
        return( (monthInt >= 1) && (monthInt <= 12)
            &&  (dayInt >= 1) && (dayInt <= 31) 
             && (yearInt >= 1000) && (yearInt <= 9999));
    }
    
    
    // dateOK() - Returns true if the date is valid
    //            Returns false if the date is
    //            invalid
    //            Assumes that the month is in
    //            string format
    public boolean dateOK(String monthString, int dayInt, int yearInt)  {
        return( monthOK(monthString)
           &&  (dayInt >= 1) && (dayInt <= 31)
            && (yearInt >= 1000) && (yearInt <= 9999));
    }
    
    //monthOK() - Returns true if the month is one
    //            of the twelve valid strings
    //            Returns false other if not
    public boolean monthOK(String month)  {
        return (month.equals("January") 
             || month.equals("February")
             || month.equals("March")  
             || month.equals("April")
             || month.equals("May")
             || month.equals("June")
             || month.equals("July") 
             || month.equals("August")
             || month.equals("September")
             || month.equals("October")
             || month.equals("November")
             || month.equals("December"));
    }
    
    // monthString() - Returns the string for the month
    //                 specified in numeric format
    public String monthString(int monthNumber)  {
        switch(monthNumber)  {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: 
                 System.out.println("Fatal error - not a valid month");
                 System.exit(0);
                 return "Error";
        }
    }
    
    // toString() - Converts the date into a string
    public String toString()  {
        return (month + " " + day + ", " + year);
    }
    
    // equals() - Returns true if the parameter and 
    //            the object are the same data
    //            Returns false otherwise
    public boolean equals(Date otherDate)  {
        return( (month.equals(otherDate.month)) && (day == otherDate.day)
             && (year == otherDate.year));
    }
    
    
    // precedes() - Returns true if the object is
    //              an earlier date than the
    //              parameter
    //              Returns false otherwise
    public boolean precedes(Date otherDate)  {
        return((year < otherDate.year) ||
               (year == otherDate.year 
                   && getMonth() < otherDate.getMonth())
            || (year == otherDate.year 
                   && month.equals(otherDate.month) 
                   && day < otherDate.day));
    }
    
    // writeOutput() - Write the date in a proper
    //                 format
    public void writeOutput()  {
        System.out.println(month + " " + day + ", "  + year);
    }
    
    // readInput() - Read a date from the keyboard
    public void readInput() {
        boolean tryAgain = true;
        Scanner keyb = new Scanner(System.in);
        
        // Keep asking until the user enters a valid
        // date
        while (tryAgain)  {
            System.out.println("Enter month, day and year.");
            System.out.println("Do not use a comma.");
            String monthInput = keyb.next();
            int dayInput = keyb.nextInt();
            int yearInput = keyb.nextInt();
            
            if (dateOK(monthInput, dayInput, yearInput))  {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date.  Reenter input.");
        }
    }
    
    // getDay() - Accessor for day
    public int getDay()  {
        return day;
    }
    
    // getYear() – Accessor for year
    public int getYear()  {
        return year;
    }
    
    // getMonth() - Returns the month as a number
    public int getMonth()  {
        if (month.equalsIgnoreCase("January"))  return 1;
        if (month.equalsIgnoreCase("February")) return 2;
        if (month.equalsIgnoreCase("March"))  return 3;
        if (month.equalsIgnoreCase("April")) return 4;
        if (month.equalsIgnoreCase("May")) return 5;
        if (month.equalsIgnoreCase("June"))  return 6;
        if (month.equalsIgnoreCase("July"))  return 7;
        if (month.equalsIgnoreCase("August")) return 8;
        if (month.equalsIgnoreCase("September")) return 9;
        if (month.equalsIgnoreCase("October")) return 10;
        if (month.equalsIgnoreCase("November")) return 11;
        if (month.equalsIgnoreCase("December")) return 12;
        else {
            System.out.println("Fatal error - not a valid month");
            
            //Since it isn't valid, terminate the program
            System.exit(0);
            // The compilers insists on this return
            return 0;
        }
    }
    
    // setDate() - A mutator that expects the month
    //             in numeric format
    public void setDate(int month, int day, int year)  {
        if (dateOK(month, day, year)) {
            this.month = monthString(month);
            this.day = day;
            this.year = year;
        }
        else {
            System.out.println("Fatal error - invalid date");
            System.exit(0);
        }
    }
    
    // setDate() - A mutator that expects the month
    //             in string format
    public void setDate(String monthString, int day, int year)  {
        if (dateOK(monthString, day, year))  {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else  {
            System.out.println("Fatal error");
            System.exit(0);
        }
    }
    
    //setDate() - A mutator that assumes that the
    //            day is the first day of the
    //            specified year
    public void setDate(int year)  {
        setDate(1, 1, year);
    }
    
    // setMonth() - A mutator for month that checks
    //              whether it is a valid value for
    //              month
    public void setMonth(int monthNumber)  {
        if (monthNumber <= 0 && monthNumber > 12)  {
            System.out.println("Fatal error - Invalid month");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }
    
    // setDay() - A mutator for day that checks
    //            whether it is a valid value for
    //            day
    public void setDay(int day)  {
        if ((day <= 0) || (day > 31))  {
            System.out.println("Fatal error - Invalid day");
            System.exit(0);
        }
        else
            this.day = day;
    }
    
    // setYear() - A mutator for year that checks
    //             whether it is a valid value for year
    public void setYear(int year)  {
        if ((year < 1000) || (year > 9999))  {
            System.out.println("Fatal error - Invalid year");
            System.exit(0);
        }
        else
            this.year = year;
    }
}




    
