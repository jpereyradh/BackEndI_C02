package com.example.EjercicioProfesor.service;

import com.example.EjercicioProfesor.entity.Profesor;
import com.example.EjercicioProfesor.repository.ProfesorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorService {

    private ProfesorRespository profesorRespository;

    @Autowired
    public ProfesorService(ProfesorRespository profesorRespository) {
        this.profesorRespository = profesorRespository;
    }

    public Profesor guardarProfersor(Profesor profesor){
        return profesorRespository.save(profesor);
    }
    public void eliminarUnProfesor(Long id){
         profesorRespository.deleteById(id);
    }
    public Optional<Profesor> buscarProfesor(Long id){
        return profesorRespository.findById(id);
    }

}
