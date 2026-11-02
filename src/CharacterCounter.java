import javax.swing.*;

public class CharacterCounter extends JFrame {
    private JPanel mainPanel;
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel count;
    private JLabel countLabel;

    private CharacterCounter() {
        messageTextArea.setName("messageTextArea");
        characterTextField.setName("characterTextField");
        countButton.setName("countButton");
        countLabel.setName("countLabel");
        countLabel.setText("0");

        countButton.addActionListener(e -> {
            String message = messageTextArea.getText();
            String input = characterTextField.getText();

            if (input.length() != 1) {
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Please enter exactly one character."
                );
                return;
            }

            char character = input.charAt(0);
            int total = 0;

            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) == character) {
                    total++;
                }
            }
            countLabel.setText(String.valueOf(total));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CharacterCounter charCtr = new CharacterCounter();
            charCtr.setTitle("Character Counter");
            charCtr.setContentPane(charCtr.mainPanel);
            charCtr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            charCtr.setSize(450, 350);
            charCtr.setLocationRelativeTo(null);
            charCtr.setVisible(true);
        });
    }
}