package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HandlingRadioButton {
    private static Thread thread;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.findElement(By.id("vfb-7-2")).isSelected();
        driver.findElement(By.id("vfb-7-2")).click();

//        Select Check Box
        driver.findElement(By.id("vfb-6-2")).isSelected();
        driver.findElement(By.id("vfb-6-2")).click();


    }
}
