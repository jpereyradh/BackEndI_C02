package presencial;

public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(Integer edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public boolean esMayorEdad(){
        return this.edad>=18; //por default true
    }
    public boolean checkEdad(){
        boolean respuesta= false;
        if(edad>0&&edad<=120){
            respuesta=true;
        }return respuesta;
    }
    public boolean cantidadDeLetras(){
        return nombre.length()>4;
    }
    public boolean checkAZ(){
        boolean respuesta= false;
        char[] array= nombre.toCharArray();
        for (char letra : array) {
            if(!Character.isLetter(letra)){
                return respuesta;
            }
        }
        respuesta= true;
        return respuesta;
    }
}
