package BackEndC3.Entrenador.service;

import BackEndC3.Entrenador.entity.Entrenador;
import org.springframework.stereotype.Component;

import java.util.List;

public interface iEntrenadorService {
    List<Entrenador> obtenerLista();
}
