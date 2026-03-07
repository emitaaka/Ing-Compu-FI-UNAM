public class FormulaGeneral {
    public static void main(String[] args){
        if(args.length != 3){
            System.out.println("Error: Se requieren exactamente 3 argumentos.");
            return;
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        
        if(a == 0){
            System.out.println("Error el coeficiente 'a' no puede ser cero");
            return;
        }
        System.out.println("Resolviendo la ecuación: " + formatearEcuacion(a, b, c));
        double discriminante = b * b - 4 * a * c;
        if(discriminante >= 0){
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }else
            System.out.println("las raíces del polinomio son complejas");
    }
    private static String formatearEcuacion(double a, double b, double c){
        StringBuilder ecuacion = new StringBuilder();

        if(a == 1)
            ecuacion.append("x^2");
        else if(a == -1)
            ecuacion.append("-x^2");
        else
            ecuacion.append(a).append("x^2");
        
        if(b > 0){
            if(b == 1)
                ecuacion.append(" + x");
            else
                ecuacion.append(" + ").append(b).append("x");
        }else if(b < 0){
            if(b == -1)
                ecuacion.append(" - x");
            else
                ecuacion.append(" - ").append(-b).append("x");
        }
        if(c > 0)
            ecuacion.append(" + ").append(c);
        else if(c < 0)
            ecuacion.append(" - ").append(-c);
        ecuacion.append(" = 0");
        return ecuacion.toString();
    }
}