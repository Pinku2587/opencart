package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class SignUpEmailPage extends BasePage {
	
	WebDriver driver;
	
public SignUpEmailPage(WebDriver driver)
{
	
	super(driver);
}	


// WebElement

@FindBy(xpath="//div[@class='i-button auth-button sign-email-button prepend-icon with-icon']") WebElement btn_signupemail;
@FindBy(xpath="//img[@class='icon-logo first']") WebElement img_logo;


  public void ClickSignUpEmail()
  {
	  btn_signupemail.click();
  }
  
  public void ClickLogo()
  {
	  img_logo.click();
  }
 
}