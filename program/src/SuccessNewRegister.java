import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessNewRegister extends JFrame {
    private JPanel mainPanel;
    private JPanel text;
    private JPanel form;
    private JButton login_btn;


public SuccessNewRegister() {
    setIconImage(new ImageIcon("success.png").getImage());
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(400, 200));
    setLocationRelativeTo(null);
    setVisible(true);
    add(mainPanel);

    login_btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
            new LoginPage();
        }
    });
}
}
