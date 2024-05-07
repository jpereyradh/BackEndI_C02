package presencial;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private Map<String,Computadora> computadoraMap;
    private int contadorNoCreado=0;

    public ComputadoraFactory() {
        computadoraMap= new HashMap<>();
    }
    public Computadora getComputadora(int ram, int discoDuro){
        //definir una clave
        //verificar que existe
        //crear en el caso de no existir el objeto
        String clave="K:"+ram+discoDuro;
        if(!computadoraMap.containsKey(clave)){
           computadoraMap.put(clave,new Computadora(ram,discoDuro));

            System.out.println("Computadora creada con exito"+clave);
        }
        contadorNoCreado++;
        System.out.println("Re utilizadas: "+contadorNoCreado);
        return computadoraMap.get(clave);
    }
}
