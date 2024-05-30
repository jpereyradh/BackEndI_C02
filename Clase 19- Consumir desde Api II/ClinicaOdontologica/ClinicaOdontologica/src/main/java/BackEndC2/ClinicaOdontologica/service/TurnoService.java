package BackEndC2.ClinicaOdontologica.service;

import BackEndC2.ClinicaOdontologica.dao.TurnosDAOLISTA;
import BackEndC2.ClinicaOdontologica.dao.iDao;
import BackEndC2.ClinicaOdontologica.model.Turno;

import java.util.List;

public class TurnoService {
    private iDao<Turno> turnoiDao;

    public TurnoService() {
        turnoiDao= new TurnosDAOLISTA();
    }
    public Turno guardarTurno(Turno turno){
        return turnoiDao.guardar(turno);
    }
    public Turno buscarPorID(Integer id){
        return turnoiDao.buscarPorID(id);
    }
    public List<Turno> listarTurnos(){
        return turnoiDao.buscarTodos();
    }
}
