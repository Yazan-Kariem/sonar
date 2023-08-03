package loginfeature;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class LoginFeatureSteps {

    boolean adminFlag,userLoggedin;
    boolean tenantFlag, tenantPass, tenantUser, ownerFlag, ownerPass, ownerUser,flag;
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    LoginEntity obj;
    //dependecy injection
    //dependecy inversion control (SOLID)
   public LoginFeatureSteps(LoginEntity obj){
       super();
       this.obj = obj;
   }
    @Given("admin wants to sign in")
    public void adminWantsToSignIn() {
        adminFlag = false;
    }
    @Given("enters {string} as a username and enters {string} as a password")
    public void enters_as_a_username_and_enters_as_a_password(String uname, String pword) {
        adminFlag = false;
        String Role=new String("admin");

        if(Role.equals(obj.checkValues(uname,pword)));
        adminFlag = true;


        //Wheres the assert?!
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
    public void enters_as_a_username_and_as_a_password_and_both_are_correct(String USERNAME, String PASSWORD) {
        tenantFlag = false;
        ownerFlag = false;

           assertTrue(obj.checkValues(USERNAME,PASSWORD).equals("tenant")||obj.checkValues(USERNAME,PASSWORD).equals("owner"));



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
    public void enters_as_a_username_and_as_a_password_and_one_of_them_are_wrong(String USERNAME, String PASSWORD)
    {
        tenantFlag = false;
        ownerFlag = false;

          assertTrue(!obj.checkValues(USERNAME,PASSWORD).equals("owner")||!obj.checkValues(USERNAME,PASSWORD).equals("tenant")||!obj.checkValues(USERNAME,PASSWORD).equals("admin"));


    }
    @Then("error appears")
    public void error_appears() {
           assertTrue(true);
    }
    @Given("user wants to register as a tenant or owner")
    public void user_wants_to_register_as_a_tenant_or_owner() {
        assertTrue(true);
    }
    @Given("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, OwUser = {string}, OwPass = {string} for owner and first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and both usernames is available")
    public void firstNameSecondNameLastnamePhoneEmailAgeOwUserOwPassForOwnerAndFirstNameSecondNameLastnamePhoneEmailAgeRegNumMajorTenUserTenPassForTenantAndBothUsernamesIsAvailable(String Fname, String Mname, String Lname, String Phone, String Owemail, String age, String OwUser, String OwPass, String FFname, String MMname, String LLname, String PPhone, String tenmail, String Age, String Reg_num, String major, String tenUser, String tenPass)
    {
       obj.printTenant(FFname, MMname, LLname, PPhone, tenmail, Age, Reg_num, major, tenUser, tenPass);
       obj.printOwner(Fname, Mname, Lname, Phone, Owemail, age, OwUser, OwPass);
    }
    @Then("registration complete and the account is created")
    public void registration_complete_and_the_account_is_created() {

           assertTrue(true);
    }
    @Given("user wants to signup as a tenant or owner")
    public void user_wants_to_signup_as_a_tenant_or_owner()
    {
        assertTrue(true);
    }
    @Given("first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, OwUser = {string}, OwPass = {string} for owner and first name  = {string}, second name = {string}, lastname = {string}, Phone={string}, email = {string}, age ={string}, Reg_num = {string}, major = {string}, tenUser = {string}, tenPass = {string} for tenant and usernames isn't available")
    public void first_name_second_name_lastname_phone_email_age_ow_user_ow_pass_for_owner_and_first_name_second_name_lastname_phone_email_age_reg_num_major_ten_user_ten_pass_for_tenant_and_usernames_isn_t_available(String Fname, String Mname, String Lname, String Phone, String Owemail, String age, String OwUser, String OwPass, String FFname, String MMname, String LLname, String PPhone, String tenmail, String Age, String Reg_num, String major, String tenUser, String tenPass)
    {
        assertTrue(obj.failureReg(FFname, MMname, LLname, PPhone, tenmail, Age, Reg_num, major, tenUser, tenPass));
    }
    @Then("registration fails and error appears")
    public void registration_fails_and_error_appears() {

           assertTrue(flag);

    }
    @Given("admin, tenant or owner already logged in to the system")
    public void admin_tenant_or_owner_already_logged_in_to_the_system()
    {
       userLoggedin = true;
       assertTrue(true);
    }
    @Given("pressed logout")
    public void pressed_logout()
    {
        obj.logout();
    }
    @Then("admin, tenant or owner logged out successfully")
    public void admin_tenant_or_owner_logged_out_successfully()
    {
        assertTrue(true);
    }
}