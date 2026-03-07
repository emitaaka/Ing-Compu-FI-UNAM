package pruebas.segundoejemplo;

public class Moto extends Vehiculo{
    public Moto(String marca, String modelo){
        super(marca, modelo);
     }

     @Override
     public void arrancar(){
        System.out.println("La moto " + getMarca() + " " +  getModelo() + " hizo run run");
     }
}
