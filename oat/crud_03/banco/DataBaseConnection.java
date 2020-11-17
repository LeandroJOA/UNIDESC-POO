package br.edu.unidesc.exercicio.oat.crud_03.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection connection = null;
    private static DataBaseConnection dataBaseConnection;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3307/crud?serverTimezone=UTC";
    private static final String PWD = "";
    private static final String USR = "root";

    private DataBaseConnection() {
        getConnection();
    }

    public static DataBaseConnection getInstance() {
        if (dataBaseConnection == null) {
            dataBaseConnection = new DataBaseConnection();
        }
        return dataBaseConnection;
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USR, PWD);
            }
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    public PreparedStatement criarPreparedStatement(String sql, int returnGenerateKeys) throws SQLException{
        return connection.prepareStatement(sql, returnGenerateKeys);
    }
}
