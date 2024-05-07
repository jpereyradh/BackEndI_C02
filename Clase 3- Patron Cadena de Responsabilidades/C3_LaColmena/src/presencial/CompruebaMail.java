package presencial;

public class CompruebaMail {
    private Manejador inicial;

    public CompruebaMail() {
        //estos son los eslabones de mi cadena de responsabilidades
        inicial= new ManejadorComercial();
        Manejador tecnico= new ManejadorTecnico();
        Manejador gerencial= new ManejadorGerencial();
        Manejador spam= new ManejadorSpam();
        //unificar los eslabones formando la cadena de responsabilidad
        inicial.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(gerencial);
        gerencial.setSiguienteManejador(spam);
                    }

        public String disparadorcadena(Mail mail){
        return inicial.comprobar(mail);
        }
}
