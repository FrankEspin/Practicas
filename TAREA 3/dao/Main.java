package com.akihabara.market.dao;


import com.akihabara.market.dao.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        // Instancia para la conexion
        DatabaseConnection dbConn = new DatabaseConnection();

        // Cerrarmos la conexion
        dbConn.cerrarConexion();
    }
    
}
