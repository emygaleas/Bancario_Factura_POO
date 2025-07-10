package sistemaVentas;

public class Producto {
    private String codigo;
    private String nombre;
    private String detalle;
    private double precioU;
    private int stock;

    public Producto(String codigo, String nombre, String detalle, double precioU, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precioU = precioU;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public double getPrecioU() {
        return precioU;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void actualizarStock(int cantidad) {
        stock -= cantidad;
    }
}
