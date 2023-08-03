package loginfeature;

import io.cucumber.java.an.E;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class ControlPanel {
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    private static final Logger logger = Logger.getLogger(ControlPanel.class.getName());

    public boolean isBooked(String userName) throws Exception {



      Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String query = "Select * from booking where tenantUserName='"+userName+"'" ;
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return true;
            }
            connection.close();
            res.close();





            return false;

    }

    public boolean displayTenantInfo(String userName) throws Exception{

        if(isBooked(userName)){

                Connection connection = DriverManager.getConnection(url, username, password);

                    Statement statement = connection.createStatement();

                    String query="Select * from tenant where username='"+userName+"'";
                    ResultSet res=statement.executeQuery(query);
                    System.out.println("Personal Information : ");
                while (res.next()){
                    String name="Name : "+res.getString(1)+" "+res.getString(2)+" "+res.getString(3);
                    String phoneNumber="Phone Number : "+res.getString(4);
                    String email="Email : "+res.getString(5);
                    String age="Age : "+res.getString(6);
                    String registrationNumber="Registration Number : "+res.getString(7);
                    String major="Major : "+res.getString(8);
                    logger.info(name);
                    logger.info(phoneNumber);
                    logger.info(email);
                    logger.info(age);
                    logger.info(registrationNumber);
                    logger.info(major);
                    System.out.println("_____________________________________________");
                    return true;



            }



        }
        return false;
    }

    public boolean displayOwnerInfo(String userName){
        String ownerName=new String(getOwnerName(userName));

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();

           String  query = "Select * from owner where username='" + ownerName + "'";

            ResultSet re = statement.executeQuery(query);

            logger.info("Owner information:");
            while (re.next()) {
                String ownerNamep="Owner Name : "+re.getString(1)+" "+re.getString(2)+" "+re.getString(3);
                String age="Age : "+re.getString(4);
                String phoneNumber="Phone Number : "+re.getString(5);
                String email="Email : "+re.getString(6);
               logger.info(ownerNamep);
               logger.info(age);
                logger.info(phoneNumber);
               logger.info(email);

                return true;
            }

        }
        catch (Exception e){

        }
        return false;
    }

    public String getOwnerName(String userName){


        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();

            String query = "Select * from booking where tenantUserName='" + userName + "'";
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return res.getString(3);
            }

        }
        catch (Exception e){

        }
        return "null";

        }

        public String getHouseID(String userName) throws Exception{


        Connection connection = DriverManager.getConnection(url, username, password);

                Statement statement = connection.createStatement();

                String  query = "Select * from booking where tenantUserName='"+userName+"'" ;
                ResultSet res = statement.executeQuery(query);
                while (res.next()){
                    return res.getString(1);
                }



return "null";
        }
        public boolean displayRent(String userName) throws Exception {
        String id=new String(getHouseID(userName));

          Connection connection = DriverManager.getConnection(url, username, password);

                Statement statement = connection.createStatement();

                String query = "Select * from housing where ID='" + id + "'";
                ResultSet res = statement.executeQuery(query);
                while (res.next()) {
                    String rent="Rent : "+res.getString(13);
                   logger.info(rent);
return true;
                }



            return false;
        }
public boolean displayControlPanel(String userName) throws Exception {
int flag=0;
int flag1=0;
int flag2=0;
if(displayTenantInfo(userName)){
    flag=1;
}
if(displayOwnerInfo(userName)){
    flag1=1;
}
if(displayRent(userName)){
    flag2=1;
}
if(flag==1 && flag1==1 && flag2==1){

    return true;
}
return false;
}



}
