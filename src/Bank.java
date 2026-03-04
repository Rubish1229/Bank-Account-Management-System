import java.sql.SQLException;

public class Bank implements BankOperations{

    private  Account account;
    AccountDAO accDAO=new AccountDAO();
    @Override
    public Account createAccount(Account account) throws SQLException {
        this.account=account;
        accDAO.saveAccount(account);
        System.out.println("Account created!!!");
        return this.account;
    }
    @Override
    public double deposit(int accountNumber, double amount){
        if(amount<=0){
            System.out.println("Amount cannot be negative ");
            return account.getBalance();
        }
        if(account.getAccountNumber()==accountNumber){
            account.setBalance(account.getBalance()+amount);
            System.out.println("Amount : "+amount+" has been deposited !!!");
        } else System.out.println("Account doesnot exist!");
        return account.getBalance();
    }

    public double withdraw(int accountNumber, double amount){
        if(account.getAccountNumber()==accountNumber){
            if(account.getBalance()>=amount){
                account.setBalance(account.getBalance()-amount);
                System.out.println("Amount : "+amount+"withdrawn successfully!!!");
                System.out.println("New balance : "+account.getBalance());
            } else {
                System.out.println("Withdraw amt is greater than your balance...");
            }
        } else System.out.println("No account found!");
        return account.getBalance();
    }

   public double checkBalance(int accountNumber){
        if(account.getAccountNumber()==accountNumber){
            System.out.println(account.getBalance());
        } else System.out.println("Account doesnot exist !");
   return account.getBalance();
    }

   public Account displayDetails(int accountNumber){
       if (account == null) {
           System.out.println("No account found! Please create account first.");
           return null;
       }
        if(account.getAccountNumber()==accountNumber){
            System.out.println("--- ACCOUNT DETAILS ---");
            System.out.println(account.getAccountNumber());
            System.out.println(account.getAccountHolderName());
            System.out.println(account.getBalance());
            System.out.println(account.getAccountType());
        }
        return account;
   }

}
