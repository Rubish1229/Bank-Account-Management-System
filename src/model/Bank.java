package model;

import dao.AccountDAO;
import dao.DisplayAccountDAO;
import dao.LogDAO;
import model.ErrorLogger;
import repository.BankOperations;


import java.sql.SQLException;

public class Bank implements BankOperations {

    private Account account;
    AccountDAO accountDAO=new AccountDAO();
    LogDAO logDAO=new LogDAO();
    @Override
    public Account createAccount(Account account) throws SQLException {
      try {
          this.account = account;
          accountDAO.createAccount(account);
          String msg = "Account created successfully";

          logDAO.maintainLog(account.getAccountNumber(), "CREATE", account.getBalance(), msg, account.getBalance());
      }
      catch (SQLException e){
          ErrorLogger.logError("SQL exception occured","Error creating account"+e.getMessage());
      }
        return this.account;
    }



    @Override
    public void deposit(int accountNumber, double amount){
        if(amount<=0){
            System.out.println("Amount cannot be negative ");
            ErrorLogger.logError(
                    "Invalid Deposit Amount",
                    "Account: " + accountNumber + " Amount: " + amount
            );
            return;
        }

        double currBalance=accountDAO.getBalance(accountNumber);

        double newBalance=currBalance+amount;

        accountDAO.updateBalance(accountNumber,newBalance);



        logDAO.maintainLog(accountNumber,"Deposit", amount, "Amount deposited successfully !",newBalance);



    }

    public void withdraw(int accountNumber, double amount){
        double newBalance;
        if(amount<=0){
            System.out.println("Invalid amount!");
            ErrorLogger.logError(
                    "Invalid Withdraw Amount",
                    "Account: " + accountNumber + " Amount: " + amount
            );
            return;
        }

        double currBalance=accountDAO.getBalance(accountNumber);

        if(amount<currBalance){
            newBalance=currBalance-amount;
            accountDAO.updateBalance(accountNumber,newBalance);

            logDAO.maintainLog(accountNumber,"Withdraw",amount,"Withdraw successful;",newBalance);
        }else{
            System.out.println("Withdraw amount is more than balance!");
        }
    }

   public double checkBalance(int accountNumber){
        if(account.getAccountNumber()==accountNumber){
            System.out.println(account.getBalance());
        } else System.out.println("model.Account doesnot exist !");
   return account.getBalance();
    }

   public Account displayDetails(int accountNumber){


       DisplayAccountDAO displayDao=new DisplayAccountDAO();
      Account dbAccount= displayDao.getAccountDetails(accountNumber);

        if(dbAccount!=null){
            System.out.println("--- ACCOUNT DETAILS ---");
            System.out.println("model.Account Number: " + dbAccount.getAccountNumber());
            System.out.println("model.Account Holder Name: " + dbAccount.getAccountHolderName());
            System.out.println("Balance: " + dbAccount.getBalance());
            System.out.println("model.Account Type: " + dbAccount.getAccountType());
        }
        return dbAccount;
   }

}
