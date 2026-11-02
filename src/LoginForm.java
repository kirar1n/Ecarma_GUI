import javax.swing.*;

public class LoginForm extends JFrame {
    private JPanel mainPanel;
    private JTextField userNameTextField;
    private JButton loginButton;
    private JPasswordField passwordTextField;

    private LoginForm() {
        userNameTextField.setName("userNameTextField");
        passwordTextField.setName("passwordTextField");
        loginButton.setName("loginButton");

        passwordTextField.setEchoChar('*');

        loginButton.addActionListener(e -> {
            String username = userNameTextField.getText();
            String password = new String(passwordTextField.getPassword());

            String message;
            if (username.equals("admin") && password.equals("admin")) {
                message = "Login Successful!";
            } else {
                message = "Login Failed!";
            }

            JLabel messageLabel = new JLabel(message);
            messageLabel.setName("messageLabel");
            messageLabel.setBorder(
                    BorderFactory.createEmptyBorder(20, 20, 20, 20)
            );

            JDialog statusDialog = new JDialog(this, "Status", true);
            statusDialog.setName("statusDialog");
            statusDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            statusDialog.add(messageLabel);
            statusDialog.pack();
            statusDialog.setLocationRelativeTo(this);
            statusDialog.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm enter = new LoginForm();
            enter.setTitle("Login Form");
            enter.setContentPane(enter.mainPanel);
            enter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            enter.setSize(350, 350);
            enter.setLocationRelativeTo(null);
            enter.setVisible(true);
        });
    }
}