package presencial;

public class apiTarjeta {
    public int descuento(Tarjeta tarjeta) {
        if (tarjeta.getBanco().equalsIgnoreCase("star bank")) {
            return 20;
        } else {
            return 0;
        }
    }
}
