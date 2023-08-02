package loginfeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControlPanel {

    public boolean isBooked(String userName){


        String host = "localhost";
        int port = 3306;
        String database = "sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();
            String query = new String();
            query = "Select * from booking where tenantUserName='"+userName+"'" ;
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return true;
            }
            connection.close();
            res.close();

        }
        catch (Exception e){

        }


            return false;

    }

    public boolean displayTenantInfo(String userName) {

        if(isBooked(userName)){

               String host = "localhost";
                int port = 3306;
                String database = "sakancom";
                String username = "root";
                String password = "password";
                String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

                try (Connection connection = DriverManager.getConnection(url, username, password)) {

                    Statement statement = connection.createStatement();
                    String query = new String();
                    query="Select * from tenant where username='"+userName+"'";
                    ResultSet res=statement.executeQuery(query);
                    System.out.println("Personal Information : ");
                while (res.next()){
                    System.out.println("Name : "+res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
                    System.out.println("Phone Number : "+res.getString(4));
                    System.out.println("Email : "+res.getString(5));
                    System.out.println("Age : "+res.getString(6));
                    System.out.println("Registration Number : "+res.getString(7));
                    System.out.println("Major : "+res.getString(8));
                    System.out.println("_____________________________________________");
                    return true;
                }


            }
            catch (Exception e){

            }


        }
        return false;
    }

    public boolean displayOwnerInfo(String userName){
        String ownerName=new String(getOwnerName(userName));
        String host = "localhost";
        int port = 3306;
        String database = "sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();
            String query = new String();
            query = "Select * from owner where username='" + ownerName + "'";
            System.out.println(query);
            ResultSet re = statement.executeQuery(query);
            System.out.println(ownerName);
            System.out.println("Owner information:");
            while (re.next()) {
                System.out.println("Owner Name : "+re.getString(1)+" "+re.getString(2)+" "+re.getString(3));
                System.out.println("Age : "+re.getString(4));
                System.out.println("Phone Number : "+re.getString(5));
                System.out.println("Email : "+re.getString(6));

                return true;
            }

        }
        catch (Exception e){

        }
        return false;
    }

    public String getOwnerName(String userName){

        String host = "localhost";
        int port = 3306;
        String database = "sakancom";
        String username = "root";
        String password = "password";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();
            String query = new String();
            query = "Select * from booking where tenantUserName='" + userName + "'";
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                return res.getString(3);
            }

        }
        catch (Exception e){

        }
        return "null";

        }

        public String getHouseID(String userName){

            String host = "localhost";
            int port = 3306;
            String database = "sakancom";
            String username = "root";
            String password = "password";
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                Statement statement = connection.createStatement();
                String query = new String();
                query = "Select * from booking where tenantUserName='"+userName+"'" ;
                ResultSet res = statement.executeQuery(query);
                while (res.next()){
                    return res.getString(1);
                }

            }
            catch (Exception e){

            }

return "null";
        }
        public boolean displayRent(String userName){
        String id=new String(getHouseID(userName));
            String host = "localhost";
            int port = 3306;
            String database = "sakancom";
            String username = "root";
            String password = "password";
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                Statement statement = connection.createStatement();
                String query = new String();
                query = "Select * from housing where ID='" + id + "'";
                ResultSet res = statement.executeQuery(query);
                while (res.next()) {
                    System.out.println("Rent : "+res.getString(13));
return true;
                }

            }
            catch (Exception e){

            }
            return false;
        }
public boolean displayControlPanel(String userName){
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
