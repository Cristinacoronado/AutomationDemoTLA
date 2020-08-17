package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMgtPage extends BasePage {
    WebDriver driver;

    public UserMgtPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-btn")
    public WebElement loginBtn;

    @FindBy(id = "access-db-btn")
    public WebElement accessDbBtn;

    @FindBy(xpath = "//table[@id='list-table']/tbody/tr ")
    public WebElement tableRow;

    public String[] registrationFormFields = {"Firstname","Lastname","Email","Phonenumber","Select-role"};


}