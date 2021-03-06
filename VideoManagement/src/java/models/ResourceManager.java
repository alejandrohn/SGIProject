package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    protected int getMaxId(String query) throws Exception {
        try {
            initConnectionDb();
            int maxID = 0;
            PreparedStatement maxIdQuery = connection.prepareStatement(query);
            resultSet = maxIdQuery.executeQuery();

            if (resultSet.next()) {
                maxID = resultSet.getInt(1);
            }
            maxID++;
            return maxID;

        } catch (Exception e) {
            throw new Exception("Error get max id");
        } 
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
