import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS your_table_name ("
                + "id INT(11) NOT NULL AUTO_INCREMENT, "
                + "name VARCHAR(50) NOT NULL, "
                + "email VARCHAR(50) NOT NULL, "
                + "PRIMARY KEY (id))";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

