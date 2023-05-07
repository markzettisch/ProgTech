import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginPage extends JFrame {

    private JPanel panelmain;
    private JPanel mainPanel;
    private JPanel text;
    private JPanel form;
    private JTextField username;
    private JButton login_btn;
    private JPasswordField password;
    private JButton reg_button;

    public LoginPage() {
        setIconImage(new ImageIcon("login.png").getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setVisible(true);
        add(mainPanel);

        String username_show_text = "Felhasználónév";
        username.setText(username_show_text);
        username.setForeground(Color.GRAY);

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
        login_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(username.getText().isEmpty()) {
                    System.out.println("Üres mező");
                } else if(password.getText().isEmpty()) {
                    System.out.println("Üres mező");
                } else if(username.getText().contains("Felhasználónév")) {
                    System.out.println("Üres mező");
                } else if(password.getText().contains("Jelszó")) {
                    System.out.println("Üres mező");
                } else {
                    Database db = new Database();
                    boolean checkedLogin = db.checkLogin(username.getText(), password.getText());
                    if(checkedLogin == true) {
                        System.out.println("OK");
                    } else {
                        System.out.println("Hibás felhasználónév vagy jelszó");
                    }

                }

            }
        });
    }


}
