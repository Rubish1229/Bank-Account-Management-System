import java.sql.SQLException;

public interface BankOperations {
    Account createAccount(Account account) throws SQLException;
    double deposit(int accountNumber, double amount);
    double withdraw(int accountNumber, double amount);
    double checkBalance(int accountNumber);
    Account displayDetails(int accountNumber);


}
