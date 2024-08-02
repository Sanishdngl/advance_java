import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab4 extends JFrame {
    private JTextField celsiusField;
    private JTextField fahrenheitField;

    public lab4() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JLabel celsiusLabel = new JLabel("Celsius:");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        celsiusField = new JTextField();
        fahrenheitField = new JTextField();
        fahrenheitField.setEditable(false);

        celsiusField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    convert();
                }
            }
        });

        add(celsiusLabel);
        add(celsiusField);
        add(fahrenheitLabel);
        add(fahrenheitField);
    }

    private void convert() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            lab4 converter = new lab4();
            converter.setVisible(true);
        });
    }
}