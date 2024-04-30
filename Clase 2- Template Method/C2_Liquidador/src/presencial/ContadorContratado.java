package presencial;

public class ContadorContratado extends Contador{
    private String liquidarSueldo;
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double resp=0;
        if(empleado instanceof EmpleadoContratado){
            EmpleadoContratado ec=(EmpleadoContratado) empleado;
            resp= ec.getCantidadHora()*ec.getValorPorHora();
        }
        return resp;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "la liquidacion es un documento digital";
    }
}
