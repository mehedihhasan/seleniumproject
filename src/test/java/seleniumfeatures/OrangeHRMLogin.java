package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRMLogin {
    private static Thread thread;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        boolean elementIsDisplayed = driver.findElement(By.name("username")).isDisplayed();


        if (elementIsDisplayed) {
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("Admin");
//            thread.sleep(5000);
        }

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        driver.findElement(By.name("password")).isDisplayed();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");
//        thread.sleep(5000);

//        Explicit wait--------
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

        driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.quit();



    }
}
