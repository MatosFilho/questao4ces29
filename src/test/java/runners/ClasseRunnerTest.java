package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)

@CucumberOptions (
    format = {"pretty"},
    tags = "@classe",
    features = "src/test/resources/features/",
    dryRun = false,
    monochrome = true,
    glue = "steps"
    )

public class ClasseRunnerTest {}
