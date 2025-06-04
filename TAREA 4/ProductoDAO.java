package com.akihabara.market.dao;

import com.akihabara.market.dao.DatabaseConnection;
import com.akihabara.market.model.ProductoOtaku;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private DatabaseConnection dbConnection;

    public ProductoDAO() {
        dbConnection = new DatabaseConnection();
    }

    public void agregarProducto(ProductoOtaku producto) {
        String sql = "INSERT INTO producto(nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());
            stmt.executeUpdate();
            System.out.println("Producto agregado exitosamente.");

        } catch (SQLException e) {
            System.err.println("Error al agregar producto: " + e.getMessage());
        }
    }

    public ProductoOtaku obtenerProductoPorId(int id) {
        String sql = "SELECT * FROM producto WHERE id = ?";
        try (Connection conn = dbConnection.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ProductoOtaku(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
            }


        } catch (SQLException e) {
        	System.out.println("Error al obtener producto: " + e.getMessage());
        }
        return null;
    }
    
    public List<ProductoOtaku> obtenertTodosLosProductos(){
    	List<ProductoOtaku> productos = new ArrayList<>();
    	String sql = "SELECT * FROM producto";
    	try (Connection conn = dbConnection.getConexion();
    			PreparedStatement stmt = conn.prepareStatement(sql);
    			ResultSet rs = stmt.executeQuery()){
    		while (rs.next()) {
    			 productos.add(new ProductoOtaku(
                         rs.getInt("id"),
                         rs.getString("nombre"),
                         rs.getString("categoria"),
                         rs.getDouble("precio"),
                         rs.getInt("stock")
                 ));
    		}
    	} catch (SQLException e) {
    		System.out.println("Error al obtener los productos: "+ e.getMessage());
    	}
    	return productos;
    }
    
    public boolean actualizarProducto (ProductoOtaku producto) {
    	String sql = "UPDATE producto SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";
    	try (Connection conn = dbConnection.getConexion();
    			PreparedStatement stmt = conn.prepareStatement(sql)){
    			
    			stmt.setString (1, producto.getNombre());
    			stmt.setString (2, producto.getNombre());
    			stmt.setDouble (3, producto.getPrecio());
    			stmt.setInt (4, producto.getStock());
    			stmt.setInt (5, producto.getId());
    			System.out.println("Producto actualizado correctamente");
    			return stmt.executeUpdate()>0;
    	} catch (SQLException e) {
    		System.out.println ("Error al actualizar el producto: "+e.getMessage());
    		return false;
    		}
    	}

    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM producto WHERE id = ?";
        try (Connection conn = dbConnection.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }

    public List<ProductoOtaku> buscarProductosPorNombre(String nombre) {
        List<ProductoOtaku> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre LIKE ?";
        try (Connection conn = dbConnection.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)){
        	stmt.setString(1, "%" + nombre );
        	ResultSet rs = stmt.executeQuery();
        	
        	 while (rs.next()) {
                 productos.add(new ProductoOtaku(
                         rs.getInt("id"),
                         rs.getString("nombre"),
                         rs.getString("categoria"),
                         rs.getDouble("precio"),
                         rs.getInt("stock")
                 ));
        				
        	}
        } catch (SQLException e) {
        	System.out.println ("error al buscar el producto por su nombre: "+ e.getMessage());
        }
        return productos;
   	}
   
    public List<ProductoOtaku> buscarProductoPorCategoria(String categoria) {
        List<ProductoOtaku> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE categoria = ?";
        try (Connection conn = dbConnection.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                productos.add(new ProductoOtaku(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
        	System.out.println ("Erro al buscar porductos por su categoría: " + e.getMessage());
        }
        return productos;
    }  
}    