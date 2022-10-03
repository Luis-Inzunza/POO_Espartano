import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Banco {
    private String Name;
    private Cliente cliente1;
    private Cliente cliente2;
    private Cliente cliente3;
    private Cliente cliente4;
    private int clientes =4;
    
    
    public Banco(String name) throws FileNotFoundException{
        this.Name= name;
        this.cliente1 = Datos(1);
        this.cliente1 = Datos(2);
        this.cliente1 = Datos(3);
        this.cliente1 = Datos(4);
    }

    private Cliente Datos(int x) throws FileNotFoundException{
        Cliente nuevo;
        File archivo = new File("info.csv");
        Scanner datos = new Scanner(archivo);
        String linea= datos.nextLine();
        for(;x!=0 && datos.hasNextLine();x--){
            linea = datos.nextLine();
        }
        String[] parte = linea.split(",");
        //asigno valores por cada datos que tenemos por linea
        nuevo = new Cliente(parte[1],new Cuenta (Integer.parseInt(parte[0]),Integer.parseInt(parte[3]),Integer.parseInt(parte[3])),Integer.parseInt(parte[2])); //se usa la parte donde se encuentra el nombre.
        System.out.println(nuevo.name);
        datos.close();
        return nuevo;

    }// cierre de Datos
    
}// fin de clase



//for (basado en;condicion;lo que pasa si se cumple)


/*

            while (datos.hasNextLine()){
                String linea = datos.nextLine();
                if(linea !=null && x!=0){
                    String[] parte = linea.split(",");
                    //asigno valores por cada datos que tenemos por linea
                    Cliente ("cliente" + Integer.toString(x)) = new Cliente(parte[1],new Cuenta (Integer.parseInt(parte[0]),Integer.parseInt(parte[3]),Integer.parseInt(parte[3])),Integer.parseInt(parte[2])); //se usa la parte donde se encuentra el nombre.
                    System.out.println(linea);
                }
                x++;
            }


 */