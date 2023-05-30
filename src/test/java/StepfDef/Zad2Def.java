package StepfDef;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class Zad2Def {
    public WebDriver driver;

    @Given("I am on main site to start shopping")
    public void i_am_on_main_site_to_start_shopping() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/");
    }

    @When("Click on signIn T")
    public void click_on_sign_in_T() {
        WebElement loginElement = driver.findElement(By.xpath("//a[@title= 'Log in to your customer account']"));

        loginElement.click();
    }

    @Then("Redirect after click SignIn T to {string}")
    public void redirect_after_click_sign_in_T(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }

    @When("I am login T as {string} and {string}")
    public void i_am_login_T_as_and(String string, String string2) {
        WebElement fieldMail = driver.findElement(By.id("field-email"));
        WebElement fieldPassword = driver.findElement(By.id("field-password"));
        WebElement buttonSignIn = driver.findElement(By.id("submit-login"));

        fieldMail.sendKeys(string);
        fieldPassword.sendKeys(string2);

        buttonSignIn.click();
    }

    @Then("Redirection after login T to {string}")
    public void redirection_after_login_T(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }

    @When("I am choosing a sweater")
    public void i_am_choosing_a_sweater() {
        WebElement addClosed = driver.findElement(By.xpath("//li[@id=\"category-3\"]/a"));

        addClosed.click();
        WebElement addSweater = driver.findElement(By.xpath("//*[@data-id-product=\"2\"]//h2/a"));

        addSweater.click();

    }

    @Then("Redirection after selecting the sweater to {string}")
    public void redirection_after_selecting_the_sweater_to(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }

    @When("I am choosing my sweater size")
    public void i_am_choosing_my_sweater_size() {
        WebElement fieldSize = driver.findElement(By.id("group_1"));
        Select dropdown = new Select(fieldSize);
        dropdown.selectByVisibleText("M");
    }

    @When("I am choosing the quantity")
    public void i_am_choosing_the_quantity() {
        WebElement addQuantity = driver.findElement(By.id("quantity_wanted"));

        addQuantity.sendKeys("5");
    }

    @When("I am adding the product to the cart")
    public void i_am_adding_the_product_to_the_cart() {
        WebElement addProductToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));

        addProductToCart.click();

    }

    @When("Click on Checkout")
    public void click_on_checkout() {
        WebElement loginElement = driver.findElement(By.xpath("//*[@class=\"cart-content-btn\"]//a"));

        loginElement.click();

    }

    @Then("I am checking if I am on the cart page with the order {string}")
    public void i_am_checking_if_i_am_on_the_cart_page_with_the_order(String string) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(string));
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }

    @When("Click Proceed to checkout")
    public void click_proceed_to_checkout() {
        WebElement loginElement = driver.findElement(By.xpath("//*[@class=\"checkout cart-detailed-actions js-cart-detailed-actions card-block\"]//a"));

        loginElement.click();
    }


    @Then("I am checking the order on  {string}")
    public void i_am_checking_the_order_on(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);
    }


    @When("I am confirming the address")
    public void i_am_confirming_the_address() {
        WebElement Address = driver.findElement(By.name("confirm-addresses"));

        Address.click();

    }

    @When("I am choosing the pickup method - PrestaShop {string}")
    public void i_am_choosing_the_pickup_method_presta_shop(String string) {
        WebElement PickupMethod = driver.findElement(By.name("confirmDeliveryOption"));

        PickupMethod.click();

    }

    @When("I am choosing the payment option - Pay by Check")
    public void i_am_choosing_the_payment_option_pay_by_check() {
        WebElement Payment = driver.findElement(By.id("payment-option-1-container"));

        Payment.click();
    }

    @When("Click on Place Order")
    public void click_on_place_order() {
        WebElement PlaceOrder = driver.findElement(By.id("payment-confirmation"));

        PlaceOrder.click();
    }

    @Then("Redirection to {string}")
    public void redirection_to(String string) {
        String currrentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(string, currrentUrl);

    }


    @Then("I am taking a screenshot of the order confirmation and the amount")
    public void i_am_taking_a_screenshot_of_the_order_confirmation_and_the_amount() throws IOException {
//Take screenshot (will be saved in default location) and automatically removed after test
        File tmpScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//Copy the screenshot to desired location
//Path to the location to save screenshot
//(directory for screenshots MUST exist: C:\test-evidence) e.g.:
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        // new three classes that we use below: Files, Path, Paths
        FileUtils.copyFile(tmpScreenshot, new File(".//screenshots/" + currentDateTime + ".png"));

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
