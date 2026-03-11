package file;

    import database.ConnectionDB;

    import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BulkAccountCreation {

        public void importAccounts() {

            String insertSql = "INSERT INTO account (account_holder_name,account_number,balance,account_type) VALUES (?,?,?,?)";

            try {

                Connection conn = ConnectionDB.getConnection();

                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DeLL\\Desktop\\bank\\accounts.txt"));

                String line;

                while ((line = br.readLine()) != null) {

                    String[] data = line.split(",");

                    String name = data[0];
                    String accNumber = data[1];
                    double balance = Double.parseDouble(data[2]);
                    String type = data[3];

                    PreparedStatement ps = conn.prepareStatement(insertSql);

                    ps.setString(1, name);
                    ps.setString(2, accNumber);
                    ps.setDouble(3, balance);
                    ps.setString(4, type);

                    ps.executeUpdate();
                }

                br.close();

                System.out.println("All accounts inserted successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
