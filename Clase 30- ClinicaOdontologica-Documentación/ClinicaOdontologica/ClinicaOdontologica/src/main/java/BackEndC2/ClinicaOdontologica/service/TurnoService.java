package BackEndC2.ClinicaOdontologica.service;

import BackEndC2.ClinicaOdontologica.dto.TurnoDTO;
import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.entity.Paciente;
import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;


    public TurnoDTO registrarTurno(Turno turno){
        return turnoAturnoDTO(turnoRepository.save(turno));
    }
    public List<TurnoDTO> listarTodos(){
        List<Turno> listaTurnos= turnoRepository.findAll();
        List<TurnoDTO> listaDTO= new ArrayList<>();
        for (Turno turno : listaTurnos) {
            listaDTO.add(turnoAturnoDTO(turno));
                    }
        return listaDTO;
    }
    public Optional<TurnoDTO> buscarTurnoId(Long id){
        Optional<Turno> turnoBuscado= turnoRepository.findById(id);
        if(turnoBuscado.isPresent()){
            return Optional.of(turnoAturnoDTO(turnoBuscado.get()));
        }
        return Optional.empty();
    }
    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }
    public void actualizarTurno(TurnoDTO turnoDTO){
        turnoRepository.save(turnodtoAturno(turnoDTO));
    }

    public TurnoDTO turnoAturnoDTO(Turno turno){
        TurnoDTO turnoDTO= new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setFecha(turno.getFecha());
        turnoDTO.setPacienteId(turno.getPaciente().getId());
        turnoDTO.setOdontologoId(turno.getOdontologo().getId());
        return turnoDTO;
    }
    public Turno turnodtoAturno(TurnoDTO turnoDTO){
        Turno turno= new Turno();
        Odontologo odontologo= new Odontologo();
        Paciente paciente= new Paciente();
        odontologo.setId(turnoDTO.getOdontologoId());
        paciente.setId(turnoDTO.getPacienteId());
        turno.setId(turnoDTO.getId());
        turno.setFecha(turnoDTO.getFecha());
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        return turno;
    }
}
