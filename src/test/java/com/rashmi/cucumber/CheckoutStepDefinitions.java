package com.rashmi.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.rashmi.cucumber.Utilities.clickElement;
import static org.junit.Assert.assertEquals;


public class CheckoutStepDefinitions {

    private WebDriver driver;
    private WebDriverWait waitTill;

    public CheckoutStepDefinitions(GenericHook genericHook){
        this.driver = genericHook.getDriver();
        this.waitTill = genericHook.getWebDriverWait();
    }

    @When("I add products to the cart")
    public void i_add_products_to_the_cart() {

        clickElement(By.className("search-bar__input"),waitTill);
        clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"),waitTill);
        clickElement(By.xpath("//form[@action = '/cart/add']"), waitTill);
    }


    @And("checkout")
    public void checkout() {
        clickElement(By.xpath("//a[@href = '/cart']"), waitTill);
        clickElement(By.xpath("//button[@name = 'checkout']"), waitTill);

    }


    @Then("I should be taken to the payment page")
    public void iShouldBeTakenToThePaymentPage() {
    boolean shippingAddressPresent = driver.findElement(By.xpath("//div[@class = 'section section--shipping-address']")).isDisplayed();
    assertEquals(shippingAddressPresent,true);

    }
}
