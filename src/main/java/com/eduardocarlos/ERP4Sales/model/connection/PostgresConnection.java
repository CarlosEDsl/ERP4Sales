package com.eduardocarlos.ERP4Sales.model.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresConnection implements Connections{

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }
}
