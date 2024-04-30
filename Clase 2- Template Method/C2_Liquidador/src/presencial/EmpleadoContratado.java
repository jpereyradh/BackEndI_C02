package presencial;

public class EmpleadoContratado extends Empleado{
    private int cantidadHora;
    private double valorPorHora;

    public EmpleadoContratado(String nombre, String apellido, String cuentaBancaria, int cantidadHora, double valorPorHora) {
        super(nombre, apellido, cuentaBancaria);
        this.cantidadHora = cantidadHora;
        this.valorPorHora = valorPorHora;
    }

    public int getCantidadHora() {
        return cantidadHora;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }
}
