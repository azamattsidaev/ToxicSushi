package step_definitions;

import com.sun.tools.internal.ws.processor.generator.CustomExceptionGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import step_impl.HomePageImpl;
import utils.ConfigReader;
import utils.CucumberUtils;
import utils.Driver;
import utils.SeleniumUtils;

import java.awt.*;
import java.util.List;

/*
In this class all step definitions for those steps in feature file are stored. Good practice to keep your steps
as short as possible. If you think your Test method will look bigger, try to create a method in implementation class
and call it in your step definition method.
 */
public class HomePageTest {

      public static String propertyPath= "src/test/resources/conf/configuration.properties";

        @Given("I am opening a home page")
        public void i_am_opening_a_home_page() {
                String url = ConfigReader.readProperty("url", propertyPath);
           Driver.getDriver().get(url);
        }

        @Then("I am verifying that the title is Toxic Sushi")
        public void i_verifying_that_the_title_is_toxic_sushi() {
                Assert.assertEquals("Toxic Sushi" , Driver.getDriver().getTitle());
        }


        @And("I login the page")
        public void iLoginThePage() {
             HomePage homePage = new HomePage();
             String username = ConfigReader.readProperty("username", propertyPath);
             String password = ConfigReader.readProperty("password", propertyPath);
             homePage.logIn(username, password);
        }

        @And("I am clicking the {string} Button")
        public void iAmClickingTheSignOutButton(String button) {
                HomePage homePage = new HomePage();
                switch(button.toLowerCase()){
                        case "Sign out":
                                SeleniumUtils.click(homePage.toggleBtn);
                                SeleniumUtils.click(homePage.signOutBtn);
                                break;
                        case "Hungry":
                                SeleniumUtils.click(homePage.hungryBtn);
                                break;
                        case "Show me more":
                                SeleniumUtils.click(homePage.showMoreBtn);
                                break;
                        case "Search Restaurant":
                                SeleniumUtils.click(homePage.searchRestaurantBtn);
                                break;
                        default:
                                System.out.println("Invalid button");
                }
        }


        @When("I login with invalid credentials")
        public void iLoginWithInvalidCredentials() {
                HomePage homePage = new HomePage();
                homePage.logIn("AZAM", "1234");
        }


        @Then("I am verifying {string} as {string}")
        public void iAmVerifyingAs(String messageType, String message) {
                HomePage homePage = new HomePage();
                switch (messageType.toLowerCase()) {
                        case "error message": message = homePage.errorMsg.getText() ;
                                break;
                        case "hi message" : message = homePage.welcomeMsg.getText();
                                break;
                        default:
                                System.out.println("Invalid message");
                }
                SeleniumUtils.waitForPageToLoad();
                CucumberUtils.logInfo(" Message type: " + messageType + " Result: " + message, true);
        }


        @Then("I am verifying {string}message is not displayed")
        public void iAmVerifyingMessageIsNotDisplayed(String arg0) {
                HomePage homePage = new HomePage();
                Assert.assertTrue(homePage.welcomeMsg.isEnabled());

        }

        @And("verifying Navigation Buttons displayed")
        public void verifyingNavigationButtonsDisplayed() {
                List<WebElement> navButtons = Driver.getDriver().findElements(By.xpath("//nav[@class='header-nav']/div/a"));
                String[] barButtons = {"Home", "Search Restaurants","Search Fun Places","My Favorites"};
                for(int i = 0; i< navButtons.size(); i ++){
                        Assert.assertEquals(navButtons.get(i).getAttribute("text"), barButtons[i]);
                }
        }


        @Then("I am verifying that the Search Label is {string}")
        public void iAmVerifyingThatTheSearchLabelIs(String arg0) {
                HomePage homePage = new HomePage();
                Assert.assertEquals("SEARCH RESTAURANTS", homePage.searchLabel.getText());
        }


        @Then("I am verifying that the Contacts Label is {string}")
        public void iAmVerifyingThatTheContactsLabelIs(String arg0) {
                HomePage homePage = new HomePage();
                Assert.assertEquals("WE'RE HAPPY TO HEAR FROM YOU", homePage.contactsLabel.getText());
        }

}
