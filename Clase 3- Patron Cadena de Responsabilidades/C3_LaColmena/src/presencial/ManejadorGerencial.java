package presencial;

public class ManejadorGerencial extends Manejador{
    @Override
    public String comprobar(Mail mail) {
        if(mail.getDestino().equals("gerencial@lacolmena.com")||mail.getAsunto().equalsIgnoreCase("gerencial")){
            System.out.println("En unos instantes lo antenderemos : Dpto Gerencial");
            return "Lo esta atendiendo Gerencial";
        }else{
            System.out.println("mail paso por Dpto gerencial");
            return getSiguienteManejador().comprobar(mail);
        }
    }
}
