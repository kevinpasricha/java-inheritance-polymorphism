public class CheckingAccount extends BankAccount {
    // How many checks have been cashed this month
    private int checkCount;
    
    // The per check charge
    private final double checkFee = 0.20;
    
    // The total number of free checks per month
    private final int freeChecks = 10;
    
    // CheckingAccount() - A default constructor
    public CheckingAccount() {
        super();
        checkCount = 0;
    }
    
    // CheckingAccount() - A conversion constructor
    public CheckingAccount(String newName, String newAcctNum,
                           double newBalance, int newCheckCount)  {
        super(newName, newAcctNum, newBalance);
        checkCount = newCheckCount;
    }
    
    // CheckingAccount() - A copy constructor
    public CheckingAccount(CheckingAccount originalObject) {
        // use the base class's conversion
        // constructor
        super(originalObject.name, originalObject.acctNum, 
              originalObject.getBalance());
        checkCount = originalObject.checkCount;
    }
    
    // withdraw() - withdraws an amount from the
    //              account and prints information
    //              about the transaction
    public void withdraw(double withAmt) {
        // If the money's there, withdraw it
        if (super.getBalance() >= withAmt) {    
            super.setBalance(super.getBalance()-withAmt);
            System.out.print(name + ", account number " 
                                  + acctNum + ",\n withdrew ");
            System.out.printf("$%4.2f, making the balance $%4.2f\n",
                                     withAmt, super.getBalance());
        }
        else 
            // Otherwise just print a polite message
            System.out.println("Sorry.. you don't have"
                         + " that much in your account.");

        // That's one more check - is it still free?
        checkCount++;
        if (checkCount > freeChecks) {
            super.setBalance(super.getBalance()-checkFee);
            System.out.printf("There was a check fee of $%4.2f "
                        + "deducted,\n making the balance $%4.2f\n",
                        checkFee, super.getBalance());
        }
        else 
            System.out.println("There are still " 
                      + (freeChecks - checkCount) + " free checks left.");
    }
}
