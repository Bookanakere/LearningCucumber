package com.rashmi.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {

    WebDriver driver;
    WebDriverWait waitTill;

    @Given("I am on the homepage of the desidutchstore")
    public void i_am_on_the_homepage_of_the_desidutchstore() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","chromedriver");



        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String baseUrl = "https://desidutchstore.nl/";

        driver.get(baseUrl);
        driver.manage().window().maximize();
        waitTill = new WebDriverWait(driver,10);
        //throw new io.cucumber.java.PendingException();
    }
    @When("I search for {string}")
    public void i_search_for(String string) {
        // Write code here that turns the phrase above into concrete actions
        Utilities.clickElement(By.className("search-bar__input"),waitTill);
        Utilities.clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/snacks']"),waitTill);
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //throw new io.cucumber.java.PendingException();
    }
    @Then("I should see all the products under the category of snacks")
    public void i_should_see_all_the_products_under_the_category_of_snacks() {
        // Write code here that turns the phrase above into concrete actions

        WebElement collectionHeading = driver.findElement(By.xpath("//h1[contains(@class,'collection__title')]"));
        assertEquals(collectionHeading.getAttribute("innerHTML"),"Snacks");
        driver.close();
        //throw new io.cucumber.java.PendingException();
    }


}
