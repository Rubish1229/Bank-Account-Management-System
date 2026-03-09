import java.sql.SQLException;

public interface BankOperations {
    Account createAccount(Account account) throws SQLException;
    void deposit(int accountNumber, double amount);
    void withdraw(int accountNumber, double amount);
    double checkBalance(int accountNumber);
    Account displayDetails(int accountNumber);


}
