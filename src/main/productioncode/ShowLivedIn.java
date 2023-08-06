package productioncode;

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
        boolean flag = false;
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {


            statement = connection.createStatement();

            String query = "Select * from Tenants_Housing where houseID='" + id + "'";
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                flag = true;
            }
            res.close();
        } finally {
            assert statement != null;
            statement.close();
        }


        return flag;

    }
    public boolean displayLived(String id) throws SQLException{
        boolean flag=false;
        if (isLived(id)) {

            Statement statement = null;
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                statement = connection.createStatement();

                String query = "Select * from Tenants_Housing where houseID='" + id + "'";
                ResultSet res = statement.executeQuery(query);
                while (res.next()) {
                    String people = "People is : " + res.getString(1);
                    logger.info(people);
                    flag = true;
                }
                res.close();
            } finally {
                assert statement != null;
                statement.close();
            }


        }
        return flag;
    }


}
