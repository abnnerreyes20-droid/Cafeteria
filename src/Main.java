package cafeteria;

public class Main {

    public static void main(String[] args) {

        // 1. Registrar cliente
        Cliente c = new Cliente("C001", "Ana Torres Quispe", "ana@correo.com");

        // 2. Agregar pedidos
        c.agregarPedido(new Pedido("P001", "Café americano", 5.50, 2));
        c.agregarPedido(new Pedido("P002", "Sándwich de pollo", 8.00, 1));

        // 3. Mostrar datos
        c.mostrarDatos();

        // 4. Buscar un pedido
        Pedido buscado = c.buscarPedido("P002");
        System.out.println("\nBuscado: " + (buscado != null ? buscado : "no encontrado"));

        // 5. Cambiar estado
        c.cambiarEstadoPedido("P001", Estado.ATENDIDO);
        System.out.println("\nDespués de atender P001:");
        c.mostrarDatos();

        // 6. Probar las validaciones (cada una dentro de su try/catch)
        try {
            c.agregarPedido(new Pedido("P001", "Jugo", 4.0, 1)); // código repetido
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        try {
            c.agregarPedido(new Pedido("P003", "Galleta", -2.0, 1)); // precio inválido
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            c.agregarPedido(new Pedido("P004", "Té", 3.0, 0)); // cantidad inválida
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
