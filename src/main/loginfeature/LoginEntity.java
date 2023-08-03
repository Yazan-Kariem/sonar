package loginfeature;

import java.sql.*;
import java.util.logging.Logger;

public class LoginEntity {

    boolean owner = false;
    boolean reg = false;

    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password1 = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
String tenant1="tenant";

    String userName;
            String password;
                    String role;
    Logger logger = Logger.getLogger(LoginEntity.class.getName());
    public  String checkValues(String userName,String password) {

        try (Connection connection = DriverManager.getConnection(url, username, password1)) {
            Statement statement = connection.createStatement();
            if (userName.isEmpty() == true || password.isEmpty() == true) {
                logger.info("Wrong input");
            } else {
                int flag = 0;
                String query = "SELECT * FROM login where username='" + userName + "'" + " and password='" + password + "'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {

                    //check if no data

                    flag = 1;
                    if (resultSet.getString(3).equals(tenant1)) {
                        role =tenant1;

                        return role;
                    } else if (resultSet.getString(3).equals("admin")) {
                        role ="admin";
                        return role;
                    } else if (resultSet.getString(3).equals("owner")) {
                        role ="owner";
                        return role;
                    } else {
                        role ="null";
                        return role;
                    }




                }
                if (flag == 0) {
                    role ="null";

                    logger.info("Theres no user in the system has matching with information you inter create new account please");
                    return role;
                }
                //sdads
            }


            connection.close();
        } catch (Exception ex) {

        }




        return role;
    }


    public boolean printOwner(String fname, String mname, String lname, String phone, String owemail, String age, String owUser, String owPass) {
        logger.info("_____________________________________________");
        logger.info("Choose from the following ");
        logger.info("1-Login");
        logger.info("2-Signup");
        logger.info("The Value : ");
        logger.info("_____________________________________________");
        String owner = "owner";
        logger.info("________________Signup as Owner________________");
        logger.info("Please enter your First name: " + fname+ "\n");
        logger.info("Please enter your Middle name name: " + mname + "\n");
        logger.info("Please enter your Last name: " + lname + "\n");
        logger.info("Please enter your Phone number: " + phone + "\n");
        logger.info("Please enter your Email: " + owemail + "\n");
        logger.info("Please enter your age: " + age + "\n");
        logger.info("Please enter your username: " + owUser + "\n");
        logger.info("Please enter your password: " + owPass + "\n");
        logger.info("_____________________________________________");
        try (Connection connection = DriverManager.getConnection(url, username, password1)) {
            Statement statement2 = connection.createStatement();
            String query2 = "insert into login (username, password, role) values ('"+owUser+"', '"+owPass+"', '"+owner+"')";
            statement2.executeUpdate(query2);
            Statement statement3 = connection.createStatement();
            String query3 = "insert into owner (first_name, second_name, last_name, phonenumber, email, age, username, password, role) values ('"+fname+"', '"+mname+"', '"+lname+"', '"+phone + "', '"+owemail+"', '"+age+"', '"+owUser+"', '"+owPass+"', '"+owner+"')";
            statement3.executeUpdate(query3);
            logger.info("Creating Owner Account...");
            logger.info("_____________________________________________");
            this.owner = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.owner;
    }

    public boolean printTenant( String fFname, String mMname, String lLname, String pPhone, String tenemail, String age, String regNum, String major, String tenUser, String tenPass) {
        System.out.println("________________Signup as Tenant________________");
        String tenant = tenant1;
        System.out.println("Please enter your First name: "+fFname+"\n");
        System.out.println("Please enter your Middle name name: "+mMname+"\n");
        System.out.println("Please enter your Last name: "+lLname+"\n");
        System.out.println("Please enter your Phone number: "+pPhone+"\n");
        System.out.println("Please enter your Email: "+tenemail+"\n");
        System.out.println("Please enter your age: "+age+"\n");
        System.out.println("Please enter your Registration number: "+regNum+"\n");
        System.out.println("Please enter your major: "+major+"\n");
        System.out.println("Please enter your username: "+tenUser+"\n");
        System.out.println("Please enter your password: "+tenPass+"\n");
        System.out.println("_____________________________________________");
        try (Connection connection = DriverManager.getConnection(url, username, password1)) {
            Statement statement3 = connection.createStatement();
            String query3 = "insert into login (username, password, role) values ('"+tenUser+"','"+tenPass+"', '"+tenant+"')";
            statement3.executeUpdate(query3);
            Statement statement4 = connection.createStatement();
            String query4 = "insert into tenant (first_name, second_name, last_name, phonenumber, email, age, reg_num, major, username, password, role) values ('" + fFname + "', '" + mMname + "', '" + lLname + "', '" + pPhone + "', '" + tenemail + "', '" + age + "', '" + regNum + "', '" + major + "', '" + tenUser + "','" + tenPass + "', '" + tenant + "')";
            statement4.executeUpdate(query4);
            logger.info("Creating Tenant Account...");
            logger.info("_____________________________________________");
          return true;
            }
        catch (SQLException e) {

            return false;
        }


    }
    public void logout()
    {
        logger.info("_____________________________________________");
        logger.info("Choose from the following ");
        logger.info("7-logout");
        logger.info("The Value : ");
        logger.info("_____________________________________________");
        logger.info("\n******* information *******\n");
        logger.info("_____________________________________________");
        logger.info("___________Logged out Successfully___________");
        logger.info("_____________________________________________");
    }
    public boolean failureReg(String fFname, String mMname, String lLname, String pPhone, String tenmail, String age, String regNum, String major, String tenUser, String tenPass) {
        logger.info("________________Signup as Tenant________________");

        logger.info("Please enter your First name: "+fFname+"\n");
        logger.info("Please enter your Middle name name: "+mMname+"\n");
        logger.info("Please enter your Last name: "+lLname+"\n");
        logger.info("Please enter your Phone number: "+pPhone+"\n");
        logger.info("Please enter your Email: "+tenmail+"\n");
        logger.info("Please enter your age: "+age+"\n");
        logger.info("Please enter your Registration number: "+regNum+"\n");
        logger.info("Please enter your major: "+major+"\n");
        logger.info("Please enter your username: "+tenUser+"\n");
        logger.info("Please enter your password: "+tenPass+"\n");
        logger.info("_____________________________________________");
        try (Connection connection = DriverManager.getConnection(url, username, password1)) {
            Statement statement = connection.createStatement();
            String query = "select * from login where username = '"+tenUser+"'and password = '"+tenPass+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                reg = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reg;
    }

}

