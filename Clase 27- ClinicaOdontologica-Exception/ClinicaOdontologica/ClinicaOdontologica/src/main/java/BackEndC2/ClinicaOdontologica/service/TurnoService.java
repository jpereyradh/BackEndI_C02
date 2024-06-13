package BackEndC2.ClinicaOdontologica.service;

import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;


    public Turno registrarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
    public List<Turno> listarTodos(){
        return turnoRepository.findAll();
    }
    public Optional<Turno> buscarTurnoId(Long id){
        return turnoRepository.findById(id);
    }
    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }
    public void actualizarTurno(Turno turno){
        turnoRepository.save(turno);
    }
}
