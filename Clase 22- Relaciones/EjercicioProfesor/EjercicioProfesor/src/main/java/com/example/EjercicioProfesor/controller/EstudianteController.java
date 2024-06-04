package com.example.EjercicioProfesor.controller;

import com.example.EjercicioProfesor.entity.Estudiante;
import com.example.EjercicioProfesor.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante){
        return ResponseEntity.ok(estudianteService.guardarEstudiante(estudiante));
    }
}
