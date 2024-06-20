import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame {
    private JTextField passwordField;
    private JButton enterButton;
    private JLabel statusLabel;

    private String password;
    private boolean isPasswordSet;

    public LockerApplication() {
        setTitle("Locker Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        passwordField = new JTextField(10);
        enterButton = new JButton("Enter");
        statusLabel = new JLabel("Enter your passcode to set the password.");

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPasswordSet) {
                    setPassword();
                } else {
                    verifyPassword();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(passwordField);
        panel.add(enterButton);
        panel.add(statusLabel);

        add(panel);
        setVisible(true);
    }

    private void setPassword() {
        password = passwordField.getText();
        isPasswordSet = true;
        statusLabel.setText("Password Set");
        passwordField.setText("");
    }

    private void verifyPassword() {
        String enteredPassword = passwordField.getText();
        if (enteredPassword.equals(password)) {
            statusLabel.setText("Correct Password");
        } else {
            statusLabel.setText("Incorrect Password");
        }
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LockerApplication();
            }
        });
    }
}