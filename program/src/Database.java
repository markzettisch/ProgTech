import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database implements Database_IF {


    private String db_url = "jdbc:mysql://localhost:3306/progtech";
    private String db_username = "root";
    private String db_pass = "";


    @Override
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

    @Override
    public int checkLogin(String username, String password) {
        int ID = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");

            while(resultSet.next()) {
                if(resultSet.getString(2).equals(username)) //van ilyen felhasználónév
                    if(resultSet.getString(4).equals(password)) //a felhasználónévhez tartozó jelszó is helyes
                        ID = resultSet.getInt(1);
            }


            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

        return ID;
    }

    @Override
    public String IDtoData(int ID) {
        String full_name = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users where ID='"+ID+"'");

            while(resultSet.next()) {
                full_name = resultSet.getString(3);
            }


            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

        return full_name;
    }

    @Override
    public int getType(int ID) {
        int type = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users where ID='"+ID+"'");

            while(resultSet.next()) {
                type = resultSet.getInt(5);
            }


            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

        return type;
    }

    @Override
    public boolean checkUsername(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");

            while(resultSet.next()) {
                if(resultSet.getString(2).equals(username)) {
                    //van ilyen felhasználónév
                    return true;
                }

            }


            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

        return false;


    }


    @Override
    public void refreshData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from reservations");

            while(resultSet.next()) {
                
                new Guest(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6));
            }


            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }



    }

    @Override
    public boolean addUser(String username, String full_name, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO users (username, full_name, password) VALUES ('"+username+"','"+full_name+"','"+password+"');");

            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

        return false;


    }

    @Override
    public void addReservation(int user_ID, String erk, String tav, int count, int room) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_pass);
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO reservations (user_ID, erk, tav, count, room) VALUES ('"+user_ID+"','"+erk+"','"+tav+"','"+count+"','"+room+"');");

            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
