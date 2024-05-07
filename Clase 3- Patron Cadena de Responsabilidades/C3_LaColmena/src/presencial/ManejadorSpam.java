package presencial;

public class ManejadorSpam extends Manejador{
    @Override
    public String comprobar(Mail mail) {
        return "mail movido a spam";
    }
}
