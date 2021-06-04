package com.rashmi.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utilities {
    public String baseUrl = "https://desidutchstore.nl/";
    public static WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    public static void clickElement(By by, WebDriverWait webDriverWait) {

        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    @Given("I am on the homepage of the desidutchstore")
    public void i_am_on_the_homepage_of_the_desidutchstore() {

        String baseUrl = "https://desidutchstore.nl/";
        driver.get(baseUrl);
        driver.manage().window().maximize();

    }
}
