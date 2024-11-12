package com.orangehrmlive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGOrangeHrmLogin extends BasePage {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        driver = new FirefoxDriver();
        driver.get(applicationUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @Test (priority = 0,enabled = true)
    public void doLoginOrangeHrmApplication() throws InterruptedException {


        boolean elementIsDisplayed = driver.findElement(By.name("username")).isDisplayed();


        if (elementIsDisplayed) {
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys(userName);
//            thread.sleep(5000);
        }

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        driver.findElement(By.name("password")).isDisplayed();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
//        thread.sleep(5000);

//        Explicit wait--------
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

        driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
        driver.findElement(By.xpath("//button[@type='submit']")).click();




    }



    @Test (priority = 1,enabled = true)
    public void doLoginOrangeHrmApplicationShouldSucceed(){
        System.out.println("Welcome to TestNG");

    }

    @Test (priority = 2,enabled = true)
    public void validateHomePageTitleAfterLogin(){
        System.out.println("Welcome to automated testing ");


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }


    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
}
