package com.rashmi.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GenericHook {
    private static final String baseUrl = "https://desidutchstore.nl/";
    private WebDriver driver;
    private WebDriverWait waitTill;


    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        waitTill = new WebDriverWait(driver,10);

        driver.get(baseUrl);

    }
    @After
    public void tearDown(){

        driver.quit();
    }

    @Given("I am on the homepage of the desidutchstore")
    public void i_am_on_the_homepage_of_the_desidutchstore() {

    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait(){
        return waitTill;
    }
}
