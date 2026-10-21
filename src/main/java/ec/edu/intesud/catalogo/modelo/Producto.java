package ec.edu.intesud.catalogo.modelo;

import ec.edu.intesud.catalogo.contrato.Vendible;

public class Producto implements Vendible {
    private final String codigo;
    private final String nombre;
    private final double precio;
    private int stock;
    private final Categoria categoria;

    public Producto(String codigo, String nombre, double precio, int stock, Categoria categoria) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código del producto no puede estar vacío.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("El producto debe tener una categoría asignada.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public Categoria getCategoria() { return categoria; }

    @Override
    public void vender(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Venta rechazada de " + nombre + ": la cantidad debe ser mayor que cero.");
            return;
        }
        if (cantidad > stock) {
            System.out.println("Venta rechazada de " + nombre + ": solo hay " + stock
                    + " unidades y se pidieron " + cantidad + ".");
            return;
        }
        stock -= cantidad;
        System.out.println("Venta exitosa de " + cantidad + " unidad(es) de " + nombre
                + ". Stock actual: " + stock);
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " | Precio: $" + precio
                + " | Stock: " + stock + " | Categoría: " + categoria.getNombre();
    }
}