package cafeteria;

import java.util.ArrayList;

public class Cliente {

    private String codigo;
    private String nombre;
    private String correo;
    // Relación 1:N -> un cliente tiene una LISTA de pedidos
    private ArrayList<Pedido> pedidos;

    public Cliente() {
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String codigo, String nombre, String correo) {
        setCodigo(codigo);
        setNombre(nombre);
        setCorreo(correo);
        this.pedidos = new ArrayList<>();
    }

    // ----- Getters y setters (con validaciones) -----
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del cliente no puede estar vacío.");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo no es válido.");
        }
        this.correo = correo.trim();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    // ----- Métodos del negocio -----

    /** Agrega un pedido, pero NO permite códigos repetidos. */
    public void agregarPedido(Pedido nuevo) {
        if (buscarPedido(nuevo.getCodigo()) != null) {
            throw new IllegalArgumentException(
                "Ya existe un pedido con el código " + nuevo.getCodigo());
        }
        pedidos.add(nuevo);
    }

    /** Devuelve el pedido con ese código, o null si no existe. */
    public Pedido buscarPedido(String codigoPedido) {
        for (Pedido p : pedidos) {
            if (p.getCodigo().equalsIgnoreCase(codigoPedido)) {
                return p;
            }
        }
        return null;
    }

    public void cambiarEstadoPedido(String codigoPedido, Estado nuevoEstado) {
        Pedido p = buscarPedido(codigoPedido);
        if (p == null) {
            throw new IllegalArgumentException("No existe el pedido " + codigoPedido);
        }
        p.setEstado(nuevoEstado);
    }

    /** Suma los importes de todos los pedidos del cliente. */
    public double calcularTotal() {
        double total = 0;
        for (Pedido p : pedidos) {
            total += p.calcularImporte();
        }
        return total;
    }

    public void mostrarDatos() {
        System.out.println("Cliente: " + codigo + " - " + nombre + " (" + correo + ")");
        if (pedidos.isEmpty()) {
            System.out.println("  (sin pedidos)");
        }
        for (Pedido p : pedidos) {
            System.out.println("  " + p);
        }
        System.out.println("  TOTAL: S/ " + calcularTotal());
    }
}
