package com.webrestaurantstore.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(

            plugin = {

                    "pretty",
                    "json:target/cucumber.json"
            },

            features = "src/test/resources/features",
            glue = "com/webrestaurantstore/Step_Definations",
            dryRun = false,
            publish =true,
            tags = "@Search"



    )

    public class CucumberRunner {
    }

