package loginfeature;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HousingFeature {
    HousingEntity obj=new HousingEntity();


  
    @Given("the tenant choose {string} to view the available housing")
    public void theTenantChooseToViewTheAvailableHousing(String string) {
     
      
           assertTrue(string.equals("1"));
       
    }
    @Then("the Available housing appear")
    public void theAvailableHousingAppear() throws SQLException {
        int counter=obj.showAvailable();
            
                assertTrue(counter>1);
            



    }


    @Given("tenant wants to view the available housing he choosed {string}")
    public void tenantWantsToViewTheAvailableHousingHeChoosed(String arg0) {
    assertTrue(arg0.equals("1"));
    }

    @And("theres no available housing to view")
    public void theresNoAvailableHousingToView() {
        assertFalse(false);
    }

    @Then("the Available housing doesn't appear")
    public void theAvailableHousingDoesnTAppear() {
        assertFalse(false);
    }
}
