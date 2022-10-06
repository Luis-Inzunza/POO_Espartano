import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
    static private int Id_trans = 001;
    private int expedidor;
    private int destinatario;
    private int saldo;
    private String FechaHora;

    
    public Transaccion(int depositante, int depositorio, int cantidad){
        this.Id_trans++; 
        this.expedidor = depositante;
        this.destinatario = depositorio;
        this.saldo = cantidad;
        this.FechaHora = fecha();
    }

    public Transaccion(int depositante, int cantidad){
        this.Id_trans++; 
        this.expedidor = depositante;
        this.saldo = cantidad;
        this.FechaHora = fecha();
    }

    public void registro(String mensaje) throws FileNotFoundException{
        //genera un registro en transferencia.csv
        File archivo;
        Scanner datos;
        FileWriter escribir;
        PrintWriter linea;
        String renglon;
        String str = "Id_transaccion " + Transaccion.Id_trans + ", Estado: "+ mensaje + ",fecha y hora: "+ this.FechaHora + ", De la cuenta: " + this.expedidor +  " con destino a " + this.destinatario + " por la cantidad de "+ this.saldo;
        archivo = new File("transacciones.csv");
        datos = new Scanner(archivo);
        try {
            escribir = new FileWriter(archivo);
            linea = new PrintWriter(escribir);
            for(;datos.hasNextLine();){
                renglon= datos.nextLine();
            }
            linea.println(str);
            linea.close();
            escribir.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    private String fecha(){
    LocalDateTime currentDateTime = LocalDateTime.now();  
    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    String a = currentDateTime.format(format2);
    return a;
    }
}