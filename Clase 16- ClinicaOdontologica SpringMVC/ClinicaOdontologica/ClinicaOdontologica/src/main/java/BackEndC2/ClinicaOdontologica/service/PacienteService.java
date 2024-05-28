package BackEndC2.ClinicaOdontologica.service;

import BackEndC2.ClinicaOdontologica.model.Paciente;
import BackEndC2.ClinicaOdontologica.dao.PacienteDAOH2;
import BackEndC2.ClinicaOdontologica.dao.iDao;
import BackEndC2.ClinicaOdontologica.model.Paciente;

import java.util.List;

public class PacienteService {
    //relacion de asociacion directa con el DAO
    private iDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao= new PacienteDAOH2();
    }
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPaciente(Integer id){
        return pacienteiDao.buscarPorID(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteiDao.buscarTodos();
    }
    public void actualizarPaciente(Paciente paciente){
        pacienteiDao.actualizar(paciente);
    }
    public Paciente buscarPorCorreo(String correo){
        return pacienteiDao.buscarPorString(correo);
    }

}
