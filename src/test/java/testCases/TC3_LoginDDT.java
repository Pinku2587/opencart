package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC3_LoginDDT extends BaseClass{
  @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
  public void Verify_LoginDDT(String email, String password, String exp) throws InterruptedException
  {
	  
	  logger.info("**** Starting Login DDT cases ****");
	  HomePage hp =new HomePage(driver);
	  LoginPage lp = new LoginPage(driver);
	  DashboardPage dp = new DashboardPage(driver);
	  
	  
	  boolean isElementDisplayed;
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
      try {
          // Wait for the element to be visible
    	  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[6]/a")));
          isElementDisplayed = element.isDisplayed();
      } catch (Exception e) {
          // If the element is not found or not visible, set the flag to false
          isElementDisplayed = false;
      }
	  
	  
      if (isElementDisplayed) {
    	  hp.ClickUpgrade();
    	  //Thread.sleep(3000);
    	  hp.ClickSignIn();
    	  lp.EnterUserName(email);
    	  lp.EnterPassword(password);
    	  lp.ClickLoginButton();
    	 // dp.ClickCross1();
    	  //dp.ClickCross2();
    	  //dp.ClickMyProfile();
    	  //dp.ClickLogOut();
    	  //Thread.sleep(3000);
    	  //driver.get("https://forms.app/en/templates/online-registration-form-template");
      } else {
    	  
    	  hp.ClickSignIn();
    	  lp.EnterUserName(email);
    	  lp.EnterPassword(password);
    	  lp.ClickLoginButton();
    	  //dp.ClickCross1();
    	  //dp.ClickCross2();
    	  //dp.ClickMyProfile();
    	  //dp.ClickLogOut();
    	  //Thread.sleep(3000);
    	  //driver.get("https://forms.app/en/templates/online-registration-form-template");
    	  }
    	  
     
	  
	  /*
	  
	  
	 
	  if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[6]/a")).isDisplayed()==true) {
	  hp.ClickUpgrade();
	  Thread.sleep(3000);
	  hp.ClickSignIn();
	  lp.EnterUserName(email);
	  lp.EnterPassword(password);
	  lp.ClickLoginButton();
	  dp.ClickCross1();
	  dp.ClickCross2();
	  dp.ClickMyProfile();
	  dp.ClickLogOut();
	  }
	  else{
	  //hp.ClickUpgrade();
	  
	  hp.ClickSignIn();
	  lp.EnterUserName(email);
	  lp.EnterPassword(password);
	  lp.ClickLoginButton();
	  dp.ClickCross1();
	  dp.ClickCross2();
	  dp.ClickMyProfile();
	  dp.ClickLogOut();
	  }
	 */
      
 if (exp.equals("Valid")) 
 {
if(lp.DisplayAlert()==true)	
{
	
	Assert.assertTrue(true);
	//driver.get("https://forms.app/en/templates/online-registration-form-template");
	//driver.navigate().refresh();
	} 
else
{
	
Assert.assertTrue(false);	
//driver.get("https://forms.app/en/templates/online-registration-form-template");
//driver.navigate().refresh();
}
 }
 /*
 if (exp.equals("Invalid"))
 {
	 if(lp.DisplayAlert()==false)
	 {
		 Assert.assertTrue(false);
		 //driver.get("https://forms.app/en/templates/online-registration-form-template");
	 }
	 else {
		 Assert.assertTrue(true);	 
		 //driver.get("https://forms.app/en/templates/online-registration-form-template");
	 }
 }
 
 
 */
 
 if (exp.equals("Invalid"))
 {
 
 
 if((lp.TextManadatoryMessageUsername().equals("You need to enter a username") || lp.TextManadatoryMessagePassword().equals("You need to enter password")) || lp.TextManadatoryMessageUsername().equals("You need to enter a username") && lp.TextManadatoryMessagePassword().equals("You need to enter password"))
 {
	Assert.assertTrue(true);
	
 }
 else
 {

		Assert.assertTrue(false);
		
	 }
  
 }
 lp.ClickImgageLogo();
 
 

 }
  }

  

  
