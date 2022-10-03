public class Main {
    public static void main(String[] args) throws Exception {
        Banco Mazapan = new Banco("Mazapan");

        System.out.println(Mazapan.toString());
        System.out.println(Mazapan.toString_Especifico());

        //Por el momento no hay ningun metodo de seguridad
        Mazapan.deposito(909,234,1000);
        Mazapan.retiro(909,234,1000);
        Mazapan.transferencia(909,234,1000);

    }
}