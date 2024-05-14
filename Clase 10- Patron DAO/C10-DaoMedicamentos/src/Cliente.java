import dao.BD;
import model.Medicamento;
import service.MedicamentoService;

public class Cliente {
    public static void main(String[] args) {
        //cual es el primer paso?
        BD.crearTablas();
        //Ahora creo el medicamento
        Medicamento medicamento= new Medicamento(1,1234,"Ibuprofeno","Bago",10,100.0);
        //quien debe guardar el medicamento?
        MedicamentoService medicamentoService= new MedicamentoService();
        ///ahora que tenemos el service?
        medicamentoService.guardarMedicamento(medicamento);


        //orden de sucesos

        /*
        * 1 service
        * 2 dao correspondiente
        *3 bd
        * 4 entity o model
        *  */
    }
}
