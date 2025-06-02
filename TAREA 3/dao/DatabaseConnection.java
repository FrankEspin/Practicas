package com.akihabara.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	// Introducimos las variables de los datos de la conexion
	private static final String DB_URL = "jdbc:mysql://localhost:3306/akihabara_db";;
	private static final String USER = "userAkihabara";
	private static final String PASSWORD = "1234";
	
	private Connection conexion;
	
	// Contructor de la conexion
	public DatabaseConnection () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" Se ha cargado en memoria el driver de MySQL.");

            // Establecer conexión
            conexion = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println(" Se ha establecido con éxito la conexión a la base de datos.");

        } catch (ClassNotFoundException e) {
            System.out.println(" Error: No se encontró el driver de MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(" Error al conectar con la base de datos: " + e.getMessage());
        }
    }
	
	public Connection getConexion() {
		return conexion;
	}
	
	public void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
				System.out.println ("Se ha cerrado correctamente la conexion a la base de datos");
			} catch (SQLException e ) {
				System.out.println ("No se ha podido cerrar la conexion a la base de datos" + e.getMessage());
			}
		}
	}
}
