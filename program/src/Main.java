import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {

        logger.info("Alkalmazás elindítva");

        new LoginPage();
        Database db = new Database();
        db.Test();

    }
}