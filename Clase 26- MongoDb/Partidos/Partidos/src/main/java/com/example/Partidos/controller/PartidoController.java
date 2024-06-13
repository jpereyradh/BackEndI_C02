package com.example.Partidos.controller;

import com.example.Partidos.entity.Partido;
import com.example.Partidos.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public ResponseEntity<Partido> registrarPartido(@RequestBody Partido partido){
        return ResponseEntity.ok(partidoService.guardarPartido(partido));
    }
}
