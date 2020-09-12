package com.fiserv.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
features = {"src/test/resources/Feature/"}
,glue = {"com.fiserv.stepdefn"}
,monochrome = true
,tags = {"@addpatient"}
//,dryRun = true

)

@RunWith(Cucumber.class)
public class RunnerTest {

}
