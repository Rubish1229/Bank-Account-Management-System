import java.sql.SQLException;

public class Bank implements BankOperations{

    private  Account account;
    AccountDAO accountDAO=new AccountDAO();
    @Override
    public Account createAccount(Account account) throws SQLException {
        this.account=account;
        accountDAO.createAccount(account);
        return this.account;
    }
    @Override
    public void deposit(int accountNumber, double amount){
        if(amount<=0){
            System.out.println("Amount cannot be negative ");
            return;
        }

        double currBalance=accountDAO.getBalance(accountNumber);

        double newBalance=currBalance+amount;

        accountDAO.updateBalance(accountNumber,newBalance);

        System.out.println("Amount deposited successfully!");


    }

    public void withdraw(int accountNumber, double amount){
        double newBalance;
        if(amount<=0){
            System.out.println("Invalid amount!");
        }

        double currBalance=accountDAO.getBalance(accountNumber);

        if(amount<currBalance){
            newBalance=currBalance-amount;
            accountDAO.updateBalance(accountNumber,newBalance);
        }else{
            System.out.println("Withdraw amount is more than balance!");
        }
    }

   public double checkBalance(int accountNumber){
        if(account.getAccountNumber()==accountNumber){
            System.out.println(account.getBalance());
        } else System.out.println("Account doesnot exist !");
   return account.getBalance();
    }

   public Account displayDetails(int accountNumber){


       DisplayAccountDAO displayDao=new DisplayAccountDAO();
      Account dbAccount= displayDao.getAccountDetails(accountNumber);

        if(dbAccount!=null){
            System.out.println("--- ACCOUNT DETAILS ---");
            System.out.println("Account Number: " + dbAccount.getAccountNumber());
            System.out.println("Account Holder Name: " + dbAccount.getAccountHolderName());
            System.out.println("Balance: " + dbAccount.getBalance());
            System.out.println("Account Type: " + dbAccount.getAccountType());
        }
        return dbAccount;
   }

}
