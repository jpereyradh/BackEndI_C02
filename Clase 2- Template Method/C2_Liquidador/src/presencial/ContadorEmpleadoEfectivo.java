package presencial;

public class ContadorEmpleadoEfectivo extends Contador{
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double resp=0;
        if(empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo ef= (EmpleadoEfectivo) empleado;
            resp=(ef.getSueldoBasico()+ ef.getPremio())- ef.getDescuento();
        }
        return resp;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidacion es un documento en papel";
    }
}
