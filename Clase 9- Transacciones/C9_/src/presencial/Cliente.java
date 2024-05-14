package presencial;

import org.apache.log4j.Logger;

import java.sql.*;

public class Cliente {
    //ibamos a comenzar a trabajar los Preparatedstatement
    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS CUENTAS; " +
            " CREATE TABLE CUENTAS (ID INT NOT NULL PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, NUMERO_CUENTA INT NOT NULL, SALDO NUMERIC(10,2) NOT NULL)";
    // EJEMPLO DE NUMERIC = 87654321,23
    private static final String SQL_INSERT="INSERT INTO CUENTAS VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE CUENTAS SET SALDO=? WHERE ID=?";
    private static final String SQL_SELECT="SELECT * FROM CUENTAS";
    private static final Logger logger= Logger.getLogger(Cliente.class);
    public static void main(String[] args) {
        Connection connection= null;
        try{
            connection=getConnection();
            logger.info("conexion exitosa");
            // paso 1 crear la tabla
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            //las consultas parametrizadas;
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,1); //1? primer signo, 2? valor
            psInsert.setString(2,"Sammny");
            psInsert.setInt(3,1234456);
            psInsert.setDouble(4,100);
            psInsert.execute();
            logger.info("saldo  100");
            //ahora debemos sumarle 10 al saldo inicial
            PreparedStatement psUpdate= connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1,100+10);
            psUpdate.setInt(2,1);
            psUpdate.execute(); //<--- aca volvio el rollback
            logger.info("saldo actualizado en 110");
            //ahora nos pide que evaluemos un incremento en el saldo pero que por cuestiones
            //de seguridad pausemos el commit, debido a un error( exception)
            connection.setAutoCommit(false);
            PreparedStatement psUpdateTx= connection.prepareStatement(SQL_UPDATE);
            psUpdateTx.setDouble(1,100+10+15);
            psUpdateTx.setInt(2,1);
            psUpdateTx.execute();
            //int x= 4/0;
            logger.warn("Se cargo erroneamente el saldo actual");
            connection.commit(); //aca confirmamos los cambios
           connection.setAutoCommit(true); //--> siempre es buena practica dejar en true el commit

        }catch (Exception e){
            try{
                connection.rollback();
            }catch (SQLException exe){
                exe.printStackTrace();
            }

        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.getMessage();
            }
        }

    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/C9tx","sa","sa");
    }

}
