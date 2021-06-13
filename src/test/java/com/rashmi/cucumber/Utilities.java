package com.rashmi.cucumber;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    public static void clickElement(By by, WebDriverWait webDriverWait) {

        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }


    /*
       List<WebElement> collections = driver.findElements(By.xpath("//a[@class='search-bar__menu-link']"));
       System.out.println(collections.size());
       collections.forEach(collection -> {
         System.out.println(collection.getAttribute("innerHTML"));
       });

               WebElement selectCategory =driver.findElement(By.id("search-product-type"));
        Select select = new Select(selectCategory);
        select.selectByVisibleText("Chapati");

                WebElement collections = driver.findElement(By.xpath("//a[@class='search-bar__menu-link']"));
        WebElement pickles = collections.findElement(By.xpath("//a[contains(text(),'Pickles')]"));
        clickElement(By.className("search-bar__input"),waitTill);
        pickles.click();
*/
}
