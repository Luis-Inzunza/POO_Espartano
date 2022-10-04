import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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


    public void registro(String mensaje){
        //genera un registro en transferencia.csv
        String str = "Id_transaccion " + this.Id_trans + ", Estado: "+ mensaje + ",fecha: "+ this.f + ", De la cuenta: " + this.expedidor +  " con destino a " + this.destinatario + " por la cantidad de "+ this.saldo;
        try {
  
            // attach a file to FileWriter
            FileWriter fw
                = new FileWriter("transacciones.csv");
  
            // read each character from string and write
            // into FileWriter
            for (int i = 0; i < str.length(); i++)
                fw.write(str.charAt(i));
  
            System.out.println("Successfully written");
  
            // close the file
            fw.close();
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