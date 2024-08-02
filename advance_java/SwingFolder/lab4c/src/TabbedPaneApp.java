import javax.swing.*;
import java.awt.*;

public class TabbedPaneApp extends JFrame {
    public TabbedPaneApp() {
        setTitle("Tabbed Pane Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Create JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Home Tab
        JPanel homePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel homeLabel = new JLabel("Welcome to the Home Tab!");
        homePanel.add(homeLabel);
        tabbedPane.addTab("Home", homePanel);

        // Profile Tab
        JPanel profilePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        profilePanel.add(nameLabel);
        profilePanel.add(nameField);
        profilePanel.add(emailLabel);
        profilePanel.add(emailField);
        tabbedPane.addTab("Profile", profilePanel);

        // Settings Tab
        JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel settingsLabel = new JLabel("Settings");
        JButton settingsButton = new JButton("Change Settings");
        settingsPanel.add(settingsLabel);
        settingsPanel.add(settingsButton);
        tabbedPane.addTab("Settings", settingsPanel);

        // Add tabbedPane to frame
        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TabbedPaneApp();
        });
    }
}
