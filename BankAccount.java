// Class invariant: name and acctNum cannot be null
public class BankAccount  {
    public String name;  // Account holder's name
                         // Anyone can access it
    protected String acctNum;  // Account number
                               // only subclasses
                               // and this class 
                               // can access it
    private double balance;  // The account balance
                             // only this class can
                             //  access it.
                             
    // BankAccount() - Default constructor
    public BankAccount() {
        name = new String("no name");
        acctNum = new String("no number");
        balance = 0.0;
    }
    
    // BankAccount() - A conversion constructor
    public BankAccount(String newName,String newAcctNum,
                                        double newBalance) {
        name = new String(newName);
        acctNum = new String(newAcctNum);
        balance = newBalance;
    }
    
    // BankAccount() - A copy constructor
    public BankAccount(BankAccount originalObject){
        name = new String(originalObject.name);
        acctNum = new String(originalObject.acctNum);
        balance = originalObject.balance;
    }
    
    // deposit() - deposits an amount in the
    //             account and prints information
    //             about the transaction
    public void deposit(double depositAmt) {
        balance += depositAmt;
        System.out.print(name + ", account number "
                              + acctNum + ",\n deposited ");
        System.out.printf("$%4.2f, making the balance $%4.2f\n",
                                               depositAmt, balance);
    }
    
    // withdraw()- withdraws an amount from the
    //             account and prints information
    //             about the transaction
    public void withdraw(double withAmt) { 
        if (balance >= withAmt) {
            balance -= withAmt;
            System.out.print(name + ", account number " 
                                   + acctNum + ",\n withdrew ");
            System.out.printf("$%4.2f, making the balance $%4.2f\n",
                                   withAmt, balance);
        }
        else 
        System.out.println("Sorry.. you don't have"
                            + " that much in your account.");
    }
    
    // getAcctNum() - an accessor for account
    //                number
    public String getAcctNum() {
        return new String(acctNum);
    }
    
    // getBalance() - an accessor for balance
    public double getBalance() {
        return balance;
    }
    
    // setBalance() - a mutator for balance
    protected void setBalance(double newBalance) {
        balance = newBalance;
    }
    
    // setAcctNum() - a mutator for account number
    protected void setAcctNum(String newAcctNum) {
        acctNum = newAcctNum;
    }
    
    // toString() - returns a string with main
    //              information
    public String toString() {
        return(name + " Account #" + acctNum + " Balance of $"
                                 + String.format("%4.2f", balance));
  }
}
