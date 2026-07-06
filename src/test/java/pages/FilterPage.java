package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterPage {

    WebDriver driver;
    WebDriverWait wait;

    public FilterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // ==========================
    // WOMEN MENU
    // ==========================

    public void clickWomen() throws Exception {

        driver.findElement(By.cssSelector("a[href='category-women.html']")).click();

        Thread.sleep(3000);

    }

    // ==========================
    // MEN MENU
    // ==========================

    public void clickMen() throws Exception {

        driver.findElement(By.cssSelector("a[href='category-men.html']")).click();

        Thread.sleep(3000);

    }

    // ==========================
    // GEAR MENU
    // ==========================

    public void clickGear() throws Exception {

        driver.findElement(By.cssSelector("a[href='category-equipment.html']")).click();

        Thread.sleep(3000);

    }

    // ==========================
    // WOMEN & MEN FILTERS
    // ==========================

    public void selectCategoryTops() throws Exception {

        driver.findElement(By.cssSelector("input[value='tops']")).click();

        Thread.sleep(2000);

    }

    public void selectSizeS() throws Exception {

        driver.findElement(By.cssSelector("input[value='s']")).click();

        Thread.sleep(2000);

    }

    public void selectPriceUnder50() throws Exception {

        driver.findElement(By.cssSelector("input[value='0-50']")).click();

        Thread.sleep(2000);

    }

    public void selectGreenColor() throws Exception {

        WebElement green =
                driver.findElement(By.cssSelector("span[data-color='green']"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", green);

        Thread.sleep(3000);

    }

    // ==========================
    // GEAR FILTER
    // ==========================

    public void selectCategoryBags() throws Exception {

        driver.findElement(By.cssSelector("input[value='bags']")).click();

        Thread.sleep(2000);

    }

    // ==========================
    // REMOVE FILTERS
    // (Click Again)
    // ==========================

    public void clearWomenMenFilters() throws Exception {

        driver.findElement(By.cssSelector("input[value='0-50']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("input[value='tops']")).click();
        Thread.sleep(2000);

    }

    public void clearGearFilters() throws Exception {

        

        driver.findElement(By.cssSelector("input[value='0-50']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("input[value='bags']")).click();
        Thread.sleep(2000);

    }

    // ==========================
    // ASSERTIONS
    // ==========================

    public boolean isProductsDisplayed() {

        return driver.findElements(By.cssSelector(".product-card")).size() > 0;

    }

}