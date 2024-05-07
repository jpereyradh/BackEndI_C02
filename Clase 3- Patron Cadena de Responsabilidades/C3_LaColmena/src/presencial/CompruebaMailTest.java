package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaMailTest {

    @Test
    public void mailASpam(){
        //DADO
        CompruebaMail colmena= new CompruebaMail();
        Mail mail= new Mail("jorge.pereyra@digitalhouse.com","digital","tecnico");
        String respEsp= "Lo esta atendiendo Tecnico";
        //CUANDO
        String respActual= colmena.disparadorcadena(mail);
        //ENTONCES
        Assertions.assertEquals(respActual,respEsp);

    }
}
