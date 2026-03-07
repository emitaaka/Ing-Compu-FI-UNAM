package mx.unam.fi.poo.py2;

public abstract class Empleado {
    private final String nombre, apellido;
    private final String numSeguro;

    public Empleado(String nombre, String apellido, String numSeguro){ 
        this.nombre = nombre;
        this.apellido = apellido;
        this.numSeguro = numSeguro;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public String getSeguro(){ 
        return this.numSeguro;
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nNumero de seguro social: " + this.numSeguro;
    }

    public abstract Double ingresos();
}