package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    static Connection conn=null;

    public static Connection getConnection(){
        try{
            if(conn != null){
                return conn;
            }
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
