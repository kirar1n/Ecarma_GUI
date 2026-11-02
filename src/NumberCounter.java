import javax.swing.*;

public class NumberCounter extends JFrame {
    private JLabel countLabel;
    private JButton decreaseButton;
    private JButton increaseButton;
    private JPanel mainPanel;

    private int count = 0;

    private NumberCounter() {
        countLabel.setName("countLabel");
        decreaseButton.setName("decreaseButton");
        increaseButton.setName("increaseButton");

        countLabel.setText(String.valueOf(count));

        increaseButton.addActionListener(e -> {
            count++;
            countLabel.setText(String.valueOf(count));
        });

        decreaseButton.addActionListener(e -> {
            count--;
            countLabel.setText(String.valueOf(count));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberCounter numctr = new NumberCounter();
            numctr.setTitle("Number Counter");
            numctr.setContentPane(numctr.mainPanel);
            numctr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            numctr.setSize(400, 300);
            numctr.setLocationRelativeTo(null);
            numctr.setVisible(true);
        });
    }
}