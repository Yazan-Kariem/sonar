package productioncode;

import java.sql.*;

public class LoginEntity {


    boolean reg = false;


    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username1 = "root";
    String password1 = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

    String owner = "owner";
String tenant="tenant";
    String userName;
    String password;
    String role;
    String admin="admin";

    public  String checkValues(String userName,String password) throws SQLException {

        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username1, password1)) {
            statement = connection.createStatement();
            role="null";
            if (!userName.isEmpty() && !password.isEmpty()) {

                String query = "SELECT * FROM login where username='" + userName + "' and password='" + password + "'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {

                    if (resultSet.getString(3).equalsIgnoreCase(tenant)) {
                        role = tenant;
                    } else if (resultSet.getString(3).equalsIgnoreCase(admin)) {
                        role = admin;
                    } else if (resultSet.getString(3).equalsIgnoreCase(owner)) {
                        role = owner;
                    }
                }
                resultSet.close();
            }

        } finally {
            assert statement != null;
            statement.close();
        }
        return role;
    }

    public boolean printOwner(String fName, String mName, String lName, String phone, String owEmail, String age, String owUser, String owPass) throws SQLException {
        Statement statement3 = null;
        Statement statement2 = null;
        try (Connection connection = DriverManager.getConnection(url, username1, password1)) {
            statement2 = connection.createStatement();
            String query2 = "insert into login (username, password, role) values ('" + owUser + "', '" + owPass + "', '" + owner + "')";
            statement2.executeUpdate(query2);
            statement3 = connection.createStatement();
            String query3 = "insert into owner (first_name, second_name, last_name, phonenumber, email, age, username, password, role) values ('" + fName + "', '" + mName + "', '" + lName + "', '" + phone + "', '" + owEmail + "', '" + age + "', '" + owUser + "', '" + owPass + "', '" + owner + "')";
            statement3.executeUpdate(query3);
        } finally {

            assert statement3 != null;

            statement3.close();
            statement2.close();
        }
        return true;
    }

    public boolean printTenant( String ffName, String mmName, String llName, String pPhone, String tenEmail, String age, String regNum, String major, String tenUser, String tenPass) throws SQLException {

        Statement statement3 = null;
        Statement statement4 = null;
        try (Connection connection = DriverManager.getConnection(url, username1, password1)) {
            statement3 = connection.createStatement();
            String query3 = "insert into login (username, password, role) values ('" + tenUser + "','" + tenPass + "', '" + tenant + "')";
            statement3.executeUpdate(query3);
            statement4 = connection.createStatement();
            String query4 = "insert into tenant (first_name, second_name, last_name, phonenumber, email, age, reg_num, major, username, password, role) values ('" + ffName + "', '" + mmName + "', '" + llName + "', '" + pPhone + "', '" + tenEmail + "', '" + age + "', '" + regNum + "', '" + major + "', '" + tenUser + "','" + tenPass + "', '" + tenant + "')";
            statement4.executeUpdate(query4);
        } finally {

            assert statement3 != null;

            statement3.close();
            assert statement4 != null;
            statement4.close();
        }
        return true;
    }

    public boolean failureReg(String tenUser, String tenPass) throws SQLException {

        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username1, password1)) {
            statement = connection.createStatement();
            String query = "select * from login where username = '" + tenUser + "'and password = '" + tenPass + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                reg = true;
            }
            resultSet.close();
        } finally {
            assert statement != null;

            statement.close();
        }
        return reg;
    }
}

