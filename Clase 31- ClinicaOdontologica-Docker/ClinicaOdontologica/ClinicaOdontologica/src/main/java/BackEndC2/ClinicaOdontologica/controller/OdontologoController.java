package BackEndC2.ClinicaOdontologica.controller;

import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
@Tag(name = "Controller de Odontologos", description = "este endpoint nos permite operar solo con odontologos")
public class OdontologoController {
   @Autowired
    private OdontologoService odontologoService;


    @PostMapping
    @Operation(summary = "nos permite registrar un objeto odontologo", description = "devuelve el objeto completo")
    public ResponseEntity<Odontologo> registrarUnOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok(odontologoService.listarTodos());
    }
}
