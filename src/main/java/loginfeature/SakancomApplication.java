package loginfeature;
import java.util.Scanner;
import java.util.logging.Logger;

public class SakancomApplication{

    public static void main(String[] args) {
       Logger logger = Logger.getLogger(SakancomApplication.class.getName());
        String line="_____________________________________________";
        while(true){
logger.info(line);
            logger.info("Choose from the following ");
            logger.info("1-Login");
            logger.info("2-Signup");
            logger.info("The Value : ");
            Scanner input = new Scanner(System.in);
            int loginOrSignUp = 0;
            loginOrSignUp = input.nextInt();
            logger.info(line);
            if (loginOrSignUp == 1) {
                logger.info("\n******* Login Page *******\n");
                LoginEntity in=new LoginEntity();

                Scanner input1 = new Scanner(System.in);
                logger.info("Enter User Name : ");
                in.userName = input1.nextLine();
                logger.info("Enter the Password : ");
                in.password = input1.nextLine();
                String role= in.checkValues(in.userName,in.password);


                if(role.equals("tenant")){
while(true){

    logger.info(line);
    logger.info("Choose from the following");
    logger.info("1-View the available housing");
    logger.info("2-Furniture");
    logger.info("3-Control Panel");
    logger.info("4-ShowLivedIn");
    logger.info("5-Sign out");
    Scanner input2=new Scanner(System.in);
    int choose=input2.nextInt();
    logger.info(line);
    if(choose==1){
        HousingEntity e=new HousingEntity();
       int avb= e.showAvailable();
       if(avb>1){
           logger.info("do you want to book  accommodation? (Yes or No)");
        Scanner inp=new Scanner(System.in);

       String yn=inp.nextLine();
        if(yn.equals("Yes")){
            logger.info("Enter house ID : ");
            Scanner ids = new Scanner(System.in);
            String id = ids.nextLine();
            e.booking(id,in.userName);

        }}
    }
if(choose==2) {
    while (true) {
        logger.info(line);
        logger.info("Choose from the following");
        logger.info("1-View the available Furnitures");
        logger.info("2-Add Furnitures");
        logger.info("3-Sell Furnitures");
        logger.info("4-Back");
        Scanner inp = new Scanner(System.in);
        int ch = inp.nextInt();
        logger.info(line);
        Furniture o = new Furniture();
        if (ch == 1) {
            o.displayFurniture(in.userName);

        } else if (ch == 2) {
            Scanner inp1 = new Scanner(System.in);
            logger.info("Enter Picture : ");
            o.picture = inp1.nextLine();
            logger.info("Enter Description : ");
            o.description = inp1.nextLine();
            logger.info("Enter Price : ");
            o.price = inp1.nextLine();
            logger.info("Enter ID : ");
            o.id = inp1.nextLine();
            o.selled = "No";
            o.addFurniture(in.userName, o.picture, o.description, o.price, o.id, o.selled);

        } else if (ch == 3) {
            Scanner inp1 = new Scanner(System.in);
            logger.info("Enter ID to sell: ");
            o.id = inp1.nextLine();
            o.sellFurniture(o.id, in.userName);

        }


        else if (ch == 4) {
            break;
        }

    }
} else if (choose==3) {
ControlPanel e=new ControlPanel();
e.displayControlPanel(in.userName);
}
else if(choose==4){
    logger.info("Enter House id you want to show:");
    Scanner in1=new Scanner(System.in);
    String id=in1.nextLine();
    ShowLivedIn e=new ShowLivedIn();
    e.displayLived(id);
}

else if (choose==5) {
    break;
}
}

                }
                else if(role.equals("owner")){
                }
                else if (role.equals("admin")) {

                }

                logger.info(line);
            }

            else if (loginOrSignUp==2) {

            }
        }
    }
}