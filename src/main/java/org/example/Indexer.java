package org.example;


import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Indexer {
    Connection connection;
    Indexer(Document document, String url) {
        String title = document.title();
        String link = url;
        String text = document.text();

        this.connection = JDBConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into pages values(?, ?, ?);");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, link);
            preparedStatement.setString(3, text);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }
}
