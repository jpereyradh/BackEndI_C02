package presencial;

public class ManejadorTecnico extends Manejador{
    @Override
    public String comprobar(Mail mail) {
        if(mail.getDestino().equals("tecnico@lacolmena.com")||mail.getAsunto().equalsIgnoreCase("tecnico")){
            System.out.println("En unos instantes lo antenderemos : Dpto Tecnico");
            return "Lo esta atendiendo Tecnico";
        }else{
            System.out.println("mail paso por Dpto tecnico");
            return getSiguienteManejador().comprobar(mail);
        }

    }
}
