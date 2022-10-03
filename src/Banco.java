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
    private int cuentas = 4;
    private int transacciones = Trans();
    
    
    public Banco(String name) throws FileNotFoundException{
        this.Name= name;
        this.cliente1 = Datos(1);
        this.cliente2 = Datos(2);
        this.cliente3 = Datos(3);
        this.cliente4 = Datos(4);
    }

    private Cliente Datos(int no_cliente) throws FileNotFoundException{
        Cliente nuevo;
        File archivo = new File("info.csv");
        Scanner datos = new Scanner(archivo);
        String linea= datos.nextLine();
        for(;no_cliente!=0 && datos.hasNextLine();no_cliente--){
            linea = datos.nextLine();
        }
        String[] parte = linea.split(",");
        //asigno valores por cada datos que tenemos por linea
        nuevo = new Cliente(parte[0],new Cuenta (Integer.parseInt(parte[2]),Integer.parseInt(parte[1]),Integer.parseInt(parte[3])),Integer.parseInt(parte[1])); //se usa la parte donde se encuentra el nombre.
        // imprimir los valores para ver si la asignacion fue correcta
        //System.out.println(nuevo.toString()); 
        datos.close();
        return nuevo;

    }// cierre de Datos

    private int Trans() throws FileNotFoundException{
        // leer cada linea para hacer un conteo de cuantas transacciones  tiene el banco registrado
        File archivo = new File("transacciones.csv");
        Scanner datos = new Scanner(archivo);
        int x=0;
        while (datos.hasNextLine()){
            datos.nextLine();
            x++;
        }
        datos.close();
        return x;
    }

    public String toString(){
        return "El Banco " + this.Name + " Tiene un total de " + this.clientes + " clientes, con cuentas " + this.cuentas +" en total y un registro de " + this.transacciones + " trancacciones en total";
    }

    public String toString_Especifico(){

        return toString() + "\n" + "Especificamente estos clientes" + "\n"  + cliente1.toString() + "\n" + cliente2.toString() + "\n" + cliente3.toString() + "\n" + cliente4.toString() + "\n";
    }
    
}// fin de clase


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