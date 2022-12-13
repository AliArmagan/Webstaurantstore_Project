package com.webrestaurantstore.Locaters;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Empty_Cart_Locators {


    @FindBy(id = "searchval")
    public WebElement searchBanner;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@data-testid='itemDescription']")
    public List<WebElement> productList;

    @FindBy(xpath = "//a[contains(@aria-label, 'last page')]")
    public WebElement lastPage;

    @FindBy(css = "[data-testid='itemDescription']")
    public List<WebElement> itemDescription;

    @FindBy(css = "[data-testid='itemAddCart']")
    public List<WebElement> addItemToCart;

    @FindBy(xpath = "//a[@class='btn btn-small btn-primary'] | //*[text()='View Cart']")
    public WebElement cartButton;

    @FindBy(xpath = "//div[@class='ag ag-cart box']/ul/li")
    public List<WebElement> cartItems;

    @FindBy(xpath = "//button[text()='Empty Cart']")
    public WebElement emptyCartBtn;

    @FindBy(xpath = "//button[text()='Empty']")
    public WebElement emptyCartPopUpBtn;

    @FindBy(xpath = "//*[text()='Your cart is empty.']")
    public WebElement emptyCartHeader;



}
