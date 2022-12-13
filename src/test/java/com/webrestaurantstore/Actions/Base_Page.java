package com.webrestaurantstore.Actions;

import com.webrestaurantstore.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;


public abstract class Base_Page {

    public Base_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
