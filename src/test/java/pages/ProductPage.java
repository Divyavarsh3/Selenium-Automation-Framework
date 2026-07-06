package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // =========================
    // Web Elements
    // =========================

    // Search Box
    @FindBy(id = "searchInput")
    WebElement txtSearch;

    // First Product
    @FindBy(xpath = "(//div[contains(@class,'product-card')])[1]")
    WebElement firstProduct;

    // Size S
    @FindBy(xpath = "//div[@data-size='S']")
    WebElement sizeS;

    // Green Color
    @FindBy(xpath = "//div[@data-color='Green']")
    WebElement colorGreen;

    // Add To Cart Button
    @FindBy(id = "addToCartBtn")
    WebElement btnAddToCart;

    // Cart Icon
    @FindBy(className = "cart-link")
    WebElement cartIcon;

    // Delete Button
    @FindBy(className = "cart-item-remove")
    WebElement btnDelete;

    // =========================
    // NEW ELEMENTS FOR ASSERTIONS
    // =========================

    // Product Name
    @FindBy(className = "cart-item-name")
    WebElement cartProductName;

    @FindBy(className = "cart-col-price")
    WebElement productPrice;

    @FindBy(xpath = "//*[contains(text(),'Your cart is empty')]")
    WebElement emptyCartMessage;

    // =========================
    // Methods
    // =========================

    // Search Product
    public void searchProduct(String product) {

        txtSearch.clear();
        txtSearch.sendKeys(product);
        txtSearch.sendKeys(Keys.ENTER);

    }

    // Click First Product
    public void clickFirstProduct() {

        firstProduct.click();

    }

    // Select Size
    public void selectSize() {

        sizeS.click();

    }

    // Select Color
    public void selectColor() {

        colorGreen.click();

    }

    // Add To Cart
    public void clickAddToCart() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", btnAddToCart);

        btnAddToCart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }

    // Open Cart
    public void clickCart() throws Exception {

        cartIcon.click();

        Thread.sleep(3000);

    }

    // Delete Product
    public void deleteProduct() {

        btnDelete.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }

    // Return Home Page
    public void goToHomePage() {

        driver.get("https://luma.enablementadobe.com/");

    }

    // Existing Reusable Method

    public void addProduct(String productName) throws Exception {

        searchProduct(productName);
        Thread.sleep(3000);

        clickFirstProduct();
        Thread.sleep(3000);

        selectSize();
        Thread.sleep(2000);

        clickAddToCart();
        Thread.sleep(3000);

        goToHomePage();
        Thread.sleep(3000);

    }

    // =========================
    // NEW METHODS FOR TC004
    // =========================

    // Click Product by Position
    public void clickProduct(int index) {

        driver.findElement(By.xpath("(//div[contains(@class,'product-card')])[" + index + "]")).click();

    }

    // Add Currently Opened Product
    public void addCurrentProduct() throws Exception {

        Thread.sleep(2000);

        selectSize();

        Thread.sleep(2000);

        clickAddToCart();

        Thread.sleep(3000);

        goToHomePage();

        Thread.sleep(3000);

    }

    // =========================
    // ASSERTION METHODS
    // =========================

    // Verify Product Exists
    public boolean isProductDisplayed() {

        return cartProductName.isDisplayed();

    }

    // Get Product Price
    public String getProductPrice() {

        return productPrice.getText();

    }

    

    // Verify Empty Cart
    public boolean isCartEmpty() {

        return emptyCartMessage.isDisplayed();

    }

}