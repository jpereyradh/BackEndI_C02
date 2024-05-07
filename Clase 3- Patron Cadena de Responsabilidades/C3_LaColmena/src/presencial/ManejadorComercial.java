package presencial;

public class ManejadorComercial extends Manejador{
    @Override
    public String comprobar(Mail mail) {
        if(mail.getDestino().equals("comercial@lacolmena.com")||mail.getAsunto().equalsIgnoreCase("Comercial")){
            System.out.println("En unos instantes lo antenderemos : Dpto Comercial");
            return "Lo esta atendiendo Comercial";
        }else{
            System.out.println("mail paso por Dpto Comercial");
            return getSiguienteManejador().comprobar(mail);
        }    }
}
