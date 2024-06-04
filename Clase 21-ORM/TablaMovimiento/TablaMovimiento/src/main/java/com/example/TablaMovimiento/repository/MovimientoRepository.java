package com.example.TablaMovimiento.repository;

import com.example.TablaMovimiento.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
    //aqui adentro van todas las consultas manuales que necesitemos hacer.

}
