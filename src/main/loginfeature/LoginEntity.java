package loginfeature;

import java.sql.*;

public class LoginEntity {


    boolean reg = false;


    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password1 = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

    String owner = "owner";

    String userName;
    String password;
    String role;

    public  String checkValues(String UserName,String password) throws SQLException{

        Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement = connection.createStatement();
            if(!UserName.isEmpty() && !password.isEmpty()){

                String query = "SELECT * FROM login where username='"+UserName+"' and password='"+password+"'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {

                    if (resultSet.getString(3).equalsIgnoreCase("tenant")) {
                        role ="tenant";} else if (resultSet.getString(3).equalsIgnoreCase("admin")) {
                        role ="admin";} else if (resultSet.getString(3).equalsIgnoreCase("owner")) {
                        role ="owner";}
                }

            }else {role ="null";}

       return role;
    }

    public boolean printOwner(String fName, String mName, String lName, String phone, String owEmail, String age, String owUser, String owPass) throws SQLException{
    Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement2 = connection.createStatement();
            String query2 = "insert into login (username, password, role) values ('"+owUser+"', '"+owPass+"', '"+owner+"')";statement2.executeUpdate(query2);Statement statement3 = connection.createStatement();String query3 = "insert into owner (first_name, second_name, last_name, phonenumber, email, age, username, password, role) values ('"+fName+"', '"+mName+"', '"+lName+"', '"+phone + "', '"+owEmail+"', '"+age+"', '"+owUser+"', '"+owPass+"', '"+owner+"')";statement3.executeUpdate(query3);
        return true;
    }

    public boolean printTenant( String ffName, String mmName, String llName, String PPhone, String tenEmail, String age, String regNum, String major, String tenUser, String tenPass) throws SQLException{
        String tenant = "tenant";
      Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement3 = connection.createStatement();
            String query3 = "insert into login (username, password, role) values ('"+tenUser+"','"+tenPass+"', '"+tenant+"')";statement3.executeUpdate(query3);Statement statement4 = connection.createStatement();String query4 = "insert into tenant (first_name, second_name, last_name, phonenumber, email, age, reg_num, major, username, password, role) values ('"+ffName+"', '"+mmName+"', '"+llName+"', '"+PPhone+"', '"+tenEmail+"', '"+age+"', '"+regNum+"', '"+major+"', '"+tenUser+"','"+tenPass+"', '"+tenant+"')";statement4.executeUpdate(query4);

        return true;
    }

    public boolean failureReg(String tenUser, String tenPass) throws SQLException{

      Connection connection = DriverManager.getConnection(url, username, password1);
            Statement statement = connection.createStatement();
            String query = "select * from login where username = '"+tenUser+"'and password = '"+tenPass+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                reg = true;
            }
       return reg;
    }
}

