package BackEndC2.ClinicaOdontologica.dao;

import BackEndC2.ClinicaOdontologica.model.Turno;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TurnosDAOLISTA implements iDao<Turno>{
    private static final Logger logger=Logger.getLogger(TurnosDAOLISTA.class);
    private List<Turno> turnos= new ArrayList<>();
    @Override
    public Turno guardar(Turno turno) {
        logger.info("iniciando las operaciones de guardado de un turno");
        //que hacemos para guardar un turno?
        PacienteDAOH2 daoPaciente= new PacienteDAOH2();
        OdontologoDAOH2 daoOdontologo= new OdontologoDAOH2();
        turno.setPaciente(daoPaciente.buscarPorID(turno.getPaciente().getId()));
        turno.setOdontologo(daoOdontologo.buscarPorID(turno.getOdontologo().getId()));
        turnos.add(turno);
        logger.info("turno guardado");
        return turno;
    }

    @Override
    public Turno buscarPorID(Integer id) {
        for (Turno turno : turnos) {
            if(turno.getId().equals(id)){
                return turno;
            }
                  }
        return null;
    }

    @Override
    public void actualizar(Turno turno) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno buscarPorString(String valor) {
        return null;
    }
}
