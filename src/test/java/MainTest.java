package test.java;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_sv;
import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static  HomePage homePage;
    static CoursesPage coursesPage;

        @BeforeMethod
    public static void setUp() {
                  System.setProperty("webdriver.chrome.driver",
                    "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            homePage=new HomePage(driver);
            coursesPage = new CoursesPage(driver);

    }

    @Test
    public static void mainTest() throws InterruptedException {
        homePage.isShown()
                .selectLang("ru-RU")
        coursesPage.clickPay();




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


        assertTrue(coursesPage.beresteikaLocationIsSelected());


    }
}


