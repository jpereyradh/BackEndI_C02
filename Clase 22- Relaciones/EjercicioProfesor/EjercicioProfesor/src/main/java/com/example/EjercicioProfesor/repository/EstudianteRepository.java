package com.example.EjercicioProfesor.repository;

import com.example.EjercicioProfesor.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
}
