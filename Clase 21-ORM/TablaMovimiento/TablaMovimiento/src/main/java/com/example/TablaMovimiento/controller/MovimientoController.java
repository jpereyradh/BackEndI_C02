package com.example.TablaMovimiento.controller;

import com.example.TablaMovimiento.entity.Movimiento;
import com.example.TablaMovimiento.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private MovimientoService movimientoService;

   @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }
    @PostMapping
    public ResponseEntity<Movimiento> guardarMovimiento(@RequestBody Movimiento movimiento){
       return ResponseEntity.ok(movimientoService.guardarMovimiento(movimiento));
    }
    @GetMapping
    public ResponseEntity<List<Movimiento>> listarMovimientos(){
       return ResponseEntity.ok(movimientoService.buscarTodos());
    }
}
