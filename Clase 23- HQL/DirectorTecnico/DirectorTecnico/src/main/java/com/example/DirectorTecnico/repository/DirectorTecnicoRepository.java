package com.example.DirectorTecnico.repository;

import com.example.DirectorTecnico.entity.DirectorTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DirectorTecnicoRepository extends JpaRepository<DirectorTecnico,Long> {
    //aca van todos los metodos manuales

    List<DirectorTecnico> findByEdadGreaterThan(Integer edad);
    //consulta 100% hql
    @Query("SELECT dt FROM DirectorTecnico dt where dt.nombre=?1")
    Optional<DirectorTecnico> buscarTenicoPorNombre(String nombre);


}
