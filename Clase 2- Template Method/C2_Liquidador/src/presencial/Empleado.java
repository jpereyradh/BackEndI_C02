package presencial;

public  class Empleado {
    private String nombre;
    private String apellido;
    private String cuentaBancaria;

    public Empleado(String nombre, String apellido, String cuentaBancaria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }
}
