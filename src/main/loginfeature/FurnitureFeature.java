package loginfeature;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FurnitureFeature {
Furniture obj=new Furniture();
    @Given("tenant typed {int} to view his furnitures")
    public void tenantTypedToViewHisFurnitures(Integer int1) {

            assertTrue(int1==1);

    }
    boolean avb=false;
    @Given("the tenant has available furnitures the tenant username is {string}")
    public void theTenantHasAvailableFurnitures(String string) throws SQLException {
      boolean flag= obj.checkAvailability(string);
        assertTrue(flag);
      if(flag){
          avb=true;

      }

    }
    @Then("the program will appear the furnitures for username {string}")
    public void theProgramWillAppearTheFurnitures(String string) throws SQLException {
       assertTrue(obj.displayFurniture(string));

    }

    @Given("tenant typed {int} to show his furnitures")
    public void tenantTypedToShowHisFurnitures(Integer int1) {
      assertTrue(int1==1);
    }
    boolean avb1=false;
    @Given("the tenant doesn't have available furnitures the tenant username is {string}")
    public void theTenantDoesnTHaveAvailableFurnitures(String string) throws SQLException {
        boolean flag=obj.checkAvailability(string);
      assertFalse(flag);
    }
    @Then("the program will not appear the furnitures for username {string}")
    public void theProgramWillNotAppearTheFurnitures(String string) throws SQLException {
       assertFalse(obj.displayFurniture(string));
    }
    @Given("tenant typed {string} to choose add option to add furniture")
    public void tenantWantsToAddFurniture(String string) {
     assertTrue(string.equals("2"));
    }

    @Then("the program will appear window to add furniture has these informations username is {string} and Picture is {string} and Description is {string} and Price is {string} and ID is {string} and selled is {string}")
    public void theProgramWillAppearWindowToAddFurnitureHasTheseInformationsUsernameIsAndPrictureIsAndDescriptionIsAndPriceIsAndIDIsAndSelledIs(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws SQLException {
        boolean flag= obj.addFurniture(arg0, arg1, arg2, arg3, arg4, arg5);
       assertTrue(flag);
    }

    @Given("tenant typed {string} to Sell his furniture id is {string}")
    public void tenantTypedToSellHisFurnitureIdIs(String arg0, String arg1) {
      assertTrue(arg0.equals("3" )&& arg1.equals("1"));
    }

    @And("furniture id is {string} its available to sell and the tenant username is {string}")
    public void furnitureIdIsItsAvailableToSellAndTheTenantUsernameIs(String arg0, String arg1) throws SQLException {
    boolean flag= obj.checkAvailability(arg1,arg0);
   assertTrue(flag);

    }


    @Then("the program will sell the furniture id {string} username is {string}")
    public void theProgramWillSellTheFurnitureId(String arg0,String arg1) throws SQLException {
      assertTrue(obj.sellFurniture(arg0,arg1));
    }


    @Given("tenant typed {string} to sell his furniture id is {string}")
    public void tenantTypedToSellHisFurnitureIdIs1(String arg0, String arg1) {
      assertTrue(arg0.equals("3" )&& arg1.equals("2"));
    }

    @And("furniture id is {string} its not available to sell and the tenant username is {string}")
    public void furnitureIdIsItsNotAvailableToSellAndTheTenantUsernameIs(String arg0, String arg1) throws SQLException {
        boolean flag= obj.checkAvailability(arg1,arg0);
       assertFalse(flag);
    }

    @Then("the program will not sell the furniture id {string} username is {string}")
    public void theProgramWillNotSellTheFurnitureId(String arg0,String arg1) throws SQLException {
      assertFalse(obj.sellFurniture(arg1,arg0));
    }


    @And("if the id duplicated is added before it will not added it username is {string} and Picture is {string} and Description is {string} and Price is {string} and ID is {string} and selled is {string}")
    public void ifTheIdDuplicatedIsAddedBeforeItWillNotAddedItUsernameIsAndPictureIsAndDescriptionIsAndPriceIsAndIDIsAndSelledIs(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws SQLException {
    assertFalse(obj.addFurniture(arg0, arg1, arg2, arg3, arg4, arg5));
    }
}
