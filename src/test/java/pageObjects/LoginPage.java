package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BasePage{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		
		super(driver);
	}
	
	//WebElement
	
	@FindBy(xpath="//input[@id='i-text-1']") WebElement txt_username;
	@FindBy(xpath="//input[@id='i-text-2']") WebElement txt_password;
	@FindBy(xpath="//div[@class='i-button auth-button']") WebElement btn_login;
	@FindBy(xpath="//*[@id=\"app\"]/div[3]/div[1]/div[2]/form/div[1]/div[1]/div") WebElement alert_message;
	@FindBy(xpath="//img[@class='icon-logo first']") WebElement img_logo;
	@FindBy(xpath="//span[contains(text(),'You need to enter a username')]") WebElement msg_val_username;
	@FindBy(xpath="//span[contains(text(),'You need to enter your password')]") WebElement msg_val_password;
	
	
	
	
	
	
	
	//Actions
	
	
	public void EnterUserName(String username)
	{
		  txt_username.sendKeys(username);
	}
	public void EnterPassword(String password)
	{
		  txt_password.sendKeys(password);
	}

	public void ClickLoginButton()
	{
		  btn_login.click();
	}
	
	public String TextofAlert()
	{
		  String Alert = alert_message.getText();
		  return Alert;
	}
	
	public boolean DisplayAlert()
	{
		  boolean status = alert_message.isDisplayed();
		  return status;
	}
	
	public void ClickImgageLogo()
	{
		  img_logo.click();
	}
	
	
	public boolean DisplayMandatoryMessageUsername()
	{
		  boolean status = msg_val_username.isDisplayed();
		  return status;
	}
	
	public boolean DisplayMandatoryMessagePassword()
	{
		  boolean status = msg_val_password.isDisplayed();
		  return status;
	}
	
	public String TextManadatoryMessageUsername()
	{
		  String Alert = msg_val_username.getText();
		  return Alert;
	}
	public String TextManadatoryMessagePassword()
	{
		  String Alert = msg_val_password.getText();
		  return Alert;
	}
	
}



