package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import step_impl.HomePageImpl;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

/*
In this class all step definitions for those steps in feature file are stored. Good practice to keep your steps
as short as possible. If you think your Test method will look bigger, try to create a method in implementation class
and call it in your step definition method.
 */
public class HomePageTest {



        @Given("I am opening a home page")
        public void i_am_opening_a_home_page() {
           Driver.getDriver().get("https://toxic-sushi-26692.herokuapp.com/index.html#");
        }

        @Then("I am verifying that the title is Toxic Sushi")
        public void i_verifying_that_the_title_is_toxic_sushi() {
                Assert.assertEquals("Toxic Sushi" , Driver.getDriver().getTitle());
        }

        @And("I am clicking the Toggle Button")
        public void iAmClickingTheToggleButton() {
                HomePage homePage = new HomePage();
                SeleniumUtils.click(homePage.toggleBtn);
        }

        @And("I am clicking the Sign in Button")
        public void iAmClickingTheSignInButton() {
                HomePage homePage = new HomePage();
                SeleniumUtils.click(homePage.signInBtn);
        }


        @And("I am providing {string} as username")
        public void iAmProvidingAsUsername(String arg0) {
                HomePage homePage = new HomePage();
                SeleniumUtils.sendKeys(homePage.email, "azam@yahoo.com");
        }

        @And("I am providing {string} as password")
        public void iAmProvidingAsPassword(String arg0) {
                HomePage homePage = new HomePage();
                SeleniumUtils.sendKeys(homePage.password, "azam1234");
        }

        @And("I am clicking the Submit Button")
        public void iAmClickingTheSubmitButton() {
                HomePage homePage = new HomePage();
                SeleniumUtils.click(homePage.submitBtn);
        }

//        @Then("I am validating a {string} as message")
//        public void iAmValidatingAAsMessage(String arg0) {
//                HomePage homePage = new HomePage();
//                Assert.assertEquals("Your email or password is incorrect! Please try again!",
//                        SeleniumUtils.getText(homePage.errorMsg));
//        }

        @Then("I am validating a {string} as message")
        public void iAmValidatingAAsMessage(String arg0) {
                HomePage homePage = new HomePage();
                Assert.assertEquals("Hi, Azamat",
                        SeleniumUtils.getText(homePage.welcomeMsg));
        }


        @And("I am clicking the Sign Out Button")
        public void iAmClickingTheSignOutButton() {
                SeleniumUtils.sleep(2000);
                HomePage homePage = new HomePage();
                SeleniumUtils.click(homePage.signOutBtn);
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
//                Assert.assertTrue(homePage.barButtons.isDisplayed());
                for(int i = 0; i< navButtons.size(); i ++){
                        Assert.assertEquals(navButtons.get(i).getAttribute("text"), barButtons[i]);
                }
        }

        @And("I am clicking the Hungry Button")
        public void iAmClickingTheHungryButton() {
                HomePage homePage = new HomePage();
                SeleniumUtils.click(homePage.hungryBtn);
        }

        @Then("I am verifying that the Search Label is {string}")
        public void iAmVerifyingThatTheSearchLabelIs(String arg0) {
                HomePage homePage = new HomePage();
                Assert.assertEquals("SEARCH RESTAURANTS", homePage.searchLabel.getText());
        }

        @And("I am clicking the Show me more Button")
        public void iAmClickingTheShowMeMoreButton() {
                HomePage homePage = new HomePage();
                SeleniumUtils.click(homePage.showMoreBtn);
        }

        @Then("I am verifying that the Contacts Label is {string}")
        public void iAmVerifyingThatTheContactsLabelIs(String arg0) {
                HomePage homePage = new HomePage();
                Assert.assertEquals("WE'RE HAPPY TO HEAR FROM YOU", homePage.contactsLabel.getText());
        }

        @And("I am clicking the Search Restaurant Button")
        public void iAmClickingTheSearchRestaurantButton() {
                HomePage homePage = new HomePage();
                SeleniumUtils.click(homePage.searchRestaurantBtn);
        }


}
