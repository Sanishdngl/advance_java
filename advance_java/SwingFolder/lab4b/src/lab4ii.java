import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab4ii extends JFrame{
private JTextField num1Field;
   private JTextField num2Field;
   private JLabel resultLabel;

   public lab4ii() {
       setTitle("Number Calculator");
       setSize(300, 150);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new GridLayout(3, 2));

       JLabel num1Label = new JLabel("Number 1:");
       JLabel num2Label = new JLabel("Number 2:");
       num1Field = new JTextField();
       num2Field = new JTextField();
       resultLabel = new JLabel();

       num1Field.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               calculateSum();
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               calculateDifference();
           }
       });

       num2Field.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               calculateSum();
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               calculateDifference();
           }
       });

       add(num1Label);
       add(num1Field);
       add(num2Label);
       add(num2Field);
       add(new JLabel("Result:"));
       add(resultLabel);
   }

   private void calculateSum() {
       try {
           double num1 = Double.parseDouble(num1Field.getText());
           double num2 = Double.parseDouble(num2Field.getText());
           double sum = num1 + num2;
           resultLabel.setText(String.format("Sum: %.2f", sum));
       } catch (NumberFormatException e) {
           resultLabel.setText("Invalid input. Please enter valid numbers.");
       }
   }

   private void calculateDifference() {
       try {
           double num1 = Double.parseDouble(num1Field.getText());
           double num2 = Double.parseDouble(num2Field.getText());
           double difference = num1 - num2;
           resultLabel.setText(String.format("Difference: %.2f", difference));
       } catch (NumberFormatException e) {
           resultLabel.setText("Invalid input. Please enter valid numbers.");
       }
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
        lab4ii calculator = new lab4ii();
           calculator.setVisible(true);
       });
   }
 
}