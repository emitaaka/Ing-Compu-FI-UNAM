package POO.practica56.reto;

import java.lang.StringBuilder;
import javax.swing.*;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class MainCalc {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaCalc calculadora = new VistaCalc("Mi Calculadora");

            JButton[] botonesNumeros = calculadora.getNumerosButton();
            JButton[] botonesOperaciones = calculadora.getOpeButton();

            botones(calculadora, botonesNumeros);
            botones(calculadora, botonesOperaciones);
            
            calculadora.getLimpiarButton().addActionListener(e ->{
                calculadora.getResField().setText("");
            });
            calculadora.getIgualButton().addActionListener(e ->{
                separarNumerosYSignos(calculadora, calculadora.getResField().getText());
            });
            calculadora.setVisible(true);
        });
    }

    //Agrega el numero apretado a la pantalla
    private static void mostrar(VistaCalc calculadora, String texto){ 
        //Añade texto a la pantalla
        String textoActual = calculadora.getResField().getText();
        calculadora.getResField().setText(textoActual + texto);
    }

    //Le asigna a cada boton su caracter
    private static void botones(VistaCalc calculadora, JButton[] boton){
        for(JButton botonActual : boton){
            botonActual.addActionListener(e ->{
                //Limpia la pantalla después de mostrar un error
                if(calculadora.getResField().getText().equals("Error de sintaxis") || calculadora.getResField().getText().equals("Error: No se puede dividir entre cero")){
                    calculadora.getResField().setText("");
                }
                mostrar(calculadora, botonActual.getText());
            });
        }
    }
    //Hace toda la lógica del botón igual
    private static void separarNumerosYSignos(VistaCalc calc, String cadena){

        //Declaración de variables y estrucutras de datos
        ArrayList<Character> operadores = new ArrayList<Character>();
        ArrayList<Double> numeros = new ArrayList<Double>();
        int inicio = 0, fin = 0, error = 0, cont = 0;
        String textError = "valido";
        boolean positivo = false, negativo = false, signo = false;
        char  primero = cadena.charAt(0), ultimo = cadena.charAt(cadena.length() - 1);
            
        //Valida que el primer caracter de la pantalla no sea un operador
        if(primero == 'x' || primero == '/' || ultimo == '+' || ultimo == '-' || ultimo == 'x' || ultimo == '/'){
            textError = "error";
            error = -2;
        }
        //Si el primer caracter es + o - cambia el valor de su respectivo booleano
        else if(primero == '-'){
            negativo = true;
        }else if(primero == '+'){
            positivo = true;
        }

        //Si no hubo un error en el if else anterior, comienza a revisar la cadena caracter por caracter para separar los numeros de los operadores
        if(textError == "valido"){
            for(int i = 0; i < cadena.length(); i++){

                StringBuilder sb = new StringBuilder();
                boolean caracter = false;
                char c = cadena.charAt(i);
                boolean isDigit = (c >= '0' && c <= '9');

                //Cada que encuentra un operador guarda el valor de inicio y final del numero que hay antes de este
                if(c == '+' || c == '-' || c == 'x' || c == '/'){
                    cont++;
                    if(cont > 1){
                        //Si encuentra 2 caracteres seguidos marca un error y rompe el for
                        textError = "error";
                        error = -2;
                        break;
                    }else if(operadores.isEmpty() && negativo){
                        //Si el primer caracter es un signo de menos, cambia la variable signo a true para que más adelante el número se guarde como negativo
                        inicio = i + 1;
                        signo = true;
                        negativo = false;
                    }else if(operadores.isEmpty() && positivo){
                        //Si el primer caracter es un signo de más, se le suma uno a inicio para que no provoque un error el momento de guardar el stringbuilder en el arraylist de numeros
                        inicio = i + 1;
                        positivo = false;
                    }else{
                        fin = i;
                        //guarda el operador en el arraylist de operadores
                        operadores.add(c);
                        caracter = true;
                    }
                }else{
                    cont = 0;
                }
                //Este if es por si ya no encuentra operadores, guarda desde el ulitmo operador hasta el final de la cadena
                if(i == cadena.length() - 1){
                    fin = i + 1;
                    caracter = true;
                }

                //Valida que el usuario no haya metido un caracter que no sea un número o un operador
                if(!isDigit && c != '+' && c != '-' && c != 'x' && c != '/'){
                    textError = "error";
                    error = -2;
                    caracter = false;
                    break;
                }

                //Una vez que se encuentra un operador, el numero se guarda caracter por caracter en un stringbuilder y luego se convierte en double para guardarlo en el arraylist de numeros
                if(caracter){
                    for(int j = inicio; j < fin; j++){
                        sb.append(cadena.charAt(j));
                    }
                    if(signo){
                        //Por si el primer numero es negativo
                        numeros.add(-Double.parseDouble(sb.toString()));
                        signo = false;
                    }else{
                        //Agrega el numero construido en el stringbuilder al arraylist
                        numeros.add(Double.parseDouble(sb.toString()));
                    }

                    //Se le suma uno porque fin es el índice de donde está el operador
                    inicio = fin + 1;
                }
            }
        }
        
        //Variable donde se va a guardar el resultado final
        Double res = 0.0;

        //Si hasta el momento no ha habido ningún error, entrará en el if
        if(textError == "valido"){
        
            //Va a repetir este bloque de código hasta que ya queden operadores en el arraylist
            while(!operadores.isEmpty()){

                //Bandera para encontrar los oepradores
                int temp = -1;
                Double num1, num2;
                
                //Si encuentra un producto o una divisón, cambia el valor de la bandera por el indice del operador
                for(int i = 0; i < operadores.size(); i++){
                    if(operadores.get(i) == 'x' || operadores.get(i) == '/'){
                        temp = i;
                        break;
                    }
                }

                //Si no encontró un producto o una divisón, busca alguna suma o resta y cambia el valor de la bandera
                if(temp == -1){
                    for(int i = 0; i < operadores.size(); i++)
                        if(operadores.get(i) == '+' || operadores.get(i) == '-'){
                            temp = i;
                            break;
                        }
                }

                //Si no encuentra nada, rompe el while 
                if(temp == -1)
                    break;

                //Asigna valores a las varibles que se usarán en la operación
                num1 = numeros.get(temp);
                num2 = numeros.get(temp + 1);

                //Hace la recpectiva operación que encontró en los for anteriores, elimina y reemplaza los números del arraylist por los nuevos valores
                if(operadores.get(temp) == 'x'){
                    //Hace la operación
                    Double resultado = num1 * num2;
                    //Reemplaza el que es el valor de num1 por el nuevo resultado
                    numeros.set(temp, resultado);
                    //Elimina el que es num2
                    numeros.remove(temp + 1);
                    //Elimina el operador recién usado
                    operadores.remove(temp);
                }else if(operadores.get(temp) == '/'){
                    //Valida que el denominador no sea 0
                    if(num2 != 0){
                        Double resultado = num1 / num2;
                        numeros.set(temp, resultado);
                        numeros.remove(temp + 1);
                        operadores.remove(temp);
                    }else{
                        //Si es 0, marca un error
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

        //Si la bandera de error no cambia de valor, imprime el resultado de la operación
        if(error == 0){
            res = numeros.get(0);
            calc.getResField().setText(res + "");
        }else if( error == -1){
            //Si encontró algún error, lo imprime
            textError = "Error: No se puede dividir entre cero";
            calc.getResField().setText(textError);
        }else if(error == -2){
            textError = "Error de sintaxis";
            calc.getResField().setText(textError);
        }


    }
}