package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="user_name")
	private WebElement usertbx;
	@FindBy(name="user_password")
	private WebElement pwtbx;
	@FindBy(id="submitButton")
	private WebElement lgnbtn;
	//
	public LoginPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	public WebElement getUsertbx() {
		return usertbx;
	}
	public WebElement getPwtbx() {
		return pwtbx;
	}
	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	public void LoginToVTiger(WebDriver d,String un, String pw) {
		LoginPage l=new LoginPage(d);
		l.getUsertbx().sendKeys(un);
		l.getPwtbx().sendKeys(pw);
		l.getLgnbtn().click();
		
	}
	
		
	
}
