package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.ProductPage;

public class TC003_Product extends BaseClass {

    @Test
    public void productTest() throws Exception {

        ProductPage pp = new ProductPage(driver);

        Thread.sleep(5000);
        System.out.println("Website Opened");

        // Search Product
        pp.searchProduct("Yoga");
        System.out.println("Product Searched");

        Thread.sleep(5000);

        // Open First Product
        pp.clickFirstProduct();
        System.out.println("First Product Opened");

        Thread.sleep(5000);

        // Select Size
        pp.selectSize();
        System.out.println("Size Selected");

        Thread.sleep(3000);

        // Color is already selected by default
        // pp.selectColor();

        Thread.sleep(3000);

        // Add To Cart
        pp.clickAddToCart();
        System.out.println("Product Added To Cart");

        Thread.sleep(5000);

        // Open Cart
        pp.clickCart();
        System.out.println("Cart Opened");

        Thread.sleep(5000);

        // Delete Product
        pp.deleteProduct();
        System.out.println("Product Deleted");

        Thread.sleep(3000);

        // Return To Home Page
        pp.goToHomePage();
        System.out.println("Returned To Home Page");

        Thread.sleep(5000);

        System.out.println("Automation Test Completed Successfully");

    }

}