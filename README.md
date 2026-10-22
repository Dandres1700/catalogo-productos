# catalogo-productos

## Descripción

Aplicación de consola en Java que permite organizar el catálogo de productos de una tienda y controlar sus existencias. Cada producto pertenece a una categoría y cumple reglas de negocio que evitan registrar datos incorrectos o vender más unidades de las disponibles.

## Requisitos

- JDK 25
- Maven
- Git
- Spring Tools para Eclipse (opcional)

## Cómo ejecutarlo

### Desde Eclipse

1. Importar el proyecto con **File > Import > Maven > Existing Maven Projects**.
2. Clic derecho en `Main.java` (paquete `ec.edu.intesud.catalogo.app`).
3. Elegir **Run As > Java Application**.

### Desde la terminal

```bash
mvn compile
java -cp target/classes ec.edu.intesud.catalogo.app.Main
```

## Estructura del proyecto

```
catalogo-productos/
├── pom.xml
├── README.md
├── .gitignore
└── src/main/java/ec/edu/intesud/catalogo/
    ├── app/Main.java
    ├── modelo/Producto.java
    ├── modelo/Categoria.java
    └── contrato/Vendible.java
```

## Responsabilidad de cada clase

- **Categoria:** guarda código, nombre y descripción de una categoría, y valida que el código y el nombre no estén vacíos.
- **Producto:** guarda código, nombre, precio, stock y categoría. Valida las reglas de negocio (precio mayor que cero, stock no negativo, categoría obligatoria) y controla las ventas sin permitir cantidades inválidas ni superiores al stock.
- **Vendible:** interfaz que define la operación `vender(int cantidad)`.
- **Main:** crea las categorías y productos y comprueba el funcionamiento con ventas válidas y rechazadas.

## Utilidad de la interfaz Vendible

Define un contrato: cualquier clase que se pueda vender debe implementar `vender(int cantidad)`. Así el código que realiza ventas puede trabajar con una variable de tipo `Vendible` sin depender de la clase concreta, lo que permite añadir otros tipos de artículos vendibles en el futuro sin modificar ese código.

## Reglas de negocio

- Los códigos y los nombres no pueden estar vacíos.
- El precio debe ser mayor que cero.
- El stock no puede ser negativo.
- Cada producto debe tener una categoría.
- La cantidad de una venta debe ser mayor que cero.
- No se puede vender más que el stock disponible.
- Si una operación es inválida, se muestra un mensaje y el stock no cambia.