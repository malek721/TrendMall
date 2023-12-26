import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final static String database = "TrendMallDatabase";
    private final static String username = "postgres";
    private final static String password = "malek2002";
    private static Connection conn = null;
    private static final DBConnection dbconn = new DBConnection();

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
        return dbconn;
    }

    public Connection getConnection() {
        return conn;
    }
}
