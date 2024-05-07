package presencial;

public class Computadora {
    private int ram;
    private int discoDuro;
    private static int contador=0;

    public Computadora(int discoDuro, int ram) {
        this.discoDuro = discoDuro;
        this.ram = ram;
        contador++;
        System.out.println(cantidadDeComputadorasCreadas());
    }
    public double cantidadDeComputadorasCreadas(){
        return contador;
    }
}
