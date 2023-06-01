import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class MainPage extends JFrame {

    private JPanel mainPanel;
    private JPanel text;
    private JPanel form;
    private JButton login_btn;
    private JButton logout;
    private JPanel Main;
    private JLabel logged;
    private JComboBox erk_ev;
    private JComboBox erk_honap;
    private JComboBox erk_nap;
    private JComboBox tav_ev;
    private JComboBox tav_honap;
    private JComboBox tav_nap;
    private JTextField textField1;
    private JComboBox szobak;


    public MainPage(int ID) {
        Database db = new Database();

        setIconImage(new ImageIcon("main.png").getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(null);
        setVisible(true);
        add(mainPanel);

        szobak.addItem("101-es szoba");
        szobak.addItem("102-es szoba");
        szobak.addItem("103-as szoba");
        szobak.addItem("104-es szoba");
        for(int i = Calendar.getInstance().get(Calendar.YEAR); i < (Calendar.getInstance().get(Calendar.YEAR))+3; i++) {
            erk_ev.addItem(i);
            tav_ev.addItem(i);
        }
        for(int i = 1; i <= 12; i++) {
            erk_honap.addItem(i);
            tav_honap.addItem(i);
        }
        for(int i = 1; i <= 31; i++) {
            erk_nap.addItem(i);
            tav_nap.addItem(i);
        }



        logged.setText("Belépve: " + db.IDtoData(ID));



        logout.addActionListener(new ActionListener() {
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

            }
        });
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
