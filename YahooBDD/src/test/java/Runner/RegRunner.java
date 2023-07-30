package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/Feature",
        glue = "Login",
        
        dryRun = false,
        monochrome = true,
         plugin = {"pretty","html: Report/CUCUreport.html"}
        )

public class RegRunner {

}
