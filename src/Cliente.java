public class Cliente {
    private String name;
    private Cuenta a;
    private int Id;
    
    public Cliente(String nombre){
        this.name = nombre;
        this.Id = asignateId(); 
    }
    
    private int asignateId(){
    int jajas;
    
    jajas=(int)(Math.random()*900 + 100);
    
    
    return jajas;
    }
    
    
}