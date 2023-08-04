package loginfeature;

import java.sql.*;

public class LoginEntity {

    boolean Owner = false;
    boolean reg = false;
    boolean Tenant = false;
    boolean adminUsername, adminPassword,adminFlag;
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password1 = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    String tenant = "tenant";
    String owner = "owner";

    String userName, Password, Role;

    public  String checkValues(String UserName,String Password) {

        try (Connection connection = DriverManager.getConnection(url, username, password1)) {
            Statement statement = connection.createStatement();
            if (UserName.isEmpty() == true || Password.isEmpty() == true) {
            } else {
                int flag = 0;
                String query = "SELECT * FROM login where username='"+UserName+"' and password='"+Password+"'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    flag = 1;
                    if (resultSet.getString(3).equalsIgnoreCase("tenant")) {Role="tenant";} else if (resultSet.getString(3).equalsIgnoreCase("admin")) {Role="admin";} else if (resultSet.getString(3).equalsIgnoreCase("owner")) {Role="owner";}
                }
                if (flag == 0) {
                    Role="null";
                }
            }
        } catch (Exception ex) {}return Role;
    }

    public boolean printOwner(String fName, String mName, String lName, String Phone, String owEmail, String age, String owUser, String owPass) {
        try (Connection connection = DriverManager.getConnection(url, username, password1)) {
            Statement statement2 = connection.createStatement();
            String query2 = "insert into login (username, password, role) values ('"+owUser+"', '"+owPass+"', '"+owner+"')";statement2.executeUpdate(query2);Statement statement3 = connection.createStatement();String query3 = "insert into owner (first_name, second_name, last_name, phonenumber, email, age, username, password, role) values ('"+fName+"', '"+mName+"', '"+lName+"', '"+Phone + "', '"+owEmail+"', '"+age+"', '"+owUser+"', '"+owPass+"', '"+owner+"')";statement3.executeUpdate(query3);Owner = true;} catch (SQLException e) {}
        return Owner;
    }

    public boolean printTenant( String ffName, String mmName, String llName, String PPhone, String tenEmail, String Age, String Reg_num, String major, String tenUser, String tenPass) {
        String tenant = "tenant";
        try (Connection connection = DriverManager.getConnection(url, username, password1)) {
            Statement statement3 = connection.createStatement();
            String query3 = "insert into login (username, password, role) values ('"+tenUser+"','"+tenPass+"', '"+tenant+"')";statement3.executeUpdate(query3);Statement statement4 = connection.createStatement();String query4 = "insert into tenant (first_name, second_name, last_name, phonenumber, email, age, reg_num, major, username, password, role) values ('"+ffName+"', '"+mmName+"', '"+llName+"', '"+PPhone+"', '"+tenEmail+"', '"+Age+"', '"+Reg_num+"', '"+major+"', '"+tenUser+"','"+tenPass+"', '"+tenant+"')";statement4.executeUpdate(query4);Tenant = true;} catch (SQLException e) {}
        return Tenant;
    }

    public boolean failureReg(String tenUser, String tenPass) {

        try (Connection connection = DriverManager.getConnection(url, username, password1)) {
            Statement statement = connection.createStatement();
            String query = "select * from login where username = '"+tenUser+"'and password = '"+tenPass+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                reg = true;
            }
        } catch (SQLException e) {
        }return reg;
    }
}

