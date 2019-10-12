package main.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement preloader;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public HomePage isShown(){
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        return this;
    }
    public HomePage selectLang(String lang ){
        WebElement ruLanguage = driver.findElement(By.xpath("(//a[@hreflang='"+ lang +"'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(ruLanguage));
        ruLanguage.click();
        System.out.println("Ru language button clicked");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("preload-it"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("preload-it"))));
        System.out.println("Spinner is loaded");
        return this;
    }

}
