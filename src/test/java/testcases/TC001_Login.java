package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass {

    @Test
    public void loginTest() throws Exception {

        // Create LoginPage object
        LoginPage lp = new LoginPage(driver);

        // Wait for Login page to load
        Thread.sleep(10000);

        // Enter Email
        lp.enterEmail("gsridivyavarshini@gmail.com");

        Thread.sleep(5000);

        // Enter Password
        lp.enterPassword("Sri@2005");

        Thread.sleep(5000);

        // Click Sign In
        lp.clickSignIn();

        // Wait after login
        Thread.sleep(15000);

        System.out.println("Login Successful");
    }
}