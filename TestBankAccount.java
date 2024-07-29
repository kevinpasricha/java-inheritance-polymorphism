public class TestBankAccount {
  public static void main(String[] args) {
      BankAccount ba = new BankAccount
                   ("John F. X. Smith", "jfxs2121", 400.0);
      CheckingAccount ca = new CheckingAccount
                   ("Robert M Siegfried", "rms13", 50.0, 1);

      ba.deposit(300);
      ba.withdraw(560);
      ca.deposit(500);
      ca.withdraw(200);
      
      System.out.println("The account holder\'s name is " + ba.name);
      System.out.println(ba);
      System.out.println(ca);
  }
}
