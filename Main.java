//Kevin Pasricha
//July 18, 2024
//Main.java


// Defining  Payment class
class Payment {
    // Variable to store the amount of the payment
    private double amount;

    // Constructor to initialize the amount
    public Payment(double amount) {
        this.amount = amount;
    }

    // Getter for returning the amount
    public double getAmount() {
        return amount;
    }

    // Setter to set new amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Print payment details
    public void paymentDetails() {
        System.out.println("The amount of the payment is $" + amount);
    }
}

// Define CashPayment class
class CashPayment extends Payment {
    // Constructor to initialize the amount for a cash payment
    public CashPayment(double amount) {
        super(amount);
    }

    // Override the method to get a cash payment
    @Override
    public void paymentDetails() {
        System.out.println("The cash payment amount is $" + getAmount());
    }
}

// Define the CreditCardPayment class
class CreditCardPayment extends Payment {
    // Private instance variables to store credit card details
    private String nameOnCard;
    private String expirationDate;
    private String cardNumber;

    // Iinitialize the amount and credit card details
    public CreditCardPayment(double amount, String nameOnCard, String expirationDate, String cardNumber) {
        super(amount);
        this.nameOnCard = nameOnCard;
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
    }

    // Getter method for the name on the card
    public String getNameOnCard() {
        return nameOnCard;
    }

    // Setter for name on the card
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    // Getter for expiration date
    public String getExpirationDate() {
        return expirationDate;
    }

    // Setter for expiration date
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Getter for card number
    public String getCardNumber() {
        return cardNumber;
    }

    // Setter for card number
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // Override to include credit card information
    @Override
    public void paymentDetails() {
        System.out.println("The credit card payment amount is $" + getAmount());
        System.out.println("Name on card: " + nameOnCard);
        System.out.println("Expiration date: " + expirationDate);
        System.out.println("Card number: " + cardNumber);
    }
}

// Define  main class to test  payment classes
public class Main {

    public static void main(String[] args) {
        // Create two CashPayment objects with different amounts
        CashPayment cashPayment1 = new CashPayment(50.0);
        CashPayment cashPayment2 = new CashPayment(100.0);
        
        // Create two CreditCardPayment objects with different details
        CreditCardPayment creditCardPayment1 = new CreditCardPayment(200.0, "John Doe", "12/25", "1234567812345678");
        CreditCardPayment creditCardPayment2 = new CreditCardPayment(500.0, "Jane Doe", "11/23", "8765432187654321");

        // Call paymentDetails for CashPayment object
        cashPayment1.paymentDetails();
        cashPayment2.paymentDetails();

        // Call paymentDetails for CreditCardPayment object
        creditCardPayment1.paymentDetails();
        creditCardPayment2.paymentDetails();
    }
}
