package presencial;

import org.apache.log4j.Logger;

import java.sql.*;

public class Cliente {
    private static final Logger logger= Logger.getLogger(Cliente.class);
    public static void main(String[] args) {
        //crear una conexion
        Connection connection= null;
        try{
            connection=getConnection(); //traigo la conexion
            Statement statement= connection.createStatement(); //encargado de llevar el mundo de los objetos a las tablas
            statement.execute("DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES" +
                    "(ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, TIPO VARCHAR(100) NOT NULL)");
            //insertar los 5 animales
            statement.execute("INSERT INTO ANIMALES VALUES(1,'PEDRO','PERRO'), (2,'CHISPAS','CONEJO'),(3,'TITI','GATO')");
            logger.info("Se insertaron 3 animales");
            //MOSTRAR LOS 5 ANIMALES
            ResultSet rs= statement.executeQuery("SELECT * FROM ANIMALES");
            //NECESITO SI O SI RECORRER PARAR VER LOS DATOS
            while(rs.next()){
                System.out.println("Nombre: "+rs.getString(2)+" Tipo: "+rs.getString(3));
            }
            System.out.println("********************************************");
            //como eliminamos un registro?
            statement.execute("DELETE FROM ANIMALES WHERE ID=1");
            logger.warn("advertencia se elimino el registro 1");
            //MOSTRAR LOS 4 ANIMALES
            ResultSet rs1= statement.executeQuery("SELECT * FROM ANIMALES");
            //NECESITO SI O SI RECORRER PARAR VER LOS DATOS
            while(rs1.next()){
                System.out.println("Nombre: "+rs1.getString(2)+" Tipo: "+rs1.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        //insertar 5 animales
        //ver todos los animales
        //eliminar un animal
        //ver los animales
    }
    public static Connection getConnection() throws Exception{
        //ahora debo cargar el driver
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c8Animales","sa","sa");
    }
}
