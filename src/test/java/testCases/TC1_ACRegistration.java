package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.Registration;
import pageObjects.SignUpEmailPage;
import testBase.BaseClass;

public class TC1_ACRegistration extends BaseClass{
HomePage hp;
SignUpEmailPage suep;
Registration r;


 @Test(groups= {"regression","master"}, priority=1)
  public void Verify_Registration() throws InterruptedException
  {
	 logger.info("***** Starting TC1_AcRegistration *****");
	
	 try 
	 {
	 HomePage hp =new HomePage(driver);
	 SignUpEmailPage suep = new SignUpEmailPage(driver);
	 Registration r = new Registration(driver);
	 hp.ClickUpgrade();
	 logger.info("Clicked on Update button");
	 hp.ClickSignUp();
	 logger.info("Clicked on Signup button");
	 suep.ClickSignUpEmail();
	 logger.info("Clicked on Signup using Email button");
	 logger.info("Entering user information");
	 r.EnterFullName(randomString().toUpperCase()+ " " +randomString().toUpperCase());
     r.EnterEmail(randomString() + randomNumber()+"@gmail.com");
	 r.EnterUserName(randomString().toUpperCase() + randomNumber());
	 if(r.AlertMessage().equals("Your username is permanent and cannot be changed later."))
	 {
		 logger.info("Alert is correct");
	 }
	 else
	 {
		 logger.error("Alert is not correct");
	 }
	 Assert.assertEquals(r.AlertMessage(), "Your username is permanent and cannot be changed later.");
	 r.EnterPassword(randomString() + "@" +randomNumber());
	 r.CLickCheckBoxTC();
	 logger.info("Clicked on T&C Check Box");
     //r.CLickSignUpFree();
	 
	 
	 
	 }
	 catch (Exception e)
	 {logger.error("Test Failed");
	 Assert.fail();
	 }
	 logger.info("***** Finishing TC1_AcRegistration *****");
  }
 @Test(groups= {"regression","master"}, priority=2)
 public void Verify_Registrations() throws InterruptedException
 {
	 
	
	 HomePage hp =new HomePage(driver);
	 SignUpEmailPage suep = new SignUpEmailPage(driver);
	 Registration r = new Registration(driver);
	 
	 r.CLickArrowBack();
	 suep.ClickLogo();
	 hp.ClickSignUp();
	 suep.ClickSignUpEmail();
	 
	 r.EnterFullName(randomString().toUpperCase()+ " " +randomString().toUpperCase());
    r.EnterEmail(randomString() + randomNumber()+"@gmail.com");
	 r.EnterUserName(randomString().toUpperCase() + randomNumber());
	 r.EnterPassword(randomString() + "@" +randomNumber());
	 r.CLickCheckBoxTC();
    //r.CLickSignUpFree();
	 
 }

	
	 
 }
 
 



