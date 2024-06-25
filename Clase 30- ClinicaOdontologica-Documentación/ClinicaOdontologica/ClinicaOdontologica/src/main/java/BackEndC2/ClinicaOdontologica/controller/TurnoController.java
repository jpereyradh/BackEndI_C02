package BackEndC2.ClinicaOdontologica.controller;

import BackEndC2.ClinicaOdontologica.dto.TurnoDTO;
import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.entity.Paciente;
import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;
import BackEndC2.ClinicaOdontologica.service.PacienteService;
import BackEndC2.ClinicaOdontologica.service.TurnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
@Tag(name = "Controller de Turnos", description = "este endpoint nos permite operar solo con turnos, nos devuelve un dto")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


  @PostMapping
  @Operation(summary = "nos permite registar un objeto turno", description = "devuelve un objeto dto")
    public ResponseEntity<TurnoDTO> guardarTurno(@RequestBody Turno turno){

      Optional<Paciente> pacienteBuscado= pacienteService.buscarPorID(turno.getPaciente().getId());
      Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorID(turno.getOdontologo().getId());

      if(pacienteBuscado.isPresent()&&odontologoBuscado.isPresent()){
          turno.setPaciente(pacienteBuscado.get());
          turno.setOdontologo(odontologoBuscado.get());
          return ResponseEntity.ok(turnoService.registrarTurno(turno));
      }else{
          //bad request or not found
          return ResponseEntity.badRequest().build();
      }
          }
    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listarTodosLosTurnos(){
        return ResponseEntity.ok(turnoService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarPorId(@PathVariable Long id){
      Optional<TurnoDTO> turnoBuscado= turnoService.buscarTurnoId(id);
      if(turnoBuscado.isPresent()){
          return ResponseEntity.ok(turnoBuscado.get());
      }else{
          return ResponseEntity.notFound().build();
      }
    }
}
