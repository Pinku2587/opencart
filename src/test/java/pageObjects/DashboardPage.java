package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class DashboardPage extends BasePage {
	
	WebDriver driver;
	
public DashboardPage(WebDriver driver)
{
	
	super(driver);
}	

//WebElement

@FindBy(xpath="//h2[normalize-space()='My Forms']") WebElement label_myforms;
@FindBy(xpath="//div[@id='app']/div[2]/header/div[1]/div[1]/div[2]/div[2]/div[1]") WebElement btn_myprofile;
@FindBy(xpath="//li[@class='logout']//a") WebElement btn_logout;
@FindBy(xpath="//div[@class='popup news-popup fullscreen']//span[@class='close-button cursor-p']//i[@class='i-icon']//*[name()='svg']") WebElement btn_cross1;
@FindBy(xpath="//span[@class='close-button cursor-p']//i[@class='i-icon']//*[name()='svg']") WebElement btn_cross2;


public String GetTextMyForm()
{
	String MyForm = label_myforms.getText();
	return MyForm;
	
}

public void ClickMyProfile()
{
	  btn_myprofile.click();
}
public void ClickLogOut()
{
	  btn_logout.click();
}

public void ClickCross1()
{
	  btn_cross1.click();
}

public void ClickCross2()
{
	  btn_cross2.click();
}

}