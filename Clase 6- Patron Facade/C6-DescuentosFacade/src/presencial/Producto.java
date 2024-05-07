package presencial;

public class Producto {
    private String nombre;
    private String tipo;

    public Producto(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }
}
