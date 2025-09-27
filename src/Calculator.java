import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase Calculator
 * Implementa una calculadora gráfica con operaciones básicas (+, -, *, /)
 * utilizando Swing en Java.
 */
public class Calculator {
    // Componentes de la interfaz gráfica
    private JPanel Calculator;    // Panel principal
    private JTextField txtDisplay; // Pantalla de la calculadora (entrada/salida de números)

    // Botones
    private JButton ACButton, button2, button3, XXButton, button5, button6;
    private JButton a7Button, a4Button, a1Button, a00Button;
    private JButton button11, a8Button, a5Button, a2Button, a0Button;
    private JButton button16, a9Button, a6Button, a3Button, button20;

    // Variables de operación
    double a, b, result;
    String operator;

    /**
     * Métodos (funciones) para operaciones matemáticas
     */
    private double sumar(double x, double y) { return x + y; }
    private double restar(double x, double y) { return x - y; }
    private double multiplicar(double x, double y) { return x * y; }
    private double dividir(double x, double y) {
        if (y == 0) {
            JOptionPane.showMessageDialog(null, "Error: no se puede dividir entre 0");
            return 0;
        }
        return x / y;
    }

    /**
     * Métodos auxiliares
     */
    private void limpiarPantalla() { txtDisplay.setText(""); }

    private void borrarUltimo() {
        if (txtDisplay.getText().length() > 0) {
            StringBuilder strB = new StringBuilder(txtDisplay.getText());
            strB.deleteCharAt(txtDisplay.getText().length() - 1);
            txtDisplay.setText(String.valueOf(strB));
        }
    }

    private void cambiarSigno() {
        if (txtDisplay.getText().isEmpty()) return;
        if (txtDisplay.getText().contains(".")) {
            double pm = Double.parseDouble(txtDisplay.getText()) * -1;
            txtDisplay.setText(String.valueOf(pm));
        } else {
            long PM = Long.parseLong(txtDisplay.getText()) * -1;
            txtDisplay.setText(String.valueOf(PM));
        }
    }

    private void agregarDecimal() {
        if (!txtDisplay.getText().contains(".")) {
            txtDisplay.setText(txtDisplay.getText() + ".");
        }
    }

    /**
     * Constructor de la calculadora
     */
    public Calculator() {
        // Botón AC
        ACButton.addActionListener(e -> limpiarPantalla());

        // Botón retroceso
        button6.addActionListener(e -> borrarUltimo());

        // Botón cambio de signo
        button16.addActionListener(e -> cambiarSigno());

        // Botón decimal
        button20.addActionListener(e -> agregarDecimal());

        // Números
        a7Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "7"));
        a8Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "8"));
        a9Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "9"));
        a4Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "4"));
        a5Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "5"));
        a6Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "6"));
        a1Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "1"));
        a2Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "2"));
        a3Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "3"));
        a0Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "0"));
        a00Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "00"));

        // Operadores
        button11.addActionListener(e -> { a = Double.parseDouble(txtDisplay.getText()); operator = "+"; limpiarPantalla(); });
        button2.addActionListener(e -> { a = Double.parseDouble(txtDisplay.getText()); operator = "-"; limpiarPantalla(); });
        button3.addActionListener(e -> { a = Double.parseDouble(txtDisplay.getText()); operator = "*"; limpiarPantalla(); });
        XXButton.addActionListener(e -> { a = Double.parseDouble(txtDisplay.getText()); operator = "/"; limpiarPantalla(); });

        // Igual (=)
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = Double.parseDouble(txtDisplay.getText());
                switch (operator) {
                    case "+": result = sumar(a, b); break;
                    case "-": result = restar(a, b); break;
                    case "*": result = multiplicar(a, b); break;
                    case "/": result = dividir(a, b); break;
                }
                txtDisplay.setText(String.valueOf(result));
            }
        });
    }

    /**
     * Método main
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
