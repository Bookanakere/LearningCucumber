package com.rashmi.cucumber;

import com.rashmi.pages.InformationPage;
import com.rashmi.pages.ProductPage;
import com.rashmi.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CheckoutStepDefinitions {

    private WebDriver driver;
    private SearchPage searchPage;
    private WebDriverWait waitTill;
    private ProductPage productPage;
    private InformationPage informationPage;

    public CheckoutStepDefinitions(GenericHook genericHook){
        this.driver = genericHook.getDriver();
        this.waitTill = genericHook.getWebDriverWait();
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        informationPage = new InformationPage(driver);
    }
    @Given("I am on the {string} section")
    public void iAmOnTheSection(String collectionInput) {
        searchPage.searchCollection(collectionInput);
    }

    @When("I add {string} to the cart")
    public void iAddToTheCart(String productInput) {
        productPage.addToCart(productInput);
    }

    @And("checkout")
    public void checkout() {
        productPage.goToCart();
        productPage.checkout();
    }

    @Then("I should be taken to the payment page")
    public void iShouldBeTakenToThePaymentPage() {
        boolean shippingAddressPresent = driver.findElement(By.xpath("//div[@class = 'section section--shipping-address']")).isDisplayed();
        assertTrue(shippingAddressPresent);
    }

    @Then("I should be taken to the information page")
    public void iShouldBeTakenToTheInformationPage() {
        assertEquals("Information - DesiDutchStore - Checkout", informationPage.getInformationPageTitle());
    }
}
