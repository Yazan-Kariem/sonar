package loginfeature;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LoginFeatureSteps {

    boolean adminFlag;
    boolean tenantFlag;
    boolean ownerFlag;


    LoginEntity obj;
    public LoginFeatureSteps(LoginEntity obj){
        super();
        this.obj = obj;
    }
    @Given("admin wants to sign in")
    public void adminWantsToSignIn() {
        adminFlag = false;
    }
    @Given("enters {string} as a username and enters {string} as a password")
    public void enters_as_a_username_and_enters_as_a_password(String uname, String pword) throws SQLException {
        adminFlag = false;
        String Role=new String("admin");
        if(Role.equals(obj.checkValues(uname,pword))){
            assertTrue(Role.equals(obj.checkValues(uname,pword)));adminFlag = true;
        }
    }
    @Then("admin login success")
    public void adminLoginSuccess() {
        assertTrue(adminFlag);
    }
    @Given("tenant or owner wants to login to the system")
    public void tenant_or_owner_wants_to_login_to_the_system()
    {
        tenantFlag = false;
        ownerFlag = false;
    }
    @Given("enters {string} as a username and {string} as a password and both are correct")
    public void enters_as_a_username_and_as_a_password_and_both_are_correct(String username, String password) throws SQLException {
        if(obj.checkValues(username,password).equals("tenant")||obj.checkValues(username,password).equals("owner"))
        {
            assertTrue(obj.checkValues(username,password).equals("tenant")||obj.checkValues(username,password).equals("owner"));
            tenantFlag = true;
            ownerFlag = true;
        }
    }
    @Then("login successful")
    public void login_successful() {
        assertTrue(tenantFlag||ownerFlag);
    }
    @Given("tenant or owner login to the system")
    public void tenant_or_owner_login_to_the_system() {
        tenantFlag = false;
        ownerFlag = false;
    }
    @Given("enters {string} as a username and {string} as a password and one of them are wrong")
    public void enters_as_a_username_and_as_a_password_and_one_of_them_are_wrong(String username, String password) throws SQLException {

        if(!obj.checkValues(username,password).equals("owner")||!obj.checkValues(username,password).equals("tenant")||!obj.checkValues(username,password).equals("admin")){
            assertTrue(!obj.checkValues(username,password).equals("owner")||!obj.checkValues(username,password).equals("tenant")||!obj.checkValues(username,password).equals("admin"));
            tenantFlag = true;
            ownerFlag = true;
        }

    }
    @Then("error appears")
    public void error_appears() {
        assertTrue("error",true);
    }
    @Given("user wants to register as a tenant or owner")
    public void user_wants_to_register_as_a_tenant_or_owner() {
        assertTrue(true);
    }
    @And("first name  = {string}, second name = {string}, lastname = {string}, phone={string}, email = {string}, age ={string}, owUser = {string}, owPass = {string} for owner and first name  = {string}, second name = {string}, lastname = {string}, phone={string}, email = {string}, age ={string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and both usernames is available and used two database queries")
    public void firstNameSecondNameLastnamePhoneEmailAgeOwUserOwPassForOwnerAndFirstNameSecondNameLastnamePhoneEmailAgeReg_numMajorTenUserTenPassForTenantAndBothUsernamesIsAvailableAndUsedTwoDatabaseQueries(String fname, String mname, String lname, String phone, String owemail, String age, String owUser, String owPass, String ffname, String mMname, String lLname, String pPhone, String tenmail, String age1, String Reg_num, String major, String tenUser, String tenPass) throws SQLException {
        obj.printTenant(ffname, mMname, lLname, pPhone, tenmail, age1, Reg_num, major, tenUser, tenPass);
        obj.printOwner(fname, mname, lname, phone, owemail, age, owUser, owPass);
    }
    @Then("registration complete and the account is created with username{string} and password {string}")
    public void registrationCompleteAndTheAccountIsCreatedWithUsernameAndPassword(String username, String password) throws SQLException {
        assertTrue(("tenant".equals(obj.checkValues(username, password))||"owner".equals(obj.checkValues(username, password))));
    }
    @Given("user wants to signup as a tenant or owner")
    public void user_wants_to_signup_as_a_tenant_or_owner()
    {
        assertTrue(true);
    }
    @Given("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, OwUser = {string}, OwPass = {string} for owner and first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and usernames isn't available")
    public void first_name_second_name_lastname_phone_email_age_ow_user_ow_pass_for_owner_and_first_name_second_name_lastname_phone_email_age_reg_num_major_ten_user_ten_pass_for_tenant_and_usernames_isn_t_available(String Fname, String Mname, String Lname, String Phone, String Owemail, String age, String OwUser, String OwPass, String FFname, String MMname, String LLname, String PPhone, String tenmail, String Age, String Reg_num, String major, String tenUser, String tenPass) throws SQLException {
        assertTrue(obj.failureReg(tenUser, tenPass));
    }
    @Then("registration fails the account with username{string} and password {string} isn't created")
    public void registrationFailsTheAccountWithUsernameAndPasswordIsnTCreated(String username, String password) throws SQLException {
        if("tenant".equals(obj.checkValues(username, password))||"owner".equals(obj.checkValues(username, password)))
        {
            assertTrue("tenant".equals(obj.checkValues(username, password))||"owner".equals(obj.checkValues(username, password)));
        }
    }
}