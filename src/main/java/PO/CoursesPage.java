package main.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class CoursesPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement preloader;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public CoursesPage clickPay(){
        WebElement payBtn = driver.findElement(By.xpath("//button[@name='roadFull_payOnce']"));
        wait.until(ExpectedConditions.elementToBeClickable(payBtn));
        payBtn.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("preload-it"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("preload-it"))));
        return this;
    }

    public boolean beresteikaLocationIsSelected(){
        WebElement beresteikaLocation = driver.findElement(By.id("location1"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("location1")));
        return beresteikaLocation.isSelected();

    }
}

