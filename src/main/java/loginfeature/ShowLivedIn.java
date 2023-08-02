package loginfeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class ShowLivedIn {
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    private static final Logger logger = Logger.getLogger(ShowLivedIn.class.getName());
    public boolean isLived(String id){

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();

           String query = "Select * from Tenants_Housing where houseID='" + id + "'";
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return true;
            }

        }
        catch (Exception e){

        }

        return false;

    }
    public boolean displayLived(String id) {
        if (isLived(id)) {

            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                Statement statement = connection.createStatement();

               String query = "Select * from Tenants_Housing where houseID='" + id + "'";
                ResultSet res = statement.executeQuery(query);
                while (res.next()) {
                    logger.info("People is : " + res.getString(1));

                }
                return true;
            } catch (Exception e) {

            }


        }
        return false;
    }


}
