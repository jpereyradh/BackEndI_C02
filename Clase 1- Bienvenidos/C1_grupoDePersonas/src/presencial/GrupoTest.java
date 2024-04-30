package presencial;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
public class GrupoTest {


   @Test
    public void agregar2Persona(){
        //DADO
        Persona persona1= new Persona(18,"Juan");
        Persona persona2= new Persona(20,"Pedro");
        Persona persona3= new Persona(22,"Ana");
        Persona persona4= new Persona(14,"Luz");
        Persona persona5= new Persona(32,"Julian");

             //CUANDO
        GrupoPersona grupoPersona= new GrupoPersona();
        grupoPersona.agregarPersona(persona1);
        grupoPersona.agregarPersona(persona2);
        grupoPersona.agregarPersona(persona3);
        grupoPersona.agregarPersona(persona4);
        grupoPersona.agregarPersona(persona5);
        //ENTONCES
       //Assertions.assertTrue(grupoPersona.getPersonas().size()==2);
       Assertions.assertTrue(grupoPersona.getPersonas().size()==2);
    }
}

