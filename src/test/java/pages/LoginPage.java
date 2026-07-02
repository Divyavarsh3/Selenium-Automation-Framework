package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Email Text Box
    @FindBy(id = "loginEmail")
    WebElement txtEmail;

    // Password Text Box
    @FindBy(id = "loginPassword")
    WebElement txtPassword;

    // Sign In Button
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSignIn;

    // Enter Email
    public void enterEmail(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    // Enter Password
    public void enterPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    // Click Sign In
    public void clickSignIn() {
        btnSignIn.click();
    }
}