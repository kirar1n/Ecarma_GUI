import javax.swing.*;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleCalculator extends JFrame {
    private JPanel mainPanel;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JLabel lblResult;
    private JButton btnCompute;

    private SimpleCalculator() {
        tfNumber1.setName("tfNumber1");
        tfNumber2.setName("tfNumber2");
        cbOperations.setName("cbOperations");
        btnCompute.setName("btnCompute");
        lblResult.setName("lblResult");

        tfNumber1.setHorizontalAlignment(JTextField.CENTER);
        tfNumber2.setHorizontalAlignment(JTextField.CENTER);
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setText("");

        mainPanel.setBackground(new Color(214, 217, 225));
        lblResult.setOpaque(true);
        lblResult.setBackground(new Color(225, 225, 225));
        lblResult.setBorder(
                BorderFactory.createLoweredBevelBorder()
        );

        btnCompute.addActionListener(e -> {
            try {
                String input1 = tfNumber1.getText().trim();
                String input2 = tfNumber2.getText().trim();

                double number1 = Double.parseDouble(input1);
                double number2 = Double.parseDouble(input2);

                if (!Double.isFinite(number1)
                        || !Double.isFinite(number2)) {
                    throw new NumberFormatException();
                }

                String oP =
                        (String) cbOperations.getSelectedItem();

                if (oP == null) {
                    oP = "";
                }

                double result;

                switch (oP) {
                    case "+":
                        result = number1 + number2;
                        break;

                    case "-":
                        result = number1 - number2;
                        break;

                    case "*":
                        result = number1 * number2;
                        break;

                    case "/":
                        if (number2 == 0) {
                            lblResult.setText("");
                            JOptionPane.showMessageDialog(
                                    mainPanel,
                                    "Cannot divide by zero."
                            );
                            return;
                        }

                        result = number1 / number2;
                        break;

                    default:
                        lblResult.setText("");
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                "Please select an operation."
                        );
                        return;
                }

                if (!Double.isFinite(result)) {
                    lblResult.setText("");
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "The result is too large."
                    );
                    return;
                }

                String resultText = String.valueOf(result);
                if (resultText.endsWith(".0")) {
                    resultText = resultText.substring(0, resultText.length() - 2);
                }

                lblResult.setText(resultText);

                String calculation = input1 + " " + oP + " " + input2 + " = " + resultText;

                try (FileWriter writer =
                             new FileWriter("calculator_history.txt", true)) {
                    writer.write(calculation + System.lineSeparator());

                } catch (IOException e2) {
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "The calculation succeeded, but history "
                                    + "could not be saved.",
                            "File Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            } catch (NumberFormatException e2) {
                lblResult.setText("");
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Please enter valid numbers in both fields."
                );
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator kwentaKwenta = new SimpleCalculator();
            kwentaKwenta.setTitle("Simple Calculator");
            kwentaKwenta.setContentPane(kwentaKwenta.mainPanel);
            kwentaKwenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            kwentaKwenta.setSize(500, 230);
            kwentaKwenta.setLocationRelativeTo(null);
            kwentaKwenta.setVisible(true);
        });
    }
}