package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MedicamentoDAOH2 implements iDao<Medicamento> {
    /*private Integer id;
  private Integer codigo;
  private String nombre;
  private String laboratorio;
  private Integer cantidad;
  private Double precio;*/
    private static final Logger logger= Logger.getLogger(MedicamentoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)";
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection= null;
        try{
            connection= BD.getConnection();
            logger.info("conexion establecida");
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            //ahora debemos cargar las parametrizadas
            psInsert.setInt(1,medicamento.getId());
            psInsert.setInt(2,medicamento.getCodigo());
            psInsert.setString(3, medicamento.getNombre());
            psInsert.setString(4, medicamento.getLaboratorio());
            psInsert.setInt(5,medicamento.getCantidad());
            psInsert.setDouble(6,medicamento.getPrecio());
            psInsert.execute();
            logger.warn("medicamento guardado con exito");
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }
}
