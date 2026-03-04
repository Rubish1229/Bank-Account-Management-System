import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    public void saveAccount(Account account) throws SQLException {
try {
    Connection conn = ConnectionDB.getConnection();

    String insertSql = "INSERT INTO account (account_holder_name,account_number,balance,account_type)VALUES(?,?,?,?)";

    PreparedStatement insertStmt = conn.prepareStatement(insertSql);

    insertStmt.setString(1,account.getAccountHolderName());
    insertStmt.setInt(2,account.getAccountNumber());
    insertStmt.setDouble(3,account.getBalance());
    insertStmt.setString(4,account.getAccountType());

    insertStmt.executeUpdate();
    System.out.println("Data saved in database");
}catch(Exception e){
    e.printStackTrace();
}

    }
}
