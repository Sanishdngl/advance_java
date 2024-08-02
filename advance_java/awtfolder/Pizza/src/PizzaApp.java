import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

class Pizza {
    private String customerName;
    private int numberOfToppings;
    private String size;

    public Pizza(String customerName, int numberOfToppings, String size) {
        this.customerName = customerName;
        this.numberOfToppings = numberOfToppings;
        this.size = size;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10d %-10s", customerName, numberOfToppings, size);
    }
}

public class PizzaApp extends Frame {
    private TextField cusNameTxt;
    private TextField toppingsTxt;
    private CheckboxGroup chkgrp;
    private TextArea descTxtArea;
    private List<Pizza> pizzas = new ArrayList<>();

    PizzaApp() {
        setTitle("Rocky Woodfired Pizzas Management System");
        setSize(800, 800);
        setLayout(new BorderLayout());

        Label titleLbl = new Label("Rocky Wood Pizzas Management System");
        Panel firstPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Panel secondPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Panel thirdPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Panel lastPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        Panel gridPanel = new Panel(new GridLayout(3, 1));

        titleLbl.setFont(new Font(null, Font.BOLD, 18));
        firstPanel.add(titleLbl);

        Label cusNameLbl = new Label("Customer Name");
        cusNameTxt = new TextField();
        cusNameTxt.setPreferredSize(new Dimension(300, 20));

        secondPanel.add(cusNameLbl);
        secondPanel.add(cusNameTxt);

        Label toppingsLbl = new Label("Number of Toppings");
        toppingsTxt = new TextField();
        toppingsTxt.setPreferredSize(new Dimension(300, 20));

        chkgrp = new CheckboxGroup();
        Checkbox smallChk = new Checkbox("Small", chkgrp, false);
        Checkbox mediumChk = new Checkbox("Medium", chkgrp, false);
        Checkbox largeChk = new Checkbox("Large", chkgrp, false);

        thirdPanel.add(toppingsLbl);
        thirdPanel.add(toppingsTxt);
        thirdPanel.add(smallChk);
        thirdPanel.add(mediumChk);
        thirdPanel.add(largeChk);

        gridPanel.add(firstPanel);
        gridPanel.add(secondPanel);
        gridPanel.add(thirdPanel);

        descTxtArea = new TextArea();
        descTxtArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Set monospaced font for alignment
        descTxtArea.setRows(5);

        Button enterBtn = new Button("Enter");
        Button displayAllBtn = new Button("Display All");
        Button searchBtn = new Button("Search");
        Button exitBtn = new Button("Exit");

        lastPanel.add(enterBtn);
        lastPanel.add(displayAllBtn);
        lastPanel.add(searchBtn);
        lastPanel.add(exitBtn);

        add(gridPanel, BorderLayout.NORTH);
        add(descTxtArea, BorderLayout.CENTER);
        add(lastPanel, BorderLayout.SOUTH);

        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get customer name
                String customerName = cusNameTxt.getText();

                // Get number of toppings
                int numberOfToppings;
                try {
                    numberOfToppings = Integer.parseInt(toppingsTxt.getText());
                } catch (NumberFormatException ex) {
                    descTxtArea.setText("Please enter a valid number for toppings.");
                    return;
                }

                // Get selected size
                String size = chkgrp.getSelectedCheckbox() != null ? chkgrp.getSelectedCheckbox().getLabel() : null;
                if (size == null) {
                    descTxtArea.setText("Please select a size.");
                    return;
                }

                // Create and add Pizza object
                Pizza pizza = new Pizza(customerName, numberOfToppings, size);
                pizzas.add(pizza);

                // Update display
                updateDisplay();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void updateDisplay() {
        StringBuilder displayText = new StringBuilder();
        displayText.append(String.format("%-20s %-10s %-10s\n", "Customer Name", "Toppings", "Size"));
        displayText.append("-------------------------------------------\n");
        for (Pizza pizza : pizzas) {
            displayText.append(pizza.toString()).append("\n");
        }
        descTxtArea.setText(displayText.toString());
    }

    public static void main(String args[]) {
        // Ensure GUI is created on the Event Dispatch Thread
        EventQueue.invokeLater(() -> {
            new PizzaApp();
        });
    }
}
