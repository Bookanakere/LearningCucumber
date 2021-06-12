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
    public void codeReference(){
        List<WebElement> webElements = driver.findElements(By.xpath("//ul[contains(@class, 'search-bar__menu-linklist']"));
        webElements.forEach(webElement -> { System.out.println(webElement.getAttribute("innerHTML"));
      }
*/
}
