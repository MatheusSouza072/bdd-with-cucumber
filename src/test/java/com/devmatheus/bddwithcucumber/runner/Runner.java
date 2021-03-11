package com.devmatheus.bddwithcucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/aprender_cucumber.feature",
		glue = "br.ce.rogerioballestrin.steps",
		plugin = "pretty",
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = true
		)
public class Runner {
	
}
© 2021 GitHub, Inc.