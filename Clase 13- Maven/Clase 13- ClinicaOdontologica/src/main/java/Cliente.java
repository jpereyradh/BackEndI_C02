import dao.BD;
import model.Domicilio;
import model.Paciente;
import service.PacienteService;

import java.time.LocalDate;

public class Cliente {
    public static void main(String[] args) {
        BD.crearTablas();
        Paciente paciente= new Paciente("Victor","Falconi","1111111", LocalDate.of(2024,5,20),new Domicilio("Calle publica",234,"Lima","Peru"));
        PacienteService pacienteService= new PacienteService();
        pacienteService.guardarPaciente(paciente);
        System.out.println(pacienteService.buscarPaciente(3));
    }
}
