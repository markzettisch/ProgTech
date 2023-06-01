import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    private JPanel mainPanel;
    private JPanel text;
    private JPanel form;
    private JLabel error_text;
    private JButton login_btn;
    private JPasswordField password;
    private JButton logout;
    private JPanel Main;
    private JLabel logged;


    public MainPage(int ID) {
        Database db = new Database();

        setIconImage(new ImageIcon("main.png").getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(null);
        setVisible(true);
        add(mainPanel);

        logged.setText("Belépve: " + db.IDtoData(ID));



        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new LoginPage();

            }
        });

    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
