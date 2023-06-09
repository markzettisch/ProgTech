import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminPage extends JFrame {
    private JPanel mainPanel;
    private JPanel text;
    private JLabel logged;
    private JPanel form;
    private JButton logout;
    private JList list;

    public ArrayList<Reservations> reservation = new ArrayList<>();

    public AdminPage(int ID) {
        Database db = new Database();
        db.refreshData();




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
}
