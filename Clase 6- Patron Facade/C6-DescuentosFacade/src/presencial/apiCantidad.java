package presencial;

public class apiCantidad {
    public int descuento(int cantidad){
        if(cantidad>11){
            return 15;
        }else{
            return 0;
        }
    }
}
