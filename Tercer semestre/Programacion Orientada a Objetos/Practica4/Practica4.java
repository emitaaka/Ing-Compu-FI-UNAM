package POO.Practica4;
import java.util.ArrayList;

public class Practica4 {
    public static void main(String[] args){
        int lng = args.length;
        if(lng != 4){
            System.out.println("Se deben de ingresar 4 parámetros");
            return;
        }
        
        ArrayList<Double> x = new ArrayList<Double>(), y = new ArrayList<Double>();
        for(int i = 0; i < lng; i++){
            Double aux = Double.parseDouble(args[i]);
            if(i % 2 == 0)
                x.add(aux);
            else
                y.add(aux);
        }

        Mensaje controlador = new Mensaje();

        Ventana ventana = new Ventana(controlador, x, y);
        ventana.setVisible(true);
    }    
}
