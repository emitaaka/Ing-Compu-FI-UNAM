package pruebas.segundoejemplo;

public class Coche extends Vehiculo{
     public Coche(String marca, String modelo){
        super(marca, modelo);
     }

     @Override
     public void arrancar(){
        System.out.println("El coche " + getMarca() + " " +  getModelo() + " hizo run run");
     }
}
