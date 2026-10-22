package ec.edu.intesud.catalogo.app;

import ec.edu.intesud.catalogo.contrato.Vendible;
import ec.edu.intesud.catalogo.modelo.Categoria;
import ec.edu.intesud.catalogo.modelo.Producto;

public class Main {

    public static void main(String[] args) {
        // 1. Dos categorías y tres productos
        Categoria alacena = new Categoria("C01", "ALACENA", "Productos no perecibles de cocina");
        Categoria congelados = new Categoria("C02", "ALIMENTOS CONGELADOS", "Alimentos que requieren congelación");

        Producto arroz = new Producto("P01", "Arroz Blanco", 1.10, 100, alacena);
        Producto atun = new Producto("P02", "Atun Real", 1.45, 60, alacena);
        Producto helados = new Producto("P03", "Helados", 4.25, 30, congelados);

        // 2. Datos de cada producto y su categoría
        System.out.println("=== DATOS DE LOS PRODUCTOS ===");
        System.out.println(arroz);
        System.out.println(atun);
        System.out.println(helados);
        System.out.println();
        System.out.println("Categoría del arroz: " + arroz.getCategoria());
        System.out.println("Categoría del atún: " + atun.getCategoria());
        System.out.println("Categoría de los helados: " + helados.getCategoria());

        // 3. Venta válida
        System.out.println("\n=== VENTA VÁLIDA ===");
        arroz.vender(20);
        System.out.println("Stock actualizado de Arroz Blanco: " + arroz.getStock());

        // 4. Cantidad superior al stock
        System.out.println("\n=== VENTA SUPERIOR AL STOCK ===");
        System.out.println("Stock antes: " + atun.getStock());
        atun.vender(500);

        // 5. Cantidad igual a cero
        System.out.println("\n=== VENTA CON CANTIDAD CERO ===");
        atun.vender(0);

        // 6. Comprobar que lo rechazado no modificó el stock
        System.out.println("\n=== COMPROBACIÓN DE STOCK ===");
        System.out.println("Stock de Atun Real después de las ventas rechazadas: " + atun.getStock()
                + " (debe seguir en 60)");

        // 7. Venta mediante una variable de tipo Vendible
        System.out.println("\n=== VENTA CON VARIABLE VENDIBLE ===");
        Vendible vendible = helados;
        vendible.vender(5);
        System.out.println("Stock de Helados: " + helados.getStock());
    }
}