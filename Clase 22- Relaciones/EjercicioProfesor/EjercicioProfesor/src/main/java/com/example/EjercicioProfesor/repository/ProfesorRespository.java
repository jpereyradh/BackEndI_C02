package com.example.EjercicioProfesor.repository;

import com.example.EjercicioProfesor.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRespository extends JpaRepository<Profesor,Long> {
}
