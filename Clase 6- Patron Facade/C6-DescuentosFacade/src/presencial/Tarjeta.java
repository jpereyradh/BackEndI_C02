package presencial;

public class Tarjeta {
    private int numero;
    private String banco;

    public Tarjeta(String banco, int numero) {
        this.banco = banco;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getBanco() {
        return banco;
    }
}
