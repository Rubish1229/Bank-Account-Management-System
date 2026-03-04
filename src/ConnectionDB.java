import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/mba",
                        "postgres",
                            "root"
            );
        }catch(Exception e){
            e.printStackTrace();
        }
    return conn;
    }
}
