public class Libro extends Material {

    public Libro(String titulo, String autor, int anio) {
        super(titulo, autor, anio);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("LIBRO:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAnio());
    }
}
