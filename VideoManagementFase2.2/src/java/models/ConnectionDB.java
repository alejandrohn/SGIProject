/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {

    private static String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static String URL_JDBC = "jdbc:derby://localhost:1527/ProjectISDCM";
    private static String USERNAME_DB = "adminISDCM";
    private static String PASSWORD_DB = "admin";

    private static Connection getConnection(String driver, String url, String username, String password) throws SQLException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName(driver).newInstance();
        return DriverManager.getConnection(url, username, password);
    }

    public static Connection getConnection() throws SQLException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        return getConnection(ConnectionDB.DRIVER, ConnectionDB.URL_JDBC, ConnectionDB.USERNAME_DB, ConnectionDB.PASSWORD_DB);
    }

    public static void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
