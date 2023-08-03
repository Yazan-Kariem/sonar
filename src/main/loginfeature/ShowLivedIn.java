package loginfeature;

import java.sql.*;
import java.util.logging.Logger;

public class ShowLivedIn {
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    private static final Logger logger = Logger.getLogger(ShowLivedIn.class.getName());
    public boolean isLived(String id) throws SQLException {

    Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

           String query = "Select * from Tenants_Housing where houseID='" + id + "'";
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return true;
            }



        return false;

    }
    public boolean displayLived(String id) throws SQLException{
        if (isLived(id)) {

            Connection connection = DriverManager.getConnection(url, username, password);

                Statement statement = connection.createStatement();

               String query = "Select * from Tenants_Housing where houseID='" + id + "'";
                ResultSet res = statement.executeQuery(query);
                while (res.next()) {
                    String people="People is : " + res.getString(1);
                    logger.info(people);

                }
                return true;



        }
        return false;
    }


}
