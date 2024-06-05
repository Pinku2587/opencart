package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Registration extends BasePage {
	
	WebDriver driver;
	
public Registration(WebDriver driver)
{
	
	super(driver);
}	

//WebElement

@FindBy(xpath="//input[@id='i-text-1']") WebElement txt_fullname;
@FindBy(xpath="//input[@id='i-text-2']") WebElement txt_email;
@FindBy(xpath="//input[@id='i-text-3']") WebElement txt_username;
@FindBy(xpath="//input[@id='i-text-4']") WebElement txt_password;
@FindBy(xpath="//div[@class='i-button auth-button']") WebElement btn_signup_free;
@FindBy(xpath="//i[@class='before-checkbox']") WebElement chkbox_tc;
@FindBy(xpath="//div[@class='alert-panel']") WebElement msg_alert;



@FindBy(xpath="//i[@class='i-icon']//*[name()='svg']") WebElement arrow_back;



// Actions

public void EnterFullName(String fullname)
{
	  txt_fullname.sendKeys(fullname);
}

public void EnterEmail(String email)
{
	  txt_email.sendKeys(email);
}

public void EnterUserName(String username)
{
	  txt_username.sendKeys(username);
}
public void EnterPassword(String password)
{
	  txt_password.sendKeys(password);
}

public void CLickCheckBoxTC()
{
	  chkbox_tc.click();
}

public void CLickSignUpFree()
{
	  btn_signup_free.click();
}


public void CLickArrowBack()
{
	  arrow_back.click();
}

public String AlertMessage()
{
	String AlertMessage = msg_alert.getText();
	return AlertMessage;
	
}

}