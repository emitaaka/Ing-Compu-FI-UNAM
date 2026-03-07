package POO.practica56;

public class Articulo {
    private String nombre;
    private double precio;

    public Articulo(String nombre, double precio) {
    
        setNombre(nombre);
        setPrecio(precio);
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if(nombre!=null){
            this.nombre=nombre;
        }
        else{
            this.nombre="Sin nombre";
        }
    }
    

    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        if(precio>=0){
            this.precio=precio;
        }
        else{
            this.precio=0.0;
        }
    }
    public String toItemString() {
        long cents = Math.round(precio * 100);
        String entero = String.valueOf(cents/100);
        int dec = (int)(cents % 100);
        String decStr = dec < 10 ? ("0" + dec) : String.valueOf(dec);
        return nombre + " - $" + entero + "." + decStr;
    }
}   