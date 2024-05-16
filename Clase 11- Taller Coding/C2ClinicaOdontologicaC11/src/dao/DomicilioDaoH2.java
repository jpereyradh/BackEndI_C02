package dao;

import model.Domicilio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DomicilioDaoH2 implements iDao<Domicilio>{
    private static final String SQL_SELECT_ONE="SELECT * FROM DOMICILIO WHERE ID=?";
    /* -----------------------
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;*/
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return null;
    }

    @Override
    public Domicilio buscarPorID(Integer id) {
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

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Domicilio> buscarTodos() {
        return List.of();
    }
}
