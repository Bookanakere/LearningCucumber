package com.rashmi.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SearchPage {

    private WebDriver driver;
    @FindBy(className = "search-bar__input")
    private WebElement searchCollection;

    @FindBy(xpath = "//a[@class='search-bar__menu-link']")
    private WebElement collections;

    @FindBy(id = "search-product-type")
    private WebElement searchCategory;

    @FindBy(className = "search-bar__submit")
    private WebElement searchCategorySubmit;


    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchCollection(String collectionInput){
        searchCollection.click();
        collections.findElement(By.xpath("//a[contains(text(),'"+collectionInput+"')]")).click();
    }

    public void searchCategory(String categoryInput){
        Select select = new Select(searchCategory);
        select.selectByVisibleText(""+categoryInput+"");
        searchCategorySubmit.click();
    }


}
