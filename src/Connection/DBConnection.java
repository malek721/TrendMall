package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection conn = null;
    private final static String database = "TrendMallDB";
    private final static String username = "postgres";
    private final static String password = "malek2002";
    private static DBConnection dbconn;

    private DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + database, username, password);
            if (conn != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static DBConnection getInstance() {
        if (dbconn == null) {
            synchronized (DBConnection.class) {
                if (dbconn == null) {
                    dbconn = new DBConnection();
                }
            }
        }
        return dbconn;
    }

    public Connection getConnection() {
        return conn;
    }
}
