package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (linkText = "Change password")
	WebElement ChangePasswordLink;
	
	@FindBy (id = "OldPassword")
	WebElement oldpasswordtxt;

	@FindBy (id = "NewPassword")
	WebElement newpasswordtxt;

	@FindBy (id = "ConfirmNewPassword")
	WebElement confirmpasswordtxt;

	@FindBy (css = "input.button-1.change-password-button")
	WebElement ChangePasswordBtn;
	
	@FindBy (css = "div.result")
	public WebElement ResultStatus;
	
	public void OpenChangePassword()
	{
		clickButton(ChangePasswordLink);
	}
	
	public void ChangePassword(String oldpassword, String newpassword)
	{
		setTextElementText(oldpasswordtxt, oldpassword);
		setTextElementText(newpasswordtxt, newpassword);
		setTextElementText(confirmpasswordtxt, newpassword);
		clickButton(ChangePasswordBtn);
	}
	
	

}
