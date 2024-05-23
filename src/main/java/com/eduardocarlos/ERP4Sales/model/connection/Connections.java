package com.eduardocarlos.ERP4Sales.model.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connections {

    public Connection getConnection() throws SQLException;

}
