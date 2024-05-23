package com.eduardocarlos.ERP4Sales.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConnection implements Connections{

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String URL = "jdbc:mysql://localhost/erp4sales";
    private Connection connection;
    @Override
    public Connection getConnection() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(URL, URL, USER);
        }
        return null;
    }
}
