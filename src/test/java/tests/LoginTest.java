package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // If chromedriver is in project root use "./chromedriver" or "chromedriver.exe" on Windows.
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement successMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"),
                "Valid login test failed!");
    }

    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();

        driver.findElement(By.id("username")).sendKeys("wrongUser");
        driver.findElement(By.id("password")).sendKeys("wrongPass");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"),
                "Invalid login test failed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
