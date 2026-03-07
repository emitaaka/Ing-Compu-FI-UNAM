public class Revista extends Material {

    public Revista(String titulo, String autor, int anio) {
        super(titulo, autor, anio);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("REVISTA: ");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAnio());
    }
}