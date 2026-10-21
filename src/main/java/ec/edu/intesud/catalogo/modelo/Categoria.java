package ec.edu.intesud.catalogo.modelo;

public class Categoria {
	
	//Objetos Privados
    private final String codigo;
    private final String nombre;
    private final String descripcion;

    public Categoria(String codigo, String nombre, String descripcion) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código de la categoría no puede estar vacío."); //Mensaje de error 
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");  // Mensaje de error
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion == null ? "" : descripcion;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ") - " + descripcion;
    }
}