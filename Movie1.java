//Kevin Pasricha
//July 18, 2024
//Movie1.java


// Define the Movie class
class Movie {
    // Private variables to store the rating, ID, and title
    private String mpaaRating;
    private int idNumber;
    private String title;

    // Constructor to set the rating, ID, and title
    public Movie(String mpaaRating, int idNumber, String title) {
        this.mpaaRating = mpaaRating;
        this.idNumber = idNumber;
        this.title = title;
    }

    // Get rating
    public String getMpaaRating() {
        return mpaaRating;
    }

    // Set new rating
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    // Get ID number
    public int getIdNumber() {
        return idNumber;
    }

    // Set new ID number
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    // Get title
    public String getTitle() {
        return title;
    }

    // Set new title
    public void setTitle(String title) {
        this.title = title;
    }

    // Check if two movies are equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // If same object, return true
        if (obj == null || getClass() != obj.getClass()) return false; // If obj is null or not the same class, return false
        Movie movie = (Movie) obj; // Cast obj to Movie
        return idNumber == movie.idNumber; // Compare ID numbers
    }

    // Calculate late fees
    public double calcLateFees(int daysLate) {
        return daysLate * 2.0;
    }
}

// Define Action class
class Action extends Movie {
    // Constructor to set the rating, ID, and title for Action movies
    public Action(String mpaaRating, int idNumber, String title) {
        super(mpaaRating, idNumber, title);
    }

    // Calculate late fees
    @Override
    public double calcLateFees(int daysLate) {
        return daysLate * 3.0;
    }
}

// Define the Comedy class
class Comedy extends Movie {
    // Constructor to set the rating, ID, and title for Comedy movies
    public Comedy(String mpaaRating, int idNumber, String title) {
        super(mpaaRating, idNumber, title);
    }

    // Calculate late fees
    @Override
    public double calcLateFees(int daysLate) {
        return daysLate * 2.5;
    }
}

// Define the Drama class
class Drama extends Movie {
    // Constructor to set the rating, ID, and title for Drama movies
    public Drama(String mpaaRating, int idNumber, String title) {
        super(mpaaRating, idNumber, title);
    }

}

// Define main class
public class Movie1 {

    public static void main(String[] args) {

        Action actionMovie = new Action("PG-13", 1, "Action Movie");
        Comedy comedyMovie = new Comedy("PG", 2, "Comedy Movie");
        Drama dramaMovie = new Drama("R", 3, "Drama Movie");

        // Late fee calculations
        System.out.println("Action movie late fee for 5 days: $" + actionMovie.calcLateFees(5));
        System.out.println("Comedy movie late fee for 5 days: $" + comedyMovie.calcLateFees(5));
        System.out.println("Drama movie late fee for 5 days: $" + dramaMovie.calcLateFees(5));


        Drama anotherDramaMovie = new Drama("R", 3, "Another Drama Movie");
        System.out.println("Are the two drama movies equal? " + dramaMovie.equals(anotherDramaMovie));
    }
}
//End of program
