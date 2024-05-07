package presencial;

public class apiProducto {
    public int descuento(Producto producto){
        if(producto.getTipo().equalsIgnoreCase("lata")){
            return 10;
        }else{
            return 0;
        }
    }}
