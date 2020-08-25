package pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*
All WebElements, also known as page objects of Home Page are stored in this class. Page Factory is used to initialize
our objects so we can use them. Driver.getDriver() method is used to connect our WebElements with that driver.
 */
public class CommonPage {
    public CommonPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String CURRENT_DATETIME = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"));

    @And("I am clicking the {string} Button")
    public void iAmClickingTheButton(String button) {
        String path = "";
        switch (button.toLowerCase()){
            case "Toggle": path = "//div[@class='toggle-btn']";
                break;
            case "Sign in ": path = "//a[text()='Sign in']";
                break;
            case "Submit": path = "signin_submit";
                break;
            default:
                System.out.println("Invalid button");
        }
        SeleniumUtils.click(Driver.getDriver().findElement(By.xpath(path)));
    }

}
