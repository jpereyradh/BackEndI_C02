package presencial;

public class EmpleadoEfectivo extends Empleado{
    private double sueldoBasico;
    private double descuento;
    private  double premio;

    public EmpleadoEfectivo(String nombre, String apellido, String cuentaBancaria, double sueldoBasico, double descuento, double premio) {
        super(nombre, apellido, cuentaBancaria);
        this.sueldoBasico = sueldoBasico;
        this.descuento = descuento;
        this.premio = premio;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public double getPremio() {
        return premio;
    }

    public double getDescuento() {
        return descuento;
    }
}
