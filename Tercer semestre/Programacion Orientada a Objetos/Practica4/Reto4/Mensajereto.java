package POO.Practica4.Reto4;

import java.util.ArrayList;

public class Mensajereto {
    public String mensaje(ArrayList<Double> x, ArrayList<Double> y){
        double[] hipotenusa;

        hipotenusa = new double[3];
        
        hipotenusa[0] = Math.hypot(x.get(1) - x.get(0), y.get(1) - y.get(0));
        hipotenusa[1] = Math.hypot(x.get(2) - x.get(1), y.get(2) - y.get(1));
        hipotenusa[2] = Math.hypot(x.get(0) - x.get(2), y.get(0) - y.get(2));
        
        StringBuilder distancia = new StringBuilder();

        puntoreto[] punto;
        punto = new puntoreto[3];
        
        for(int i = 0; i < 3; i++){
            punto[i] = new puntoreto(x.get(i), y.get(i));
            distancia.append(punto[i]);
        }
        
        if(hipotenusa[0] == hipotenusa[1] && hipotenusa[1] == hipotenusa[2] && hipotenusa[0] == hipotenusa[2])
            distancia.append("Es equilatero");
        else
            distancia.append("No es equilatero");

        return distancia.toString();
    }
}
