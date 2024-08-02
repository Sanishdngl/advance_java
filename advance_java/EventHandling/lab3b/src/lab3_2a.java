import javax.swing.*;
import java.awt.*;

public class lab3_2a extends JFrame {
    public lab3_2a() {
        setTitle("Personal Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        // Panel for input fields and labels
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        // Labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");

        // Text fields
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();

        // Add labels and text fields to the panel
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);

        // Panel for the image icon
        JPanel imagePanel = new JPanel();
        ImageIcon icon = new ImageIcon("d://imgJava.png"); 
        JLabel imageLabel = new JLabel(icon);
        imagePanel.add(imageLabel);

        // Adding panels to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.WEST);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new lab3_2a();
        });
    }
}
