public class Main {
    public static void main(String[] args) throws Exception {
        Banco Mazapan = new Banco("Mazapan");

        System.out.println(Mazapan.toString());
        System.out.println(Mazapan.toString_Especifico());

        //Por el momento no hay ningun metodo de seguridad
        Mazapan.Accion(233,345,1000,"deposito");
        Mazapan.Accion(909,234,1000,"retiro");
        Mazapan.Accion(909,234,1000,"transferencia");
    }
}