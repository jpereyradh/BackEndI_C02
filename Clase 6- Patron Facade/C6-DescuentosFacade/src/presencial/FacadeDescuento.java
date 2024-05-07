package presencial;

public class FacadeDescuento implements iFacade{
    //una relacion de asociacion con las demas api
    private apiCantidad apiCantidad;
    private apiProducto apiProducto;
    private apiTarjeta apiTarjeta;

    public FacadeDescuento() {
        apiCantidad= new apiCantidad();
        apiTarjeta= new apiTarjeta();
        apiProducto = new apiProducto();
    }
    @Override
    public int descuentos(Tarjeta tarjeta, Producto producto, int cantidad) {
        int descuento=0;
        descuento= descuento+apiTarjeta.descuento(tarjeta);
        descuento= descuento+ apiCantidad.descuento(cantidad);
        descuento= descuento+ apiProducto.descuento(producto);
        return descuento;
    }
}
