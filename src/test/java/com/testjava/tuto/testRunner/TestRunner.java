package com.testjava.tuto.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(strict = true, features = "classpath:features/ModifierAdresse.feature", glue = "com/testjava/tuto/stepDefinitions/", plugin = "pretty", monochrome = true)
public class TestRunner {
	
}
