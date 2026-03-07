package POO.Practica4;
import java.util.ArrayList;

public class Mensaje {
    public String mensaje(ArrayList<Double> x, ArrayList<Double> y){
        Double hipotenusa;
        hipotenusa = Math.hypot(x.get(1) - x.get(0), y.get(1) - y.get(0));
        
        StringBuilder distancia = new StringBuilder();

        Punto punto1 = new Punto(x.get(0), y.get(0));
        Punto punto2 = new Punto(x.get(1), y.get(1));

        distancia.append(punto1);
        distancia.append(punto2);
        distancia.append("La distancia entre los dos puntos es: ");
        distancia.append(hipotenusa);

        return distancia.toString();
    }
}
