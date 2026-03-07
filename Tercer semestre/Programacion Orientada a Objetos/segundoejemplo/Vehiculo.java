package pruebas.segundoejemplo;

public class Vehiculo {
    private String marca, modelo;
    
    public Vehiculo(String marca, String modelo){
        setMarca(marca);
        setModelo(modelo);
    }   

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void arrancar(){
        System.out.println("run run");
    }
}