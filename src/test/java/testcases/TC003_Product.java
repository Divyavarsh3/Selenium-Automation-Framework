package testcases;

import org.testng.Assert;
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

        // Verify Product is Added to Cart
        Assert.assertTrue(pp.isProductDisplayed(),
                "Product is not displayed in the cart");

        System.out.println("Product Verified Successfully");

        // Verify Product Price and Subtotal
        Assert.assertFalse(pp.getProductPrice().isEmpty(),
                "Product Price is not displayed");

        System.out.println("Product Price Verified");
        // Delete Product
        pp.deleteProduct();
        System.out.println("Product Deleted");

        Thread.sleep(3000);

        // Verify Cart is Empty
        Assert.assertTrue(pp.isCartEmpty(),
                "Cart is not empty");

        System.out.println("Cart Verified Empty");

        // Return To Home Page
        pp.goToHomePage();
        System.out.println("Returned To Home Page");

        Thread.sleep(5000);

        System.out.println("Automation Test Completed Successfully");

    }

}