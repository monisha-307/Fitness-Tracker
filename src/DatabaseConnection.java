import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/fitness_tracker";

    private static final String USER = "root";
    private static final String PASSWORD = "@moni2007sha";

    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            System.out.println("MySQL Connected Successfully!");
            return con;

        } catch (SQLException e) {
            System.out.println("MySQL Connection Failed!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}