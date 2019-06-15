package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersManager extends ResourceManager {

    private String QUERY_MAX_ID = "SELECT MAX(ID) as MAXID FROM USERS";

    public void insertNewUser(String firstName, String surname, String email, String userName, String password) throws Exception {
        int maxId = 0;
        try {
            initConnectionDb();
            maxId = getMaxId(QUERY_MAX_ID);
            String queryInsertUser = getQueryInsertUser(maxId, firstName, surname, email, userName, password);
            PreparedStatement insertUser = connection.prepareStatement(queryInsertUser);
            insertUser.executeUpdate();

        } catch (Exception e) {
            throw new Exception("Error in Insert user" + maxId);
        } finally {
            closeConnection();
        }
    }

    private String getQueryInsertUser(int id, String firstName, String surname, String email, String userName, String password) {
        String query = "(" + id + ",'" + firstName + "','" + surname + "','" + email + "','" + userName + "','" + password + "')";
        return "INSERT INTO USERS (ID, FIRSTNAME, SURNAME, EMAIL, USERNAME, PASSWORD) VALUES " + query;
    }

    public void signInUser(String username, String password) throws Exception {
        try {
            initConnectionDb();

            String queryCheckUser = getQueryCheckUser(username, password);
            PreparedStatement statementCheckUser = connection.prepareStatement(queryCheckUser);
            resultSet = statementCheckUser.executeQuery();

            if (!resultSet.next()) {
                closeConnection();
                throw new Exception("There is not user with these data");
            }
        } catch (Exception e) {
            closeConnection();
            throw new Exception("Error in check user");
        }
    }

    public String getPasswordOfUser(String username) throws Exception {
        String queryForGetPassword = "SELECT PASSWORD FROM USERS WHERE USERNAME = '" + username + "'";
        String password = "";
        try {
            initConnectionDb();
            PreparedStatement statementCheckUser = connection.prepareStatement(queryForGetPassword);
            resultSet = statementCheckUser.executeQuery();

            if (resultSet.next()) {
                password = resultSet.getString("password");
            }
            return password;

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            closeConnection();
            throw new Exception("Error in get password for users authentication");
        }
    }

    private String getQueryCheckUser(String username, String password) {
        return "SELECT  * FROM USERS where USERNAME = '" + username + "' and PASSWORD = '" + password + "'";
    }

}
