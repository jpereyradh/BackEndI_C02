package BackEndC2.ClinicaOdontologica.dao;


import BackEndC2.ClinicaOdontologica.model.Domicilio;
import BackEndC2.ClinicaOdontologica.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente> {

    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT_ONE = "SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";
    private static final String SQL_SELECT_BY_EMAIL ="SELECT * FROM PACIENTES WHERE EMAIL=?";
    private static final String SQL_UPDATE="UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, CEDULA=?, FECHA_INGRESO=?, DOMICILIO_ID=?, EMAIL=? WHERE ID=? ";


    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("inicando la operacion de guardado");
        Connection connection = null;
        try {
            DomicilioDaoH2 daoAux = new DomicilioDaoH2();
            Domicilio domicilio = daoAux.guardar(paciente.getDomicilio());
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3, paciente.getCedula());
            psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psInsert.setInt(5, domicilio.getId());
            psInsert.setString(6,paciente.getEmail());
            psInsert.execute(); //CUANDO SE EJECUTE SE VAN A GENERAR ID
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                paciente.setId(rs.getInt(1));
            }
            logger.info("paciente guardado con exito");


        } catch (Exception e) {
            logger.warn(e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorID(Integer id) {
        logger.info("iniciando la busqueda de un paciente por id: " + id);
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;
        try {
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1, id);
            ResultSet rs = psSelectOne.executeQuery();
            DomicilioDaoH2 domAux = new DomicilioDaoH2();
            while (rs.next()) {
                domicilio = domAux.buscarPorID(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), domicilio,rs.getString(7));

            }


        } catch (Exception e) {
            logger.warn(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.warn(ex.getMessage());
            }
        }
        return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {
        logger.info("iniciando la actualizacion de : "+paciente.getNombre()+" con id : "+paciente.getId());
        Connection connection= null;
        DomicilioDaoH2 daoAux= new DomicilioDaoH2();
        daoAux.actualizar(paciente.getDomicilio());
        try{
            connection= BD.getConnection();
            PreparedStatement psUpdate= connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,paciente.getNombre());
            psUpdate.setString(2, paciente.getApellido());
            psUpdate.setString(3, paciente.getCedula());
            psUpdate.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psUpdate.setInt(5,paciente.getDomicilio().getId());
            psUpdate.setString(6, paciente.getEmail());
            psUpdate.setInt(7,paciente.getId());
            psUpdate.execute();


        }catch (Exception e){
            logger.warn(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.warn(ex.getMessage());
            }
        }

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        logger.info("iniciando la busqueda de todos los pacientes");
        Connection connection= null;
        Paciente paciente= null;
        Domicilio domicilio= null;
        List<Paciente> pacientes= new ArrayList<>();
        try{
            connection=BD.getConnection();
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery(SQL_SELECT_ALL);
            DomicilioDaoH2 daoAux= new DomicilioDaoH2();
            while (rs.next()){
                domicilio= daoAux.buscarPorID(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio, rs.getString(7));
                pacientes.add(paciente);
            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.warn(ex.getMessage());
            }
        }
        return pacientes;
    }

    @Override
    public Paciente buscarPorString(String valor) {
        logger.info("iniciando las operaciones de busqueda: "+valor);
        Connection connection= null;
        Paciente paciente= null;
        Domicilio domicilio= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_BY_EMAIL);
            psSelectOne.setString(1,valor);
            ResultSet rs= psSelectOne.executeQuery();
            DomicilioDaoH2 daoAux= new DomicilioDaoH2();
            while (rs.next()){
                domicilio= daoAux.buscarPorID(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio, rs.getString(7));
            }


        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.warn(ex.getMessage());
            }
        }
        return paciente;
    }
}
