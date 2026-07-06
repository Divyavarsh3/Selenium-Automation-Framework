package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ProductPage;

public class TC004_MultipleProducts extends BaseClass {

    @Test
    public void multipleProductsTest() throws Exception {

        ProductPage pp = new ProductPage(driver);

        Thread.sleep(5000);
        System.out.println("Website Opened");

        // Product 1
        pp.clickProduct(1);
        System.out.println("First Product Opened");

        pp.addCurrentProduct();
        System.out.println("First Product Added");

        // Product 2

        Thread.sleep(3000);

        pp.clickProduct(2);
        System.out.println("Second Product Opened");

        pp.addCurrentProduct();
        System.out.println("Second Product Added");

        // Product 3

        Thread.sleep(3000);

        pp.clickProduct(3);
        System.out.println("Third Product Opened");

        pp.addCurrentProduct();
        System.out.println("Third Product Added");

        // Open Cart

        Thread.sleep(3000);

        pp.clickCart();
        System.out.println("Cart Opened");

        Thread.sleep(5000);

        // Verify Product Exists in Cart
        Assert.assertTrue(pp.isProductDisplayed(),
                "Products are not displayed in the cart");

        System.out.println("Products Verified Successfully");

        // Verify Product Price Displayed
        Assert.assertFalse(pp.getProductPrice().isEmpty(),
                "Product Price is not displayed");

        System.out.println("Product Price Verified");

        // Delete Product 1

        pp.deleteProduct();
        System.out.println("First Product Deleted");

        Thread.sleep(3000);

        // Delete Product 2

        pp.deleteProduct();
        System.out.println("Second Product Deleted");

        Thread.sleep(3000);

        // Delete Product 3

        pp.deleteProduct();
        System.out.println("Third Product Deleted");

        Thread.sleep(3000);

        // Verify Cart Empty
        Assert.assertTrue(pp.isCartEmpty(),
                "Cart is not empty");

        System.out.println("Cart Verified Empty");

        // Return Home

        pp.goToHomePage();
        System.out.println("Returned To Home Page");

        Thread.sleep(5000);

        System.out.println("TC004 Multiple Products Automation Completed Successfully");

    }
}