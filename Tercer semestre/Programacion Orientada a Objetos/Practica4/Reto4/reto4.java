package POO.Practica4.Reto4;

import java.util.ArrayList;

public class reto4 {
    public static void main(String[] args){
        int lng = args.length;
        if(lng != 6){
            System.out.println("Se deben de ingresar 6 argumentos");
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

        Mensajereto controlador = new Mensajereto();

        Ventanareto ventana = new Ventanareto(controlador, x, y);
        ventana.setVisible(true);
    }   
} 
