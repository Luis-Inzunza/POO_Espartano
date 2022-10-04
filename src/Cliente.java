public class Cliente {
    private String name;
    private Cuenta propio;
    private int Id;
    
    public Cliente(String nombre, Cuenta x, int id){
        this.name = nombre;
        this.propio = x;
        this.Id = id;
    }
    
    public String toString(){
        return "Nombre: " + name + ", Cuenta( " + propio.toString_cliente()+ ")" + ",Id: "+ Id ;
    }

    public Cuenta dar_cuenta(){
        return this.propio;
    }
    
    public String dar_nombre(){
        return this.name;
    }

    public int dar_id(){
        return this.Id;
    }
    /*private int asignateId(){
    int jajas;
    
    jajas=(int)(Math.random()*900 + 100);
    
    
    return jajas;
    }*/
    
    
}