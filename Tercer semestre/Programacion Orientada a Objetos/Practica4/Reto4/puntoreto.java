package POO.Practica4.Reto4;

public class puntoreto {
    double x = 0, y = 0;

    public puntoreto() {}

    public puntoreto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "Punto (x = " + x + ", y = " + y + ")\n";
    }
}
