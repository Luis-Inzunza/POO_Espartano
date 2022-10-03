import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
    static private int Id_trans = 001;
    private int expedidor;
    private int destinatario;
    private int saldo;
    private String f;

    
    public Transaccion(int depositante, int depositorio, int cantidad){
        this.Id_trans++; 
        this.expedidor = depositante;
        this.destinatario = depositorio;
        this.saldo = cantidad;
        this.f = fecha();
    }

    public boolean Revision(){
        //analiza los datos si existen o no

        return true;
    }

    public void realiza_trans(){
        //realiza la transferencia
        
    }

    public void registro(boolean  validacion){
        //genera un registro en transferencia.csv

    }


    private String fecha(){
    LocalDateTime currentDateTime = LocalDateTime.now();  
    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    String a = currentDateTime.format(format2);
    return a;
    }
    
}
