package BackEndC2.ClinicaOdontologica.dao;

import BackEndC2.ClinicaOdontologica.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DomicilioDaoH2 implements iDao<Domicilio>{
    private static final String SQL_SELECT_ONE="SELECT * FROM DOMICILIOS WHERE ID=?";
    private static final String SQL_INSERT="INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE DOMICILIOS SET CALLE=?, NUMERO=?, LOCALIDAD=?, PROVINCIA=? WHERE ID=?";
    private static final Logger logger= Logger.getLogger(DomicilioDaoH2.class);
    /* -----------------------
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;*/
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        logger.info("iniciando la operacion de : Guardado de un domicilio");
        Connection connection=null;

        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, domicilio.getCalle());
            psInsert.setInt(2,domicilio.getNumero());
            psInsert.setString(3, domicilio.getLocalidad());
            psInsert.setString(4, domicilio.getProvincia());
            psInsert.execute(); //--> se auto commit y se persistio en teoria en BDD
            ResultSet rs= psInsert.getGeneratedKeys();
            while(rs.next()){
                domicilio.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return domicilio;
    }


    @Override
    public Domicilio buscarPorID(Integer id) {
        logger.info("iniciando la operacion de : Buscado de un domicilio");

        Connection connection=null;
        Domicilio domicilio= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psSelect= connection.prepareStatement(SQL_SELECT_ONE);
            psSelect.setInt(1,id);
            ResultSet rs= psSelect.executeQuery();
            while(rs.next()){
                domicilio= new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public void actualizar(Domicilio domicilio) {
        logger.info("iniciando la operacion de : actualizar un domicilio");
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psUpdate= connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, domicilio.getCalle());
            psUpdate.setInt(2,domicilio.getNumero());
            psUpdate.setString(3, domicilio.getLocalidad());
            psUpdate.setString(4, domicilio.getProvincia());
            psUpdate.setInt(5,domicilio.getId());
            psUpdate.execute();


        }catch (Exception e){
            logger.warn(e.getMessage());
        }


    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Domicilio> buscarTodos() {
        return null;
    }

    @Override
    public Domicilio buscarPorString(String valor) {
        return null;
    }
}

