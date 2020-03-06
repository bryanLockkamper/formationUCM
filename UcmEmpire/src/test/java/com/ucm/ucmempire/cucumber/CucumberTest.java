package com.ucm.ucmempire.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = "src/test/java/com/ucm/ucmempire/cucumber/feature",
        extraGlue = "be.ucm"
        //,tags = "@todo"
        ,strict = true
)
public class CucumberTest {
}
