import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {


    private String db_url = "jdbc:mysql://localhost:3306/progtech";
    private String db_username = "root";
    private String db_pass = "";


    public void Test() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");
            System.out.println("Adatbázis teszt: regisztrált felhasználók:");
            while(resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }


            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkLogin(String username, String password) {
        int error = 1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");

            while(resultSet.next()) {
                if(resultSet.getString(2).equals(username)) //van ilyen felhasználónév
                    if(resultSet.getString(4).equals(password)) //a felhasználónévhez tartozó jelszó is helyes
                        error = 0;
            }


            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

        if(error == 1)
            return false;
        else
            return true;
    }



}
