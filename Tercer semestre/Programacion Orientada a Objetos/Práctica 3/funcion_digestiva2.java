import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class funcion_digestiva2 {
    public static void main(String[] args) {
        // Opcional: mal uso de argumentos en la entrada indicar uso correcto

        // Definir objeto ArrayList
        ArrayList<String> argumentos = new ArrayList<String>();
        
        // Definir objeto HashMap
        HashMap<String, String> smll = new HashMap<String, String>();

        // Recorrido sobre ArrayList para agregar las entradas
        for(int i = 0; i < args.length; i++)
            argumentos.add(args[i]);

        // Mandamos las entradas a la función digestiva
        // Mandamos al HashMap las entradas donde las llaves van asociadas a cada entrada
        for(int i = 0; i < args.length; i++){
            String valor;
            valor = generaHash(argumentos.get(i));
            smll.put(argumentos.get(i), valor);
        }
        
        // Presentamos resultados con base en el HashMap
        for (String i : smll.keySet())
        System.out.println("Palabra original: " + i + "\nDespués del método: " + smll.get(i));
    }

    public static String generaHash(String texto) {
        // Variable para crear semilla a partir de la suma de los caracteres
        int semilla = 0;
        for (char c : texto.toCharArray()) {
            semilla += c;
        }

        Random random = new Random(semilla);

        //Para generar 32 caracteres hexadecimales (investigar a quien se parece)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int valor = random.nextInt(16); //0 - 15
            sb.append(Integer.toHexString(valor));
        }

        return sb.toString();
    }
}