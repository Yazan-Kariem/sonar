package testcode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import productioncode.ShowLivedIn;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ShowLivedInFeature {
    ShowLivedIn obj=new ShowLivedIn();
    @Given("tenant pressed {string} to view peoples lived in houses")
    public void tenantPressedToViewPeoplesLivedInHouses(String arg0) {

        assertEquals("4", arg0);

    }

    @And("theres peoples in houses id {string}")
    public void theresPeoplesInHousesId(String arg0) throws SQLException {

            assertTrue(obj.isLived(arg0));


    }

    @Then("the peoples username will appear in house id {string}")
    public void thePeoplesUsernameWillAppear(String string) throws SQLException {

            assertTrue(obj.displayLived(string));

    }

    @Given("tenant pressed {string} to view peoples who lived in house")
    public void tenantPressedToViewPeoplesWhoLivedInHouse(String arg0) {

        assertEquals("4", arg0);

    }
    @And("theres no peoples in houses id {string}")
    public void theresNoPeoplesInHousesId(String arg0) throws SQLException {

        assertFalse(obj.isLived(arg0));

    }

    @Then("this peoples username will not appear in house id {string}")
    public void thisPeoplesUsernameWillNotAppear(String string) throws SQLException {

        assertFalse(obj.displayLived(string));


    }



}
