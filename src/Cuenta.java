public class Cuenta {
    private int Id_cuenta;
    private int Id_cliente;
    private int saldo;
    
    public Cuenta(int Id, int idcliente, int saldo){
        this.Id_cliente = idcliente;
        this.Id_cuenta = Id;
        this.saldo = saldo;
    }

    public String toString_cliente(){
        return "Id de cuenta: " + Id_cuenta +  ",Saldo: "+ saldo;
    }

    public String toString(){
        return "Id de cuenta: " + Id_cuenta +  ",Saldo: "+ saldo + ", Id cliente: " + Id_cliente ;
    }
    
}
