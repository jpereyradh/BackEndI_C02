package BackEndC2.ClinicaOdontologica;

import BackEndC2.ClinicaOdontologica.dto.TurnoDTO;
import BackEndC2.ClinicaOdontologica.entity.Domicilio;
import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.entity.Paciente;
import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;
import BackEndC2.ClinicaOdontologica.service.PacienteService;
import BackEndC2.ClinicaOdontologica.service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntergracionTurnosTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private MockMvc mockMvc;

    public void cargarDatos(){
        Paciente pacienteGuardado= pacienteService.guardarPaciente(new Paciente("Jorgito","Pereyra","111111", LocalDate.of(2024,6,19),new Domicilio("Calle falsa",123,"La Rioja","Argentina"),"jorgito@digitalhouse.com"));
        Odontologo odontologoGuardado= odontologoService.registrarOdontologo(new Odontologo("MP10","Ivan","Bustamante"));
        TurnoDTO turnoGuardado= turnoService.registrarTurno(new Turno(pacienteGuardado,odontologoGuardado,LocalDate.of(2024,6,19)));

    }
    @Test
    public void listarTodosLosTurnos() throws Exception{
        cargarDatos();
        MvcResult respuesta= mockMvc.perform(MockMvcRequestBuilders.get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }
}
