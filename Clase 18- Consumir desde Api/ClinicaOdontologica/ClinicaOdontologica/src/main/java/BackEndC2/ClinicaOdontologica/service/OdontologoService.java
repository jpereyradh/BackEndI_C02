package BackEndC2.ClinicaOdontologica.service;

import BackEndC2.ClinicaOdontologica.dao.OdontologoDAOH2;
import BackEndC2.ClinicaOdontologica.dao.iDao;
import BackEndC2.ClinicaOdontologica.model.Odontologo;

public class OdontologoService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoService() {
        odontologoiDao= new OdontologoDAOH2();
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }
    public Odontologo buscarPorId(Integer id){
        return odontologoiDao.buscarPorID(id);
    }
}
