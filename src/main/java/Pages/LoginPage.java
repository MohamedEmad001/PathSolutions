package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.TestBase;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}

	WebDriver driver1;

	TestBase testBaseObj;

	@FindBy (id="txtUserName")
	WebElement LoginName;

	@FindBy (id = "txtpassword")
	WebElement Loginpassword;

	@FindBy (id = "chkremember")
	WebElement Rememberme;

	@FindBy (id = "btnLogin")
	WebElement Loginbtn;

	String moduleID = "15002003";

	String frameID = "frame_15002003";

	@FindBy (id = "txt_PlaceHolder")
	WebElement searchBox;

	//public static Dimension x ;

	public void UserLogin(String userLoginName , String password) throws InterruptedException
	{
		setTextElementText(LoginName, userLoginName);
		setTextElementText(Loginpassword, password);
		Checkingcheckbox(Rememberme);
		clickButton(Loginbtn);

	}
	


}
