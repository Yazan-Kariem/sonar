package loginfeature;


import java.sql.*;
import java.util.logging.Logger;

public class ControlPanel {
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    private static final Logger logger = Logger.getLogger(ControlPanel.class.getName());
String select="Select * from booking where tenantUserName='";
    public boolean isBooked(String userName) throws SQLException {

        Connection connection = null;
        ResultSet res = null;
        try {

            connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String query = select + userName + "'";
            res = statement.executeQuery(query);
            while (res.next()) {
                return true;
            }


        } finally {
            connection.close();
            res.close();

        }
        return false;
    }

    public boolean displayTenantInfo(String userName) throws SQLException{

        if(isBooked(userName)){

                Connection connection = DriverManager.getConnection(url, username, password);

                    Statement statement = connection.createStatement();

                    String query="Select * from tenant where username='"+userName+"'";
                    ResultSet res=statement.executeQuery(query);
                   logger.info("Personal Information : ");
                while (res.next()){///
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
                    logger.info("_____________________________________________");
                    return true;



            }



        }
        return false;
    }

    public boolean displayOwnerInfo(String userName) throws SQLException{
        String ownerName=(getOwnerName(userName));

       Connection connection = DriverManager.getConnection(url, username, password);

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


        return false;
    }

    public String getOwnerName(String userName) throws SQLException{


       Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String query = select + userName + "'";
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return res.getString(3);
            }


        return "null";

        }

        public String getHouseID(String userName) throws SQLException{


        Connection connection = DriverManager.getConnection(url, username, password);

                Statement statement = connection.createStatement();

                String  query = select+userName+"'" ;
                ResultSet res = statement.executeQuery(query);
                while (res.next()){
                    return res.getString(1);
                }



return "null";
        }
        public boolean displayRent(String userName) throws SQLException {
        String id=(getHouseID(userName));

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
public boolean displayControlPanel(String userName) throws SQLException {
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
}else{return false;}


}



}
