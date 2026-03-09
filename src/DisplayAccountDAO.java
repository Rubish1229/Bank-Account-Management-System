import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayAccountDAO {

    public Account getAccountDetails(int accountNumber) {
        Account account = null;
        try {
            Connection conn = ConnectionDB.getConnection();

            String displaySql = "SELECT account_holder_name,account_number,balance,account_type FROM account WHERE account_number = ?";
            PreparedStatement displayStmt = conn.prepareStatement(displaySql);
            displayStmt.setLong(1, accountNumber);

            ResultSet rs = displayStmt.executeQuery();

            if (rs.next()) {
                account =new Account(rs.getString("account_holder_name"),
                                    rs.getInt("account_number"),
                                    rs.getDouble("balance"),
                                    rs.getString("account_type"));
            }

        } catch (Exception e) {
            System.out.println("Exception occurred in displaying details: " + e.getMessage());
        }
        return account;
    }
}
