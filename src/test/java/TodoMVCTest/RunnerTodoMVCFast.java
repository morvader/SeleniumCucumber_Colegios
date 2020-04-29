package TodoMVCTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/TodoMVC",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        glue = {"TodoMVCTest"},
        tags = {"@fast", "@Smoke"}
)
public class RunnerTodoMVCFast extends AbstractTestNGCucumberTests {
}