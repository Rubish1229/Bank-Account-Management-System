package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectionDB;

public class LogDAO {

    public void maintainLog(int accountNumber, String action, double amount, String msg,double updatedBalance){

        try{
            Connection con= ConnectionDB.getConnection();

            String sql="INSERT INTO logs (account_number, action, amount, msg,updated_balance) VALUES (?,?,?,?,?)";

            PreparedStatement stmt=con.prepareStatement(sql);

            stmt.setInt(1,accountNumber);
            stmt.setString(2,action);
            stmt.setDouble(3,amount);
            stmt.setString(4,msg);
            stmt.setDouble(5,updatedBalance);

            stmt.executeUpdate();



        }catch(Exception e){
            System.out.println("Error occured in maintaining log"+e.getMessage());
        }
    }

    public void displayLogs(int accountNumber) {
        try {
            Connection con = ConnectionDB.getConnection();
            String sql = "SELECT * FROM logs WHERE account_number = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, accountNumber);

            ResultSet rs = stmt.executeQuery();

            System.out.println("Logs for Account: " + accountNumber);
            System.out.println("------------");
            while (rs.next()) {
                System.out.println(
                        "Action: " + rs.getString("action") +
                                ", Amount: " + rs.getDouble("amount") +
                                ", Message: " + rs.getString("msg") +
                                ", Updated Balance: " + rs.getDouble("updated_balance")
                );
            }
        } catch (Exception e) {
            System.out.println("Error occurred in fetching logs: " + e.getMessage());
        }
    }
}
