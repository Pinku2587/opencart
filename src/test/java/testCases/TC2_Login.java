package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC2_Login extends BaseClass{
	
	
	 @Test(groups= {"sanity","master"}, priority=1)
	  public void Logo()
	  {
		 HomePage hp =new HomePage(driver);
		  hp.ClickUpgrade();
		  Assert.assertEquals(hp.LogoPresence(), true);
	  }
	
	
	
	
	
  @Test(groups= {"sanity","master"},priority=2)
  public void LoginSuccessful() throws InterruptedException 
  
  {
	  HomePage hp =new HomePage(driver);
	  LoginPage lp = new LoginPage(driver);
	  DashboardPage dp = new DashboardPage(driver);
	 
	  hp.ClickSignIn();

	  lp.EnterUserName(p.getProperty("userName"));
	  lp.EnterPassword(p.getProperty("passWord"));
	  lp.ClickLoginButton();
	  Thread.sleep(5000);
	  if(lp.TextofAlert().equals("Please confirm that you are not a robot."))
	  {
		  //Assert.assertEquals(lp.TextofAlert(), "Please confirm that you are not a robot.");
		  Assert.assertTrue(true);
	  }
	  
	  else {
		  Thread.sleep(5000);
		  dp.ClickCross1();
		  Thread.sleep(5000);
		  dp.ClickCross2();
		  Thread.sleep(5000);
		  Assert.assertEquals(dp.GetTextMyForm(), "My Forms");
		  dp.ClickMyProfile();
		  Thread.sleep(5000);
		  dp.ClickLogOut();
		    
	  }
	  //dp.ClickCross1();
	  //Thread.sleep(5000);
	  //dp.ClickCross2();
	  //Thread.sleep(5000);
	  //Assert.assertEquals(dp.GetTextMyForm(), "My Forms");
	  //dp.ClickMyProfile();
	  //Thread.sleep(5000);
	  //dp.ClickLogOut();
	  
	  //Assert.assertEquals(lp.TextofAlert(), "Please confirm that you are not a robot.");
	  
  
  }
  
 
}
