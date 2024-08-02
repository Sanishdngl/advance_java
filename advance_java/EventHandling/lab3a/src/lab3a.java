import java.awt.*;
import java.awt.event.*;
public class lab3a extends Frame implements MouseListener {
    Label l;
    public lab3a() {
        l = new Label("Welcome!");
        l.setBounds(80, 100, 220, 30);
        l.setFont(new Font("Serif", Font.BOLD, 18));
        l.setForeground(Color.GREEN);
        l.addMouseListener(this);
        add(l);
        setTitle("Frame with label and mouse events");
        setSize(300, 200);
        setVisible(true);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    public void mouseClicked(MouseEvent e) {
        l.setText("Mouse Clicked");
    }
    public void mouseEntered(MouseEvent e) {
        l.setText("Mouse Entered");
    }
    public void mouseExited(MouseEvent e) {
        l.setText("Mouse Exited");
    }
    public void mousePressed(MouseEvent e) {
        l.setText("Mouse Pressed");
    }
    public void mouseReleased(MouseEvent e) {
        l.setText("Mouse Released");
    }
    public static void main(String[] args) {
        new lab3a();
    }
}

