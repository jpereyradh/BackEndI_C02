package presencial;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContadorTest {

    @Test
    public void liquidarDeSueldosContratado(){
        //DADO
        Empleado juan= new EmpleadoContratado("Juan","Ferreyra","111111",8,10);
        Contador pedro= new ContadorContratado();
        String respEsp= "la liquidacion es un documento digitalSueldo a liquidar: 80.0";
        //CUANDO
        String liquidacion= pedro.liquidarSueldo(juan);
        //ENTONCES
        Assertions.assertEquals(respEsp,liquidacion);
    }
}
