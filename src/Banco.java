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
            File archivo = new File("info.csv");
            Scanner datos = new Scanner(archivo);
            int x= 0;
            while (datos.hasNextLine()){
                String linea = datos.nextLine();
                if(linea !=null && x!=0){
                    String[] parte = linea.split(",");
                    //asigno valores por cada datos que tenemos por linea
                    Cliente nuevo = new Cliente(parte[1]); //se usa la parte donde se encuentra el nombre.
                    System.out.println(linea);
                    
                }
                x++;
            }
            datos.close();
        }


        catch(FileNotFoundException e){
            System.out.print("El archivo no fue encontrado");
        }

        return "troleado";
    }
    
}
