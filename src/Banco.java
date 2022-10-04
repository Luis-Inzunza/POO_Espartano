import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Banco {
    private String Name;
    private Cliente cliente1;
    private Cliente cliente2;
    private Cliente cliente3;
    private Cliente cliente4;
    private Cliente cliente5;
    private int clientes =4;
    private int cuentas = 4;
    private int transacciones;
    
    
    public Banco(String name) throws FileNotFoundException{
        this.Name= name;
        this.cliente1 = Datos(1);
        this.cliente2 = Datos(2);
        this.cliente3 = Datos(3);
        this.cliente4 = Datos(4);
        this.cliente5 = Datos(5);
        this.transacciones= Trans();
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

    //Metodos de prueba de transacciones
    public void Accion(int depositante, int depositorio, int cantidad , String tipo) throws FileNotFoundException{
        Transaccion a = new Transaccion(depositante,depositorio,cantidad);
        boolean saldo_suficiente= false;
        if(a.Revision()){
            if(tipo == "transferencia"){
                saldo_suficiente = realiza_transaccion(depositante,depositorio,cantidad);
            }
            if(tipo == "deposito"){
                saldo_suficiente = realiza_deposito(depositante,cantidad);
            }
            if(tipo == "retiro"){
                saldo_suficiente = realiza_retiro(depositante,cantidad);
            }
            if(saldo_suficiente){
                a.registro("exitoso");
                System.out.println("Accion " + tipo + " termino exitoso");
            }else{
                a.registro("Sin saldo");
                System.out.println("Accion " + tipo + " termino fracasando");
            }
        }else{
            a.registro("Una cuenta no encontrada");
            System.out.println("Accion " + tipo + " termino fracasando");
        }
    }
    
    private boolean realiza_transaccion(int depositante, int depositorio, int cantidad) throws FileNotFoundException{
        //realiza la transferencia
        Cliente Dara = buscarCuentas(depositante);
        Cliente Recibe = buscarCuentas(depositorio);
        boolean paso = false;

        if(Dara.dar_cuenta().dar_saldo() >= cantidad){
            Dara.dar_cuenta().descontar(cantidad);
            Recibe.dar_cuenta().Recibir(cantidad);
            paso = true;
        }

        return paso;
        
    }

    private boolean realiza_retiro(int Retirante, int cantidad) throws FileNotFoundException{
        Cliente Retirara = buscarCuentas(Retirante);
        boolean paso = false;

        if(Retirara.dar_cuenta().dar_saldo() >= cantidad){
            Retirara.dar_cuenta().descontar(cantidad);
            paso = true;
        }

        return paso;
        
    }

    private boolean realiza_deposito(int depositante, int cantidad) throws FileNotFoundException{
        //realiza la transferencia
        Cliente Dar = buscarCuentas(depositante);
        boolean paso = true;
        Dar.dar_cuenta().Recibir(cantidad);

        return paso;
        
    }

    private Cliente buscarCuentas(int a){
        Cliente guardar = null;
        if(cliente1.dar_cuenta().dar_id() == a ){
            guardar = cliente1;
        }
        if(cliente2.dar_cuenta().dar_id() == a ){
            guardar = cliente2;
        }
        if(cliente3.dar_cuenta().dar_id() == a ){
            guardar = cliente3;
        }
        if(cliente4.dar_cuenta().dar_id() == a ){
            guardar = cliente4;
        }
        if(cliente5.dar_cuenta().dar_id() == a ){
            guardar = cliente5;
        }

        return guardar;

    }

    public String toString(){
        return "El Banco " + this.Name + " Tiene un total de " + this.clientes + " clientes, con cuentas " + this.cuentas +" en total y un registro de " + this.transacciones + " trancacciones en total";
    }

    public String toString_Especifico(){

        return toString() + "\n" + "Especificamente estos clientes" + "\n"  + cliente1.toString() + "\n" + cliente2.toString() + "\n" + cliente3.toString() + "\n" + cliente4.toString() + "\n" + cliente5.toString() + "\n";
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