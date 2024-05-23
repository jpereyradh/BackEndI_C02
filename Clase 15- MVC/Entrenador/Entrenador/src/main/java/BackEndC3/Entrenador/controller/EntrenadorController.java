package BackEndC3.Entrenador.controller;

import BackEndC3.Entrenador.entity.Entrenador;
import BackEndC3.Entrenador.service.EntrenadorServiceImpl;
import BackEndC3.Entrenador.service.iEntrenadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//esta clase tiene que ser el conector de la vista con el DAO,
//osea es el intermediario entre la peticion del cliente con mi backend
@RestController //por el echo de que no estamos trabajando con una tecnologia de vista
@RequestMapping("/entrenador")

public class EntrenadorController {
//vincular si o si el service
    private iEntrenadorService entrenadorService;

    public EntrenadorController() {
        entrenadorService= new EntrenadorServiceImpl();
    }

    @GetMapping
    public List<Entrenador> obtenerLista(){
        return entrenadorService.obtenerLista();
    }
}
