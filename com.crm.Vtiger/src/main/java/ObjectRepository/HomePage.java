
package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement profileAdd;

    @FindBy(xpath = "//a[text()='Sign Out']")
    private WebElement signOutLink;

    @FindBy(xpath = "//a[@href='index.php?module=Calendar&action=index']")
    private WebElement calendarLink;

    @FindBy(xpath = "//a[@href='index.php?module=Leads&action=index']")
    private WebElement labelsLink;

    @FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
    private WebElement orgLink;

    @FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
    private WebElement contactLink;

    @FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
    private WebElement OpportuntiesLink;

    @FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
    private WebElement productsLink;

    @FindBy(xpath = "//a[@href='index.php?module=Documents&action=index']")
    private WebElement documentsLink;

    @FindBy(xpath = "//a[@href='index.php?module=Emails&action=index']")
    private WebElement emailLink;

    @FindBy(xpath = "//a[@href='index.php?module=HelpDesk&action=index']")
    private WebElement troubleTicketsLink;

    @FindBy(xpath = "//a[@href='index.php?module=Dashboard&action=index']")
    private WebElement dashboardsLink;

    @FindBy(xpath = "//a[text()='More']")
    private WebElement moreLink;


    // Constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    public WebElement getProfileAdd() {
        return profileAdd;
    }

    public WebElement getSignOutLink() {
        return signOutLink;
    }

    public WebElement getCalendarLink() {
        return calendarLink;
    }

    public WebElement getLabelsLink() {
        return labelsLink;
    }

    public WebElement getOrgLink() {
        return orgLink;
    }

    public WebElement getContactLink() {
        return contactLink;
    }

    public WebElement getOpportuntiesLink() {
        return OpportuntiesLink;
    }

    public WebElement getProductsLink() {
        return productsLink;
    }

    public WebElement getDocumentsLink() {
        return documentsLink;
    }

    public WebElement getEmailLink() {
        return emailLink;
    }

    public WebElement getTroubleTicketsLink() {
        return troubleTicketsLink;
    }

    public WebElement getDashboardsLink() {
        return dashboardsLink;
    }

    public WebElement getMoreLink() {
        return moreLink;
    }


    // Logout method
    public void LogOutFromVTiger() {

        Actions a = new Actions(driver);

        a.moveToElement(profileAdd).perform();

        signOutLink.click();
    }

}
