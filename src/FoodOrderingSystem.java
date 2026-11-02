import javax.swing.*;
import java.util.Locale;

public class FoodOrderingSystem extends JFrame {
    private JPanel mainPanel;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    private FoodOrderingSystem() {
        cPizza.setName("cPizza");
        cBurger.setName("cBurger");
        cFries.setName("cFries");
        cSoftDrinks.setName("cSoftDrinks");
        cTea.setName("cTea");
        cSundae.setName("cSundae");

        rbNone.setName("rbNone");
        rb5.setName("rb5");
        rb10.setName("rb10");
        rb15.setName("rb15");
        btnOrder.setName("btnOrder");
        rbNone.setSelected(true);

        btnOrder.addActionListener(e -> {
            double price = 0;

            if (cPizza.isSelected()) {
                price += 100;
            }
            if (cBurger.isSelected()) {
                price += 80;
            }
            if (cFries.isSelected()) {
                price += 65;
            }
            if (cSoftDrinks.isSelected()) {
                price += 55;
            }
            if (cTea.isSelected()) {
                price += 50;
            }
            if (cSundae.isSelected()) {
                price += 40;
            }

            double discount = 0;

            if (rb5.isSelected()) {
                discount = 0.05;
            } else if (rb10.isSelected()) {
                discount = 0.10;
            } else if (rb15.isSelected()) {
                discount = 0.15;
            }

            double discountAmount = price * discount;
            price = price - discountAmount;

            String message = String.format(
                    Locale.US,
                    "The total price is Php %.2f",
                    price
            );
            JOptionPane.showMessageDialog(mainPanel, message);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodOrderingSystem foodPanda = new FoodOrderingSystem();
            foodPanda.setTitle("Food Ordering System");
            foodPanda.setContentPane(foodPanda.mainPanel);
            foodPanda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            foodPanda.setSize(500, 400);
            foodPanda.setLocationRelativeTo(null);
            foodPanda.setVisible(true);
        });
    }
}