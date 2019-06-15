package videoHelpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceManager {

    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;

    protected void initConnectionDb() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = ConnectionDB.getConnection();
    }

    protected void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                ConnectionDB.closeConnection(connection);
            }
        } catch (Exception e) {

        }
    }
}
