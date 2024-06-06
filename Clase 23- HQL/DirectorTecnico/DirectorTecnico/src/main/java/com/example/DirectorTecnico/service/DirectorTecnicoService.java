package com.example.DirectorTecnico.service;

import com.example.DirectorTecnico.entity.DirectorTecnico;
import com.example.DirectorTecnico.repository.DirectorTecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorTecnicoService {
    @Autowired
    private DirectorTecnicoRepository directorTecnicoRepository;
    public DirectorTecnico registrarDirectorTecnico(DirectorTecnico directorTecnico){
        return  directorTecnicoRepository.save(directorTecnico);
    }
    public List<DirectorTecnico> buscarTenicosMayoresQue(Integer edad){
        return directorTecnicoRepository.findByEdadGreaterThan(edad);
    }
    public Optional<DirectorTecnico> buscarPorNombre(String nombre){
        return directorTecnicoRepository.buscarTenicoPorNombre(nombre);
    }
}
