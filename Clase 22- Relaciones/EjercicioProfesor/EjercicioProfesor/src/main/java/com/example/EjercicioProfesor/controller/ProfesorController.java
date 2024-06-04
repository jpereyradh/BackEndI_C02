package com.example.EjercicioProfesor.controller;

import com.example.EjercicioProfesor.entity.Profesor;
import com.example.EjercicioProfesor.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
private ProfesorService profesorService;

    @Autowired
public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public ResponseEntity<Profesor> guardarProfesor(@RequestBody Profesor profesor){
        return ResponseEntity.ok(profesorService.guardarProfersor(profesor));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable Long id){
        Optional<Profesor> profesorBuscado= profesorService.buscarProfesor(id);
        if(profesorBuscado.isPresent()){
            profesorService.eliminarUnProfesor(id);
            return ResponseEntity.ok("Profesor Eliminado con exito");
        }else {
            return ResponseEntity.notFound().build();
        }

    }


}
