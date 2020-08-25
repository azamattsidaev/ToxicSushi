package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
/*
All WebElements, also known as page objects of Home Page are stored in this class. Page Factory is used to initialize
our objects so we can use them. Driver.getDriver() method is used to connect our WebElements with that driver.
 */
public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='toggle-btn']")
    public WebElement toggleBtn;

    @FindBy(xpath = "//a[text()='Sign in']")
    public WebElement signInBtn;

    @FindBy(id = "signin_email")
    public WebElement email;

    @FindBy(id = "signin_password")
    public WebElement password;

    @FindBy(id = "signin_submit")
    public WebElement submitBtn;

    @FindBy(xpath = "//ul[@class='main-nav']/h4[text()='Hi, Azamat']")
    public WebElement welcomeMsg;

    @FindBy(id = "errMsg")
    public WebElement errorMsg;

    @FindBy(linkText = "Sign out")
    public WebElement signOutBtn;

    @FindBy(xpath = "//a[@class='btn btn-full']")
    public WebElement hungryBtn;

    @FindBy(xpath = "//h2[@id='search_box_label']")
    public WebElement searchLabel;

    @FindBy(xpath = "//a[@class='btn btn-ghost']")
    public WebElement showMoreBtn;

    @FindBy(xpath = "//div[@id='comment-header']/h2")
    public WebElement contactsLabel;

    @FindBy(xpath = "//a[@id='search_restaurants_link']")
    public WebElement searchRestaurantBtn;


}
