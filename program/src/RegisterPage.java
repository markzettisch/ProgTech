import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RegisterPage extends JFrame {
    private JPanel mainPanel;
    private JPanel text;
    private JPanel form;
    private JTextField username;

    private JTextField full_name;
    private JButton login_btn;
    private JPasswordField password;
    private JButton reg_button;
    private JLabel error_text;

    public RegisterPage() {
        setIconImage(new ImageIcon("register.png").getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 350));
        setLocationRelativeTo(null);
        setVisible(true);
        add(mainPanel);
        error_text.setText("");


        String username_show_text = "Felhasználónév";
        username.setText(username_show_text);
        username.setForeground(Color.GRAY);


        String full_name_show_text = "Teljes név";
        full_name.setText(full_name_show_text);
        full_name.setForeground(Color.GRAY);

        String password_show_text = "Jelszó";
        password.setText(password_show_text);
        password.setForeground(Color.GRAY);
        password.setEchoChar((char)0);



        username.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (username.getText().equals(username_show_text)) {
                    username.setText("");
                    username.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (username.getText().isEmpty()) {
                    username.setForeground(Color.GRAY);
                    username.setText(username_show_text);
                }
            }
        });
        full_name.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (full_name.getText().equals(full_name_show_text)) {
                    full_name.setText("");
                    full_name.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (full_name.getText().isEmpty()) {
                    full_name.setForeground(Color.GRAY);
                    full_name.setText(full_name_show_text);
                }
            }
        });
        password.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (password.getText().equals(password_show_text)) {
                    password.setText("");
                    password.setEchoChar('*');
                    password.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getText().isEmpty()) {
                    password.setForeground(Color.GRAY);
                    password.setEchoChar((char)0);
                    password.setText(password_show_text);
                }
            }
        });
        reg_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new LoginPage();
            }
        });
        login_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(username.getText().isEmpty() || username.getText().contains("Felhasználónév")) {
                    System.out.println("Üres mező");
                    error_text.setText("Üres mező");
                } else if(full_name.getText().isEmpty() || full_name.getText().contains("Teljes név")) {
                    System.out.println("Üres mező");
                    error_text.setText("Üres mező");
                } else if(password.getText().isEmpty() || password.getText().contains("Jelszó")) {
                    System.out.println("Üres mező");
                    error_text.setText("Üres mező");
                } else {
                    Database db = new Database();
                    boolean checkedUsername = db.checkUsername(username.getText());
                    if(checkedUsername == true) {
                        System.out.println("Már létezik ilyen felhasználónévvel fiók.");
                        error_text.setText("Már létezik ilyen felhasználónévvel fiók.");
                    } else {
                        db.addUser(username.getText(), full_name.getText(), password.getText());
                        setVisible(false);
                        dispose();
                        new SuccessNewRegister();
                    }
                }

            }
        });
    }
}
