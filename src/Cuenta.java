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

    public int dar_id(){
        return this.Id_cuenta;
    }

    public int dar_idcliente(){
    return this.Id_cliente;
    }

    public int dar_saldo(){
        return this.saldo;
    }

    public void descontar( int quitar){
        this.saldo= this.saldo - quitar;
    }

    public void Recibir( int sumado){
        this.saldo= this.saldo + sumado;
    }
    
}
