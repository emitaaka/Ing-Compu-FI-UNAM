package POO.Practica4;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ventana extends JFrame{
    JButton boton;
    Mensaje controlador;

    public Ventana(Mensaje controlador, ArrayList<Double> x, ArrayList<Double> y){
        this.controlador = controlador;

        setTitle("Distancia entre dos puntos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        boton = new JButton("Haz click para ver la distancia entre los puntos");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String mensaje = controlador.mensaje(x, y);
                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        add(boton);
    }
}
