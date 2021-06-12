package com.rashmi.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.rashmi.cucumber.Utilities.clickElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CheckoutStepDefinitions {

    private WebDriver driver;
    private WebDriverWait waitTill;

    public CheckoutStepDefinitions(GenericHook genericHook){
        this.driver = genericHook.getDriver();
        this.waitTill = genericHook.getWebDriverWait();
    }

    @When("I add {string}, {string} to the cart")
    public void iAddToTheCart(String collectionInput, String productInput) {
        clickElement(By.className("search-bar__input"),waitTill);
        clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/"+collectionInput+"']"),waitTill);
        WebElement someElement = driver.findElement(By.xpath("//a[@href='/collections/frozen-food/products/haldiram-s-aloo-paratha']"));
        WebElement newElement = someElement.findElement(By.xpath(".."));
        System.out.println(newElement.getAttribute("id"));
    }

    @Given("I am on the {string} section")
    public void iAmOnTheSection(String sectionInput) {
        clickElement(By.className("search-bar__input"),waitTill);
        clickElement(By.xpath("//ul[contains(@class, 'search-bar__menu-linklist')]//a[contains(text(),'"+sectionInput+"')]"), waitTill);
    }

    @When("I add {string} to the cart")
    public void iAddToTheCart(String productInput) {
        clickElement(By.xpath("//a[contains(text(),'"+productInput+"')]//./..//./..//form[@action = '/cart/add']"), waitTill);
    }

    @And("checkout")
    public void checkout() {
        clickElement(By.xpath("//a[@href = '/cart']"), waitTill);
        clickElement(By.xpath("//button[@name = 'checkout']"), waitTill);
    }

    @Then("I should be taken to the payment page")
    public void iShouldBeTakenToThePaymentPage() {
        boolean shippingAddressPresent = driver.findElement(By.xpath("//div[@class = 'section section--shipping-address']")).isDisplayed();
        assertTrue(shippingAddressPresent);
    }

}
