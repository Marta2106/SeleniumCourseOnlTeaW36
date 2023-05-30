package StepfDef;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Zad1Def {
    public WebDriver driver;

    @Given("I am on main site")
    public void i_am_on_main_site() {
        //setx PATH "%PATH%;C:\WebDriver\bin"
        driver = new EdgeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/");
    }
    @When("Click on signIn")
    public void click_on_sign_in() {
        WebElement loginElement = driver.findElement(By.xpath("//a[@title= 'Log in to your customer account']"));

        loginElement.click();
    }
    @Then("Redirect after click SignIn to {string}")
    public void redirect_after_click_sign_in(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }
    @When("I am login as {string} and {string}")
    public void i_am_login_as_and(String string, String string2) {
        WebElement fieldMail = driver.findElement(By.id("field-email"));
        WebElement fieldPassword = driver.findElement(By.id("field-password"));
        WebElement buttonSignIn = driver.findElement(By.id("submit-login"));

        fieldMail.sendKeys(string);
        fieldPassword.sendKeys(string2);

        buttonSignIn.click();
    }
    @Then("Redirection after login to {string}")
    public void redirection_after_login(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }
    @When("I am entering to addresses")
    public void i_am_entering_to_addresses() {
        WebElement fieldAddresses = driver.findElement(By.id("addresses-link"));

        fieldAddresses.click();
    }
    @Then("Redirection after addresses button {string}")
    public void redirection_after_addresses_button(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }
    @When("I am creating new address")
    public void i_am_creating_new_address() {
        WebElement addAddress = driver.findElement(By.xpath("//a[@data-link-action= 'add-address']"));

        addAddress.click();
    }
    @Then("Redirection after new address button {string}")
    public void redirection_after_new_address_button(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }
    @When("I am filling the form {string} {string} {string}")
    public void i_am_filling_the_form(String address, String city, String postcode) {
        WebElement fieldAddress = driver.findElement(By.id("field-address1"));
        WebElement fieldCity = driver.findElement(By.id("field-city"));
        WebElement fieldZip = driver.findElement(By.id("field-postcode"));

        fieldAddress.sendKeys(address);
        fieldCity.sendKeys(city);
        fieldZip.sendKeys(postcode);
    }
    @When("I am confirming date")
    public void i_am_confirming_date() {
        WebElement addAddress = driver.findElement(By.xpath("//button[@type= 'submit']"));

        addAddress.click();
    }
    @Then("Redirection after new save button {string}")
    public void redirection_after_new_save_button(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }
    @After
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
    }
}