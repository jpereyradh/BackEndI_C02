package BackEndC2.ClinicaOdontologica.controller;

import BackEndC2.ClinicaOdontologica.model.Paciente;
import BackEndC2.ClinicaOdontologica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController //cambiamos pq no necesitamos tecnologia de vista.
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController() {
        pacienteService= new PacienteService();
    }

    /*@GetMapping
    public String buscarPacientePorCorreo(Model model, @RequestParam("email") String email){
        //vamos a pasar la solicitud atraves del http, osea va a ir en la url
        Paciente paciente= pacienteService.buscarPorCorreo(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "index";
        //return pacienteService.buscarPorCorreo(email);
    } */
    @PostMapping //nos permite crear o registrar un paciente
    public Paciente registrarUnPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }
    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable Integer id){
        return pacienteService.buscarPaciente(id);
    }

    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        //necesitamos primeramente validar si existe o  no
        Paciente pacienteBuscado= pacienteService.buscarPaciente(paciente.getId());
        if(pacienteBuscado!=null){
            pacienteService.actualizarPaciente(paciente);
            return "paciente actualizado";
        }else{
            return "paciente no encontrado";
        }

    }


}
