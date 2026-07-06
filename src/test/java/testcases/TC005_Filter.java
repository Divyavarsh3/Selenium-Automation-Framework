package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.FilterPage;
import pages.ProductPage;

public class TC005_Filter extends BaseClass {

    @Test
    public void filterTest() throws Exception {

        FilterPage fp = new FilterPage(driver);
        ProductPage pp = new ProductPage(driver);

        Thread.sleep(5000);
        System.out.println("Website Opened");

        // ==================================
        // WOMEN FILTER + ADD TO CART
        // ==================================

        fp.clickWomen();
        System.out.println("Women Page Opened");

        fp.selectCategoryTops();
        System.out.println("Women Category Filter Applied");

        fp.selectPriceUnder50();
        System.out.println("Women Price Filter Applied");

        Thread.sleep(3000);

        Assert.assertTrue(fp.isProductsDisplayed(),
                "Women products are not displayed");

        System.out.println("Women Products Verified");

        pp.clickFirstProduct();
        System.out.println("Women Product Opened");

        Thread.sleep(3000);

        pp.selectSize();
        System.out.println("Women Size Selected");

        Thread.sleep(2000);

        pp.clickAddToCart();
        System.out.println("Women Product Added To Cart");

        Thread.sleep(3000);

        pp.goToHomePage();
        System.out.println("Returned To Home Page");

        Thread.sleep(3000);

        // ==================================
        // MEN FILTER + ADD TO CART
        // ==================================

        fp.clickMen();
        System.out.println("Men Page Opened");

        fp.selectCategoryTops();
        System.out.println("Men Category Filter Applied");

        fp.selectPriceUnder50();
        System.out.println("Men Price Filter Applied");

        Thread.sleep(3000);

        Assert.assertTrue(fp.isProductsDisplayed(),
                "Men products are not displayed");

        System.out.println("Men Products Verified");

        pp.clickFirstProduct();
        System.out.println("Men Product Opened");

        Thread.sleep(3000);

        pp.selectSize();
        System.out.println("Men Size Selected");

        Thread.sleep(2000);

        pp.clickAddToCart();
        System.out.println("Men Product Added To Cart");

        Thread.sleep(3000);

        // ==================================
        // OPEN CART
        // ==================================

        pp.clickCart();
        System.out.println("Cart Opened");

        Thread.sleep(3000);

        Assert.assertTrue(pp.isProductDisplayed(),
                "Products are not available in cart");

        System.out.println("Products Verified In Cart");

        // ==================================
        // DELETE PRODUCT 1
        // ==================================

        pp.deleteProduct();
        System.out.println("First Product Deleted");

        Thread.sleep(3000);

        // ==================================
        // DELETE PRODUCT 2
        // ==================================

        pp.deleteProduct();
        System.out.println("Second Product Deleted");

        Thread.sleep(3000);

        // ==================================
        // VERIFY EMPTY CART
        // ==================================

        Assert.assertTrue(pp.isCartEmpty(),
                "Cart is not empty");

        System.out.println("Cart Verified Empty");

        // ==================================
        // RETURN HOME
        // ==================================

        pp.goToHomePage();
        System.out.println("Returned To Home Page");

        Thread.sleep(3000);

        System.out.println("TC005 Filter Automation Completed Successfully");

    }

}