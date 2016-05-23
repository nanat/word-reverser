package com.oneninetwo.recruitment.wordreverse;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        tags = "@greetings, @word-reversing",
        features = "src/test/resources/features/",
        format = {"pretty", "html: cucumber-html-reports", "json: cucumber-html-reports/cucumber.json"}
)
public class RunTests {}