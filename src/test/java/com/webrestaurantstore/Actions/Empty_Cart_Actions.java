package com.webrestaurantstore.Actions;

import com.webrestaurantstore.Locaters.Empty_Cart_Locators;
import com.webrestaurantstore.Utilities.ConfigurationReader;
import com.webrestaurantstore.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Empty_Cart_Actions extends Base_Page{

    Empty_Cart_Locators Element = PageFactory.initElements(Driver.getDriver(), Empty_Cart_Locators.class);

    String lastItemTitle="";


    public void getUrl(String URL) {

        Driver.getDriver().get(ConfigurationReader.getProperty(URL));
        String title = Driver.getDriver().getTitle();
        System.out.println("Title is = "+title);

    }

    public void searchProduct(String Product){

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Element.searchBanner));
        System.out.println("User clicked search bar!");
        Element.searchBanner.sendKeys(Product);
        System.out.println("Start Searching");
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Element.searchButton)).click();


    }

    public void goToPage(int pageNumber) {
        if (pageNumber == 1) {return;}

        System.out.println("Navigating page " + pageNumber);

        WebElement page = Driver.getDriver().findElement(By.xpath("//a[contains(@aria-label, 'go to page " + pageNumber + "')]"));
        page.click();

    }

    public void VerifyTitleContainsWord(String Word){

        int currentPage;
        int nextPage;
        int totalPages = Integer.parseInt(Element.lastPage.getText());;

        System.out.println(totalPages + " pages of items listed.");

        for (currentPage = 1; currentPage <= totalPages; currentPage++) {

            System.out.println("Checking items for page: " + currentPage);

            nextPage = currentPage + 1;
            List<String>missingTittle = new ArrayList<>();

            //Asserting product titles
            for (WebElement products : Element.itemDescription) {
                String productTitle = products.getText();
                if((productTitle).contains(Word)){

                }else{
                    missingTittle.add(productTitle);
                }
            }
           // System.out.println("Product doesn't have "+Word+" on Title ==> "+missingTittle);
            if (missingTittle.size()>0){
                System.out.println("Not all the product title contains "+Word);
            }else{
                System.out.println("All products title contains "+Word);
            }

            if (currentPage != totalPages) {
                goToPage(nextPage);
            }


        }




    }

    public void getLastFoundProduct(){

        System.out.println("Adding last item on page");

        int itemSize = Element.addItemToCart.size();
        lastItemTitle=Element.productList.get(Element.productList.size()-1).getText();
        System.out.println("Last Item is ====>>>>"+lastItemTitle);
        Element.addItemToCart.get(itemSize - 1).click();
       // Element.addItemToCartOnPopup.click();


    }

    public void clickEmptyCart(){

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Element.cartButton)).click();

        System.out.println("Have "+Element.cartItems.size()+" product in the cart");

        String elementTitle =Element.cartItems.get((Element.cartItems.size())-1).getText();
        System.out.println(elementTitle);

        if(elementTitle.contains(lastItemTitle)) {
            System.out.println("Last item "+elementTitle + " in the Cart");
        }else{
            System.out.println("Last item is wrong");
        }

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Element.emptyCartBtn)).click();


        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Element.emptyCartPopUpBtn)).click();

        String EmptyCartHeader ="Your cart is empty.";

        if(Element.emptyCartHeader.getText().equals(EmptyCartHeader)){
            System.out.println("Cart is Empty");
        }else{
            System.out.println("Still there is product in cart");
        }



    }




}
