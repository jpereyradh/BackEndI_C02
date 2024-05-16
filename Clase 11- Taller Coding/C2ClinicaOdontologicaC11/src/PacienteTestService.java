import dao.BD;
import model.Paciente;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.util.List;

public class PacienteTestService {
   @Test
    public void buscarUnPaciente(){
       BD.crearTablas();
       PacienteService pacienteService= new PacienteService();
       Integer busqueda= 1;
       Paciente paciente= pacienteService.buscarPaciente(busqueda);
       Assertions.assertTrue(paciente!=null);
   }
}
