package loginfeature;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControlPanelFeature {

    ControlPanel obj=new ControlPanel();

    @Given("tenant choosed {string} to view control panel")
    public void tenantChoosedToViewControlPanelUsernameIs(String string) {

           assertTrue(string.equals("3"));

    }
    @Given("the tenant has house booked before username is {string}")
    public void theTenantHasHouseBookedBeforeUsernameIs(String string) throws SQLException {

    assertTrue(obj.isBooked(string));



    }
    @Then("the control panel will appear for tenant username {string}")
    public void theControlPanelWillAppear(String string) throws SQLException {
      assertTrue(obj.displayControlPanel(string));
    }

    @Given("tenant pressed {string} to view the control panel")
    public void tenantPressedToViewTheControlPanel(String arg0) {
      assertTrue(arg0.equals("3"));
    }

    @And("the tenant didnt booked before username is {string}")
    public void theTenantDidntBookedBeforeUsernameIs(String arg0) throws SQLException {
assertFalse(obj.isBooked(arg0));
    }

    @Then("the control panel will not appear for tenant username {string}")
    public void theControlPanelWillNotAppearForTenantUsername(String arg0) throws SQLException {
     assertFalse(obj.displayControlPanel(arg0));
    }


}
