package cafeteria;

public class Pedido {

    // Atributos privados (encapsulamiento)
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private Estado estado;

    // Constructor por defecto: crea un pedido "vacío" en estado PENDIENTE
    public Pedido() {
        this.estado = Estado.PENDIENTE;
    }

    // Constructor parametrizado: usa los setters para que se validen los datos
    public Pedido(String codigo, String descripcion,
                  double precioUnitario, int cantidad) {
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPrecioUnitario(precioUnitario);
        setCantidad(cantidad);
        this.estado = Estado.PENDIENTE; // todo pedido nuevo empieza pendiente
    }

    // ----- Getters y setters (con validaciones) -----
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del pedido no puede estar vacío.");
        }
        this.codigo = codigo.trim();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.descripcion = descripcion.trim();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        this.cantidad = cantidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
        this.estado = estado;
    }

    // ----- Métodos del negocio -----
    public double calcularImporte() {
        return precioUnitario * cantidad;
    }

    @Override
    public String toString() {
        return "Pedido " + codigo + " | " + descripcion
                + " | S/ " + precioUnitario + " x " + cantidad
                + " = S/ " + calcularImporte()
                + " | " + estado;
    }
}
