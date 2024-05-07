package presencial;

public class Cliente {
    public static void main(String[] args) {
        ComputadoraFactory fabrica= new ComputadoraFactory();
        Computadora pc1= fabrica.getComputadora(2,128);
        Computadora pc2= fabrica.getComputadora(16,500);
        Computadora pc3= fabrica.getComputadora(2,128);
        Computadora pc4= fabrica.getComputadora(16,500);
        Computadora pc5= fabrica.getComputadora(2,128);
        Computadora pc6= fabrica.getComputadora(16,500);
    }
}
