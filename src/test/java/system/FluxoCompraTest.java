package system;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FluxoCompra.feature",
        glue = (""), monochrome = true, dryRun = false)
public class FluxoCompraTest {

}

