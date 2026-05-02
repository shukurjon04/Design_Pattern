package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static volatile DatabaseConnection databaseConnection;

    private Connection connection;

    private static final String url = "jdbc:postgresql://localhost:5432/db_single";
    private static final String username = "postgres";
    private static final String password =  "root";

    private DatabaseConnection(){
        try {
            this.connection = DriverManager.getConnection(url,username,password);
            System.out.println("database connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnection getInstance(){
        if (databaseConnection==null){
            synchronized (DatabaseConnection.class){
                if (databaseConnection==null){
                    databaseConnection = new DatabaseConnection();
                }
            }
        }
        return databaseConnection;
    }


}
