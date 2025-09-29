package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
    static Connection connection = null;
    public Connection getConnection() {
        if (connection!= null) return connection;
        String user = "root";
        String pwd = "1502140720222004";
        String db = "searengapp";
        return getConnection(user, pwd, db);
    }

    private Connection getConnection(String user, String pwd, String db) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+db+"?user="+user+"&password="+pwd);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
