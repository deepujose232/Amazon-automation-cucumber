package test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\feature\\Searching.feature",glue= {"step_definition"},
plugin= {"pretty","html:target/htmlreports.html"},
dryRun=false,
monochrome=true)

public class Test_runner_class {
	

}
