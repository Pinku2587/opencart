package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
public HomePage(WebDriver driver)
{
	
	super(driver);
}	


// WebElement

@FindBy(xpath="/html/body/div[2]/div[1]/div[6]/a") WebElement btn_upgrade;
@FindBy(xpath="//div[@class='element-noauth']//a[@class='button button-transparent registerButton'][normalize-space()='Sign Up Free']") WebElement btn_signup;
@FindBy(xpath="//a[@class='button button-main outline loginButton']") WebElement btn_signin;
@FindBy(xpath="//img[@class='logo first']") WebElement img_logo;



//Actions

public void ClickUpgrade()
{
	  btn_upgrade.click();
}

  public void ClickSignUp()
  {
	  btn_signup.click();
  }

  public void ClickSignIn()
  {
	  btn_signin.click();
  }
 
  public boolean LogoPresence()
  {
	  boolean status =img_logo.isDisplayed();
	  return status;
	  
  }
}