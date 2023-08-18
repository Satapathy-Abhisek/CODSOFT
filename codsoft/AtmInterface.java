import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATMGUI extends JFrame implements ActionListener {
    private BankAccount account;
    private JTextField amountField;
    private JRadioButton withdrawRadioButton, depositRadioButton, checkBalanceRadioButton;
    private JButton executeButton;
    private JLabel messageLabel;

    public ATMGUI(BankAccount account) {
        this.account = account;

        setTitle("ATM Interface");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7, 1));

        JLabel welcomeLabel = new JLabel("Welcome to the ATM");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(welcomeLabel);

        JPanel radioButtonsPanel = new JPanel();
        radioButtonsPanel.setLayout(new FlowLayout());
        withdrawRadioButton = new JRadioButton("Withdraw");
        depositRadioButton = new JRadioButton("Deposit");
        checkBalanceRadioButton = new JRadioButton("Check Balance");
        radioButtonsPanel.add(withdrawRadioButton);
        radioButtonsPanel.add(depositRadioButton);
        radioButtonsPanel.add(checkBalanceRadioButton);
        mainPanel.add(radioButtonsPanel);

        amountField = new JTextField(10);
        executeButton = new JButton("Execute");
        executeButton.addActionListener(this);
        mainPanel.add(amountField);
        mainPanel.add(executeButton);

        messageLabel = new JLabel("", JLabel.CENTER);
        mainPanel.add(messageLabel);

        ButtonGroup operationGroup = new ButtonGroup();
        operationGroup.add(withdrawRadioButton);
        operationGroup.add(depositRadioButton);
        operationGroup.add(checkBalanceRadioButton);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (withdrawRadioButton.isSelected()) {
            double withdrawAmount = Double.parseDouble(amountField.getText());
            if (account.withdraw(withdrawAmount)) {
                messageLabel.setText("Withdrawal successful. Balance: Rs." + account.getBalance());
            } else {
                messageLabel.setText("Insufficient balance for withdrawal.");
            }
        } else if (depositRadioButton.isSelected()) {
            double depositAmount = Double.parseDouble(amountField.getText());
            account.deposit(depositAmount);
            messageLabel.setText("Deposit successful. Balance: Rs." + account.getBalance());
        } else if (checkBalanceRadioButton.isSelected()) {
            messageLabel.setText("Current balance: Rs." + account.getBalance());
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(2000.0);
        SwingUtilities.invokeLater(() -> new ATMGUI(userAccount));
    }
}
