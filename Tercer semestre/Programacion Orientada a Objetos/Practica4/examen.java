package POO.Practica4;

public class examen {
    public static void main(String[] args){
            int a = 20, b = 20, c = 30, r = 25;
            a = (b < c)?(b + c):(b - c);
            r = (a < b)?(b + c):(a + b);
            System.out.println(r);
    }
}
