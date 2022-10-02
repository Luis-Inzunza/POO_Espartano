import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
    private int Id_trans;
    private int saldo;
    private String tipo;
    private String f;
    
    public Transaccion(int x, String y, int z){
        this.Id_trans = x;
        this.tipo = y; // "retiro" "deposito" "transferencia"
        this.saldo = z;
    }
    
    private String fecha(){
    LocalDateTime currentDateTime = LocalDateTime.now();  
    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    String a = currentDateTime.format(format2);
    return a;

    }
    
    private int realizar_transaccion(){
        this.f = fecha();
        return 1;
    }
    
}
