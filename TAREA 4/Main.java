package com.akihabara.market.dao;


import com.akihabara.market.dao.ProductoDAO;
import com.akihabara.market.model.ProductoOtaku;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();

        // Agregar producto
        ProductoOtaku p1 = new ProductoOtaku(0, "Figura de Naruto", "Figuras", 49.99, 10);
        dao.agregarProducto(p1);

        // Obtener todos
        System.out.println("Todos los productos:");
        List<ProductoOtaku> productos = dao.obtenertTodosLosProductos();
        productos.forEach(p -> System.out.println(p.getNombre()));

        // Buscar por nombre
        System.out.println("\nBuscar 'Naruto':");
        dao.buscarProductosPorNombre("Naruto").forEach(p -> System.out.println(p.getNombre()));

        // Actualizar producto
        ProductoOtaku pUpdate = productos.get(0);
        pUpdate.setPrecio(39.99);
        dao.actualizarProducto(pUpdate);

        // Obtener por ID
        System.out.println("\nProducto con ID " + pUpdate.getId() + ":");
        ProductoOtaku pObtenido = dao.obtenerProductoPorId(pUpdate.getId());
        System.out.println(pObtenido.getNombre() + " - " + pObtenido.getPrecio());

        // Eliminar
        if (dao.eliminarProducto(pObtenido.getId())) {
            System.out.println("Producto eliminado correctamente.");
        }
    }
}
