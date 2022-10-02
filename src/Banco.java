import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class Banco {
    private String Name;
    private Cliente clientes;
    private int Cuentas;
    
    
    public Banco(){
        this.Name= Datos();
    }

    private String Datos(){
        try {
            File f = new File("info.csv");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()){
                String line = s.nextLine();
                System.out.println(line);
            }
        }


        catch(FileNotFoundException e){
            System.out.print("El archivo no fue encontrado");
        }

        return "troleado";
    }
    
}
