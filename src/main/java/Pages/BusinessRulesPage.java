package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessRulesPage extends PageBase {

	public BusinessRulesPage(WebDriver driver) {
		super(driver);
	}
	
	//Global Variables
		WebDriver driver1;
		
		@FindBy (id="txt_PlaceHolder") WebElement searchBox;
		
		@FindBy(id="BR_NAME") WebElement RuleNameTxt;
		@FindBy(id="BTN_EDIT_EQ__Button") WebElement EditBtn;
		
		@FindBy(id="txtModuleID") WebElement ModuleIDTxt;
		@FindBy(css="#txtModuleID_lovImage") WebElement ModuleLOVBtn;
<<<<<<< HEAD
		@FindBy(css="#txtModuleID_lovImage") WebElement ModuleLOVBtnAmr;
=======
		@FindBy(css="#txtModuleID_lovImage") WebElement ModuleLOVBtn2;
>>>>>>> 458f4b3ea209b3f15595ab09b6fb6dc79677c2a0
	

}
