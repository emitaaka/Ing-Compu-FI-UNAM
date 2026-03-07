package POO.practica56.reto;

import java.lang.StringBuilder;
import java.util.ArrayList;

public class SepararNumeros {
        public static void main(String[] args){
        
        String cadena = "a7+7";

        ArrayList<Character> operadores = new ArrayList<Character>();
        ArrayList<Double> numeros = new ArrayList<Double>();
        int inicio = 0, fin = 0, error = 0, cont = 0;
        String textError = "valido";
        boolean positivo = false, negativo = false, signo = false;
        char  primero = cadena.charAt(0), ultimo = cadena.charAt(cadena.length() - 1);

            
        if(primero == 'x' || primero == '/' || ultimo == '+' || ultimo == '-' || ultimo == 'x' || ultimo == '/'){
            textError = "error";
            error = -2;
        }else if(primero == '-'){
            negativo = true;
        }else if(primero == '+'){
            positivo = true;
        }
        if(textError == "valido"){
            for(int i = 0; i < cadena.length(); i++){

                StringBuilder sb = new StringBuilder();
                char c = cadena.charAt(i);
                boolean caracter = false;
                boolean isDigit = (c >= '0' && c <= '9');

                if(c == '+' || c == '-' || c == 'x' || c == '/'){
                    cont++;
                    if(cont > 1){
                        textError = "error";
                        error = -2;
                        break;
                    }else if(operadores.isEmpty() && negativo){
                        inicio = i + 1;
                        signo = true;
                        negativo = false;
                    }else if(operadores.isEmpty() && positivo){
                        inicio = i + 1;
                        positivo = false;
                    }else{
                        fin = i;
                        operadores.add(c);
                        caracter = true;
                    }
                }else{
                    cont = 0;
                }
                if(i == cadena.length() - 1){
                    fin = i + 1;
                    caracter = true;
                }
                if(!isDigit && c != '+' && c != '-' && c != 'x' && c != '/'){
                    textError = "error";
                    error = -2;
                    caracter = false;
                    break;
                }
                if(caracter){
                    for(int j = inicio; j < fin; j++){
                        sb.append(cadena.charAt(j));
                    }
                    if(signo){
                        numeros.add(-Double.parseDouble(sb.toString()));
                        signo = false;
                    }else{
                        numeros.add(Double.parseDouble(sb.toString()));
                    }
                    inicio = fin + 1;
                }
            }
        }
        
        Double res = 0.0;

        if(textError == "valido"){
        
        
            while(!operadores.isEmpty()){
                int temp = -1;
                Double num1, num2;
                for(int i = 0; i < operadores.size(); i++){
                    if(operadores.get(i) == 'x' || operadores.get(i) == '/'){
                        temp = i;
                        break;
                    }
                }
                if(temp == -1){
                    for(int i = 0; i < operadores.size(); i++)
                        if(operadores.get(i) == '+' || operadores.get(i) == '-'){
                            temp = i;
                            break;
                        }
                }
                if(temp == -1)
                    break;

                num1 = numeros.get(temp);
                num2 = numeros.get(temp + 1);

                if(operadores.get(temp) == 'x'){
                    Double resultado = num1 * num2;
                    numeros.set(temp, resultado);
                    numeros.remove(temp + 1);
                    operadores.remove(temp);
                }else if(operadores.get(temp) == '/'){
                    if(num2 != 0){
                        Double resultado = num1 / num2;
                        numeros.set(temp, resultado);
                        numeros.remove(temp + 1);
                        operadores.remove(temp);
                    }else{
                        error = -1;
                        break;
                    }
                }else if(operadores.get(temp) == '+'){
                    Double resultado = num1 + num2;
                    numeros.set(temp, resultado);
                    numeros.remove(temp + 1);
                    operadores.remove(temp);
                }else if(operadores.get(temp) == '-'){
                    Double resultado = num1 - num2;
                    numeros.set(temp, resultado);
                    numeros.remove(temp + 1);
                    operadores.remove(temp);
                }
            }
        }

        if(error == 0){
            res = numeros.get(0);
            System.out.println(res);
            //calc.getResField().setText(res + "");
        }else if( error == -1){
            textError = "Error: No se puede dividir entre cero";
            System.out.println(textError);
            //calc.getResField().setText(textError);
        }else if(error == -2){
            textError = "Error de sintaxis";
            System.out.println(textError);
            //calc.getResField().setText(textError);
        }

    }
}
