package POO.practica56.reto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class VistaCalc extends JFrame{
    private final JTextField resField;
    private final JButton[] numerosButton;
    private final JButton[] opeButton;
    private final JButton igualButton;
    private final JButton limpiarButton;

    public VistaCalc(String titulo){
        super(titulo);
    
        numerosButton = new JButton[10];
        opeButton = new JButton[4];
        for(int i = 0; i < 10; i ++)
            numerosButton[i] = new JButton("" + i);
        opeButton[0] = new JButton("+");
        opeButton[1] = new JButton("-");
        opeButton[2] = new JButton("x");
        opeButton[3] = new JButton("/");
        igualButton = new JButton("=");
        limpiarButton = new JButton("ac");

        resField = new JTextField("");
        resField.setEditable(true);
        resField.setHorizontalAlignment(JTextField.LEFT);
        resField.setFont(resField.getFont().deriveFont(24f));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 420));
        setLayout(new BorderLayout(10, 10));

        JPanel resultado = new JPanel(new GridLayout(2, 0, 8, 8));
        resultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        resultado.add(resField, BorderLayout.CENTER);

        JPanel acciones = new JPanel(new GridLayout(4, 4, 8, 8));
        acciones.add(numerosButton[7]);
        acciones.add(numerosButton[8]);
        acciones.add(numerosButton[9]);
        acciones.add(opeButton[0]);
        acciones.add(numerosButton[4]);
        acciones.add(numerosButton[5]);
        acciones.add(numerosButton[6]);
        acciones.add(opeButton[1]);
        acciones.add(numerosButton[1]);
        acciones.add(numerosButton[2]);
        acciones.add(numerosButton[3]);
        acciones.add(opeButton[2]);
        acciones.add(limpiarButton);
        acciones.add(numerosButton[0]);
        acciones.add(igualButton);
        acciones.add(opeButton[3]);

        JPanel mostrar = new JPanel(new BorderLayout(8, 8));
        mostrar.add(resultado, BorderLayout.NORTH);
        mostrar.add(acciones, BorderLayout.CENTER);
        
        add(mostrar, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public JTextField getResField() { return resField; }
    public JButton[] getNumerosButton() { return numerosButton; }
    public JButton[] getOpeButton() { return opeButton; }
    public JButton getIgualButton(){ return igualButton; }
    public JButton getLimpiarButton() { return limpiarButton; }
}
