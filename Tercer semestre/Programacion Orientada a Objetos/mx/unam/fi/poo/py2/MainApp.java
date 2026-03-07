package mx.unam.fi.poo.py2;

public class MainApp {
    public static void main(String[] args){
        Empleado empleado1 = new EmpleadoAsalariado("Manchego", "Rivas", "1606", 100.0);
        System.out.println(empleado1);
        System.out.println("Ingresos: $" + empleado1.ingresos() + "\n");

        Empleado empleado2 = new EmpleadoAsalariado("Luis", "Zarate", "2222", 950.0);
        System.out.println(empleado2);
        System.out.println("Ingresos: $" + empleado2.ingresos() + "\n");

        Empleado empleado3 = new EmpleadoPorHoras("Adrian", "Mendieta", "3333", 777.75, 2.0);
        System.out.println(empleado3);
        System.out.println("Ingresos: $" + empleado3.ingresos() + "\n");

        Empleado empleado4 = new EmpleadoPorHoras("Eduardo", "Cuevas", "4444", 15.0, 60.0);
        System.out.println(empleado4);
        System.out.println("Ingresos: $" + empleado4.ingresos() + "\n");
    } 
}