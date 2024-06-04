package com.example.TablaMovimiento.service;

import com.example.TablaMovimiento.entity.Movimiento;
import com.example.TablaMovimiento.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public Movimiento guardarMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }
    public List<Movimiento> buscarTodos(){
        return movimientoRepository.findAll();
    }
    public Optional<Movimiento> buscarPorId(Long id){
        return movimientoRepository.findById(id);
    }
    public void actualizarMovimiento(Movimiento movimiento){
         movimientoRepository.save(movimiento);
    }
}
