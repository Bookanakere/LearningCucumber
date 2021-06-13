package com.rashmi.stepdefinitions;

import com.rashmi.cucumber.GenericHook;
import com.rashmi.pages.ProductPage;
import com.rashmi.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;


public class SearchStepDefinitions {

    private WebDriver driver;
    private SearchPage searchPage;
    private ProductPage productPage;

    public SearchStepDefinitions(GenericHook genericHook){
        this.driver = genericHook.getDriver();
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
    }

    @When("I search for collection of {string}")
    public void i_search_for_collection_of(String collectionInput) {
        searchPage.searchCollection(collectionInput);
    }
    @Then("I should see {string}")
    public void i_should_see(String collectionResult) {
        assertEquals(collectionResult, productPage.getCollectionTitle());
    }

    @When("I search for category of {string}")
    public void i_search_for_category_of(String categoryInput) {
        searchPage.searchCategory(categoryInput);
    }

    @Then("I should see items for {string}")
    public void i_should_see_items_for(String categoryResult) {
        assertEquals("Products for \"" + categoryResult + "\"", productPage.getCollectionTitle());
    }

}
