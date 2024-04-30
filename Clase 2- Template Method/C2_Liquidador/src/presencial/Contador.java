package presencial;

public abstract class Contador {

    public String liquidarSueldo(Empleado empleado){
        String resp= "no se pudo liquidar sueldo";
        double sueldo= calcularSueldo(empleado);
        if(sueldo>0){
            String recibo= emitirRecibo(empleado);
            resp= recibo+ "Sueldo a liquidar: "+sueldo;
        }
        return  resp;
    }
    public String depositarSueldo(Empleado empleado){
        return "Orden de pago en la cuenta :::"+empleado.getCuentaBancaria();
    }
    protected  abstract double calcularSueldo(Empleado empleado);
    protected  abstract  String emitirRecibo(Empleado empleado);

}
