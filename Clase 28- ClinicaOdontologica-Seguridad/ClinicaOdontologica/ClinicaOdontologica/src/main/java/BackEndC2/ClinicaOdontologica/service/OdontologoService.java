package BackEndC2.ClinicaOdontologica.service;

import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;

    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public List<Odontologo> listarTodos(){
        return odontologoRepository.findAll();
    }
    public Optional<Odontologo> buscarPorID(Long id){
      return   odontologoRepository.findById(id);
    }
}
