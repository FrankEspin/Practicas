package com.akihabara.market.ia;

import com.akihabara.market.dao.ProductoDAO;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductoDAO productoDAO = new ProductoDAO();
        LlmService llmService = new LlmService();

        int opcion;
        do {
            System.out.println("\n -------- MENÚ  --------");
            System.out.println(" ----PRODUCTOS OTAKU ----");
            System.out.println(" ");
            System.out.println("1. Agregar nuevo producto (con nombre sugerido por IA)");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de producto (ej. figura, camiseta): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Franquicia (ej. Naruto, One Piece): ");
                    String franquicia = scanner.nextLine();

                    String nombreSugerido = llmService.sugerirNombreProducto(tipo, franquicia);
                    System.out.println(" Nombre sugerido: " + nombreSugerido);

                    // Lo guarda en la  DB
                    productoDAO.insertarProducto(nombreSugerido, tipo, franquicia);
                    break;

                case 2:
                    System.out.println(" Saliendo del sistema.");
                    break;

                default:
                    System.out.println(" Esta opción no es válida.");
            }

        } while (opcion != 2);

        scanner.close();
    }
}
