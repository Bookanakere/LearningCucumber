package com.rashmi.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import static com.rashmi.cucumber.Utilities.clickElement;


public class SearchStepDefinitions {

    WebDriverWait waitTill = new WebDriverWait(Utilities.driver,10);

    @When("I search for collection of {string}")
    public void i_search_for_collection_of(String collectionInput) {

        clickElement(By.className("search-bar__input"),waitTill);
        clickElement(By.xpath("//ul[contains(@class,'search-bar__menu-linklist')]//a[@href='/collections/"+collectionInput+"']"),waitTill);
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Then("I should see {string}")
    public void i_should_see(String collectionResult) {

        WebElement collectionHeading = Utilities.driver.findElement(By.xpath("//h1[contains(@class,'collection__title')]"));
        assertEquals(collectionHeading.getAttribute("innerHTML"),collectionResult);
        Utilities.driver.close();

    }

    @When("I search for category of {string}")
    public void i_search_for_category_of(String categoryInput) {
        Select category = new Select(Utilities.driver.findElement(By.id("search-product-type")));
        category.selectByVisibleText(categoryInput);
        Utilities.clickElement(By.className("search-bar__submit"), waitTill);
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Then("I should see items for {string}")
    public void i_should_see_items_for(String categoryResult) {
        WebElement collectionHeading = Utilities.driver.findElement(By.xpath("//h1[contains(@class,'collection__title')]"));
        assertEquals(collectionHeading.getAttribute("innerHTML"),"Products for \"" + categoryResult + "\"");
        Utilities.driver.close();
    }


}
