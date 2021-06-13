package com.rashmi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(xpath = "//h1[contains(@class,'collection__title')]")
    private WebElement collectionTitle;

    @FindBy(xpath="//a[@href = '/cart']")
    WebElement cart;

    @FindBy(xpath="//button[@name = 'checkout']")
    WebElement checkout;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCollectionTitle() {
        return collectionTitle.getAttribute("innerHTML");
    }

    public void addToCart(String productInput){
        driver.findElement(By.xpath("//a[contains(text(),'"+productInput+"')]//./..//./..//form[@action = '/cart/add']")).click();
    }

    public void goToCart(){
        cart.click();
    }

    public void checkout(){
        checkout.click();
    }
}
