package POO.Practica4;

public class Punto {
    double x = 0, y = 0;

    public Punto() {}

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "Punto (x = " + x + ", y = " + y + ")\n";
    }
}
