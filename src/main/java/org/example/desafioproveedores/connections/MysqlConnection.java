package org.example.desafioproveedores.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    private static MysqlConnection instance;
    private Connection connection;
    private String jdbcURL = "jdbc:mysql://localhost:3306/praxis";
    private String jdbcUsername = "root";
    private String jdbcPassword = "praxis";

    private MysqlConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
    }
    public static MysqlConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MysqlConnection();
        }else if (instance.getConnection().isClosed()){
            instance = new MysqlConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        try {
            // Verificar si la conexión está cerrada o no válida antes de devolverla
            if (connection.isClosed() || !connection.isValid(3000)) {
                this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera un manejo de excepciones más robusto en producción
        }
        return connection;
    }

    // Método para cerrar la conexión (opcional)
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera un manejo de excepciones más robusto en producción
        }
    }
}
