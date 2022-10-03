public class Cliente {
    private String name;
    private Cuenta a;
    private int Id;
    
    public Cliente(String nombre, Cuenta x, int id){
        this.name = nombre;
        this.a = x;
        this.Id = id;
    }
    
    public String toString(){
        return "Nombre: " + name + ", Cuenta( " + a.toString_cliente()+ ")" + ",Id: "+ Id ;
    }
    
    
    /*private int asignateId(){
    int jajas;
    
    jajas=(int)(Math.random()*900 + 100);
    
    
    return jajas;
    }*/
    
    
}