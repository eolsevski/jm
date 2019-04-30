import java.sql.Connection;
import java.sql.DriverManager;


public class MysqlConnector {

    private Connection connection = null;

    public MysqlConnector() {
        this.connection = connect();
    }

    private Connection connect() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            return DriverManager
                    .getConnection("jdbc:mysql://localhost/miestas","root", "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
