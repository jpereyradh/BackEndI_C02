package BackEndC2.ClinicaOdontologica.dao;

import BackEndC2.ClinicaOdontologica.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM ODONTOLOGOS  WHERE ID=?";
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_UPDATE=" UPDATE ODONTOLOGOS SET MATRICULA=?, NOMBRE=?, APELLIDO=? WHERE ID=?";
    private static final String SQL_DELETE="DELETE FROM ODONTOLOGOS WHERE ID=?";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("iniciando las operaciones de : Guardado de :"+odontologo.getNombre());
        Connection connection=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute();
            ResultSet clave= psInsert.getGeneratedKeys();
            while(clave.next()){
                odontologo.setId(clave.getInt(1));
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorID(Integer id) {
        logger.info("iniciando las operaciones de : busqueda De un Odontologo con id:  "+id);
        Connection connection=null;
        Odontologo odontologo= null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelect= connection.prepareStatement(SQL_SELECT_ONE);
            psSelect.setInt(1,id);
            ResultSet datos= psSelect.executeQuery();
            while (datos.next()){
                odontologo= new Odontologo(datos.getInt(1), datos.getString(2),datos.getString(3), datos.getString(4));
            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        logger.info("iniciando las operaciones de : ");
        Connection connection=null;
        try{
            connection=BD.getConnection();

        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    @Override
    public void eliminar(Integer id) {
        logger.info("iniciando las operaciones de : ");
        Connection connection=null;
        try{
            connection=BD.getConnection();

        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("iniciando las operaciones de : ");
        Connection connection=null;
        try{
            connection=BD.getConnection();

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return List.of();
    }

    @Override
    public Odontologo buscarPorString(String valor) {
        logger.info("iniciando las operaciones de : ");
        Connection connection=null;
        try{
            connection=BD.getConnection();

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
}
