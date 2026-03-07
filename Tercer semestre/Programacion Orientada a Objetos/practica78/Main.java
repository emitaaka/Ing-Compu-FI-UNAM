public class Main {
    public static void main(String[] args) {
        Material m1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
        Material m2 = new Revista("National Geographic", "Varios", 2024);
        Material m3 = new DVD("Inception", "Christopher Nolan", 2010);
        

        m1.mostrarInformacion();
        System.out.println();
        m2.mostrarInformacion();
        System.out.println();
        m3.mostrarInformacion();
    }
}