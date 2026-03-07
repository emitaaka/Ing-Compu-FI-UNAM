package pruebas.segundoejemplo;

public class Main {
    public static void main(String[] args) {
        Vehiculo generico = new Vehiculo("Generico", "2020");
        Vehiculo coche = new Coche("Toyota", "Corolla");
        Vehiculo motomoto = new Moto("Honda", "CBR");

        generico.arrancar();
        coche.arrancar();
        motomoto.arrancar();
    }
}
