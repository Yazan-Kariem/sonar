package productioncode;

import java.sql.*;
import java.util.logging.Logger;

public class Furniture {

    String picture;
    String description;
    String price;
    String id;
    String selled;
    String queryS = "Select * from forniture where username_tenant='";
    private static final Logger logger = Logger.getLogger(Furniture.class.getName());
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

    public boolean checkAvailability(String userName) throws SQLException {
boolean flag=false;
        Statement statement = null;
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
             statement = connection.createStatement();

            String query = queryS + userName + "' and Selled='No'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                flag= true;
            }
resultSet.close();
        }
        finally {
            assert statement!=null;
            statement.close();
        }
        return flag;


    }

    public boolean displayFurniture(String userName) throws SQLException {
        boolean flag=false;
        if (checkAvailability(userName)) {

            int counter = 1;

            Statement statement = null;
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                statement = connection.createStatement();

                String query = queryS + userName + "'";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String idt = "ID : " + resultSet.getString(5);
                    String pcounter = counter + "-";
                    String ppicture = "Picture : " + resultSet.getString(2);
                    String residence = "residence_location_desc : " + resultSet.getString(3);
                    String pprice = "Price : " + resultSet.getString(4);
                    logger.info(pcounter);
                    logger.info(idt);
                    logger.info(ppicture);
                    logger.info(residence);
                    logger.info(pprice);
                    logger.info("_____________________________________________");
                    counter++;
                    flag = true;
                }

            } finally {
                assert statement != null;
                statement.close();
            }

        }
        return flag;
    }

    public boolean addFurniture(String userName, String picture, String description, String price, String id, String selled) throws SQLException {
        String query = "insert into forniture (id,picture,residence_location_desc,price,username_tenant,selled) value ('" + id + "','" + picture + "','" + description + "','" + price + "','" + userName + "','" + selled + "')";


        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } finally {
            assert statement != null;
            statement.close();
        }
        return true;


    }

    public boolean sellFurniture(String id, String userName) throws SQLException {
        if (checkAvailability(userName, id)) {


            Statement statement = null;
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                statement = connection.createStatement();
                String query = "update forniture set selled='Yes' where id='" + id + "'";
                statement.executeUpdate(query);
            } finally {
                assert statement != null;
                statement.close();
            }
            return true;


        }
        return false;
    }

    public boolean checkAvailability(String userName, String id) throws SQLException {
        boolean flag = false;
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            statement = connection.createStatement();

            String query = queryS + userName + "' and selled='No' and id='" + id + "'";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                flag = true;

            }
            resultSet.close();
        } finally {
            assert statement != null;
            statement.close();
        }

        return flag;


    }


}
