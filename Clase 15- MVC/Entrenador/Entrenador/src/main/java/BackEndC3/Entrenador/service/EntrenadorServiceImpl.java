package BackEndC3.Entrenador.service;

import BackEndC3.Entrenador.entity.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorServiceImpl implements iEntrenadorService{
    @Override
    public List<Entrenador> obtenerLista() {
        //la logica nos dice que deberiamos llamar al iDao para que llame al H2

        return Arrays.asList(new Entrenador("Gregory"),new Entrenador("Denis"));
    }
}
