package presencial;

public class FacadeTest {
    public static void main(String[] args) {
        Producto producto= new Producto("yerba","lata");
        Tarjeta tarjeta= new Tarjeta("star bank",1111111);
        int cantidad= 12;
        FacadeDescuento fachada= new FacadeDescuento();
      int descuento=  fachada.descuentos(tarjeta,producto,cantidad);
        System.out.println("Suma de descuentos: "+descuento);
    }
}
