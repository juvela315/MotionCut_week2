import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    private JFrame frame;
    private JTextField inputField;
    private JLabel resultLabel;

    public TemperatureConverter() {
        frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 1));

        inputField = new JTextField();
        resultLabel = new JLabel("", SwingConstants.CENTER);

        JLabel titleLabel = new JLabel("Choose Conversion Type:", SwingConstants.CENTER);
        JPanel buttonPanel = new JPanel();

        JButton celsiusToFahrenheitButton = new JButton("Celsius to Fahrenheit");
        JButton fahrenheitToCelsiusButton = new JButton("Fahrenheit to Celsius");

        celsiusToFahrenheitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertAndDisplay("Celsius to Fahrenheit", inputField.getText(), true);
            }
        });

        fahrenheitToCelsiusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertAndDisplay("Fahrenheit to Celsius", inputField.getText(), false);
            }
        });

        buttonPanel.add(celsiusToFahrenheitButton);
        buttonPanel.add(fahrenheitToCelsiusButton);

        frame.add(titleLabel);
        frame.add(inputField);
        frame.add(buttonPanel);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    private void convertAndDisplay(String conversionType, String input, boolean isCelsiusToFarhrenheit) {
        try {
            double temperature = Double.parseDouble(input);
            double result;
            if (isCelsiusToFarhrenheit) {
                result = (temperature * 9 / 5) + 32;
            } else {
                result = (temperature - 32) * 5 / 9;
            }
            resultLabel.setText(conversionType + ": " + String.format("%.2f", result));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverter();
            }
        });
    }
}
