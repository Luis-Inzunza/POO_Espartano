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

    public boolean Revision() throws FileNotFoundException{
        //analiza los datos si existen o no
        boolean valido1= false;
        boolean valido2= false;
        File archivo = new File("info.csv");
        try (Scanner datos = new Scanner(archivo)) {
            String linea= datos.nextLine();
            for(;datos.hasNextLine();){
                linea = datos.nextLine();
                String[] parte = linea.split(",");
                if(this.expedidor == Integer.parseInt(parte[2])){
                    valido1=true;
                }
                if(this.destinatario == Integer.parseInt(parte[2])){
                    valido2=true;
                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(valido1 && valido2){
            return true;
        }else{
            return false;
        }     
    }

    public void registro(String mensaje) throws FileNotFoundException{
        //genera un registro en transferencia.csv
        File archivo;
        Scanner datos;
        FileWriter escribir;
        PrintWriter linea;
        String renglon;
        String str = "Id_transaccion " + Transaccion.Id_trans + ", Estado: "+ mensaje + ",fecha: "+ this.FechaHora + ", De la cuenta: " + this.expedidor +  " con destino a " + this.destinatario + " por la cantidad de "+ this.saldo;
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