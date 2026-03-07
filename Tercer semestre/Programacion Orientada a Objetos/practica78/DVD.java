public class DVD extends Material {

    public DVD(String titulo, String autor, int anio) {
        super(titulo, autor, anio);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("DVD: ");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAnio());
    }
}