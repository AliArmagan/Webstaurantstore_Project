package com.webrestaurantstore.Step_Definations;

import com.webrestaurantstore.Actions.Empty_Cart_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class Empty_Cart_StepDef {

    Empty_Cart_Actions Actions = new Empty_Cart_Actions();

    @Given("user is on {string}")
    public void userIsOn(String URL) throws Throwable {
        Actions.getUrl(URL);
    }

    @And("user search for {string}")
    public void userSearchFor(String Product) throws InterruptedException {
        Actions.searchProduct(Product);
    }

    @Then("user verify results that every product titles has {string}")
    public void userVerifyResultsThatEveryProductTitlesHas(String Word) {
        Actions.VerifyTitleContainsWord(Word);

    }

    @Then("user adds last items to Cart")
    public void userAddsLastItemsToCart() {
        Actions.getLastFoundProduct();
    }

    @Then("user clicks on Empty Cart")
    public void userClicksOnEmptyCart() {

        Actions.clickEmptyCart();

    }




    }



