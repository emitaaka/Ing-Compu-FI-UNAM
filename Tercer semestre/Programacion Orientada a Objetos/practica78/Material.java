public abstract class Material {
    private String titulo;
    private String autor;
    private int anio;

    public Material(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public int getAnio() {
        return anio;
    }

    public abstract void mostrarInformacion();
}