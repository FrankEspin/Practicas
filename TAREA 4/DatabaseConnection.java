package com.akihabara.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/akihabara_db";
    private static final String USER = "userAkihabara";
    private static final String PASSWORD = "1234";

    // Constructor para  el driver
    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Se ha cargado en memoria el driver.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL. " + e.getMessage());
        }
    }

    public Connection getConexion() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Se ha establecido con éxito la conexión a la base de datos.");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }

}

