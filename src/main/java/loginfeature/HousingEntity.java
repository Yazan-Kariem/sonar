package loginfeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class HousingEntity {
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    Logger logger = Logger.getLogger(HousingEntity.class.getName());
String wid="' where id='";

    public int showAvailable() {

        int counter = 1;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();

           String query = "Select * from housing where available='Yes' and accept='true'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {


                logger.info(counter + "-");
                logger.info("ID : {}" +resultSet.getString(8) );
                logger.info("Picture : {}" + resultSet.getString(1));
                logger.info("Price : {}" + resultSet.getString(2));
                logger.info("Location : {}" + resultSet.getString(3));
                logger.info("Services : {}" + resultSet.getString(4));
                logger.info("Number of people lived in : {}" + resultSet.getString(11));
                logger.info("Floor Number: {}" + resultSet.getString(9));
                logger.info("Department Name : {}" + resultSet.getString(10));


                counter++;
                logger.info("_____________________________________________");

            }
        } catch (Exception e) {

        }
        return counter;
    }

    public boolean availableWithID(String id){

        int counter = 1;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();

            String query = "Select * from housing where id='"+id+"' and available='Yes'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                counter++;
            }}
        catch (Exception E){

        }
        if(counter>1){
            return true;
        }
        return false;

            }

            public boolean booking(String id,String userName){
        int flag1=0;
        int flag=0;
                try {
                    Integer.parseInt(id);
                    flag1 = 1;
                } catch (Exception ex) {

                }
                if (flag1 == 1 ) {

                    try (Connection connection = DriverManager.getConnection(url, username, password)) {

                        Statement statement = connection.createStatement();
                        Statement statement1 = connection.createStatement();
                        Statement statement2 = connection.createStatement();

                       String query="select * from housing where id='" + id + "'and available ='Yes'";
                        ResultSet res=statement.executeQuery(query);

                       while(res.next()){
                     int num=      Integer.parseInt(res.getString(11));

                           if(num<4){
                               num++;
                               String n=Integer.toString(num);
                               if(num==4){
                                   query="update housing set peopleNum='"+n+"',available='No',tenant='"+userName+wid+id+"'";
                                   statement1.executeUpdate(query);
flag=1;

                               }else{
                                   query="update housing set peopleNum='"+n+"',tenant='"+userName+wid+id+"'";
                                   statement1.executeUpdate(query);
                                   flag=1;
                               }
                               query="insert into booking (tenantUserName,houseID,Owner) value ('"+userName+"','"+id+"','"+res.getString(6)+"')";

                               statement1.executeUpdate(query);
                               query="insert into Tenants_Housing (tenantUserName,HouseID) value ('"+userName+"','"+id+"')";
                               statement2.executeUpdate(query);
                               flag=1;
                           }
                           else{

                                 query = "update housing set available='No',peopleNum='+"+num+"',tenant='"+userName+wid + id + "'";
                               statement1.executeUpdate(query);
                               flag=1;
                           }

                       }



                        if (flag==1) {
                            return true;
                        }
                    } catch (Exception e) {


                    }
                }
           return false;
}

}