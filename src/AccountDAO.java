
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    public void createAccount(Account account) throws SQLException {
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


    public double getBalance(int accountNumber){
        double balance=0;
        try{
            Connection conn=ConnectionDB.getConnection();

            String sql="SELECT balance FROM account WHERE account_number=?";

            PreparedStatement stmt=conn.prepareStatement(sql);

            stmt.setInt(1,accountNumber);

            ResultSet rs=stmt.executeQuery();

            if(rs.next()){
                balance=rs.getDouble("balance");
            }


        }
        catch(Exception e){
            System.out.println("Error occured while depositing amount"+e);
        }

    return balance;
    }


    public void updateBalance(int accountNumber,double balance){
        try{
            Connection conn=ConnectionDB.getConnection();

            String sql="UPDATE account SET balance=? WHERE account_number=?";

            PreparedStatement stmt=conn.prepareStatement(sql);

            stmt.setDouble(1,balance);
            stmt.setInt(2,accountNumber);

            stmt.executeUpdate();



        }catch(Exception e){
            System.out.println("Error occured inupdating amount"+e);
        }
    }
}
