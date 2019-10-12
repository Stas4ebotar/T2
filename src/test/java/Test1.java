package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test1 {
    static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public static void mainTest() throws InterruptedException {
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        WebElement el = driver.findElement(By.xpath("(//a[@hreflang='en-GB'])[1]"));
        WebElement ruLanguage = driver.findElement(By.xpath("(//a[@hreflang='ru-RU'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(ruLanguage));
        ruLanguage.click();
        System.out.println("Ru language button clicked");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("preload-it"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("preload-it"))));
        System.out.println("Spinner is loaded");

        WebElement logo = driver.findElement(By.xpath("//img[@alt='ITEA']"));
        wait.until(ExpectedConditions.visibilityOf(logo));
        logo.click();
        System.out.println("Logo clicked");

        preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));

        WebElement javaCourses = driver.findElement(By.xpath("//h3[contains(text(), 'Java')]/../img"));
        wait.until(ExpectedConditions.elementToBeClickable(javaCourses));
        javaCourses.click();

        WebElement payBtn = driver.findElement(By.xpath("//button[@name='roadFull_payOnce']"));
        wait.until(ExpectedConditions.elementToBeClickable(payBtn));
        payBtn.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("preload-it"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("preload-it"))));

        WebElement beresteikaLocation = driver.findElement(By.id("location1"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("location1")));
        assertTrue(beresteikaLocation.isSelected());
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}