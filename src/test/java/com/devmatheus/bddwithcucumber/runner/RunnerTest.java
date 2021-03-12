package com.devmatheus.bddwithcucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
//		features = "src/test/resources/features/aprender_cucumber.feature",
//		features = "src/test/resources/features/inserir_conta.feature",		
		features = "src/test/resources/features/",
				glue = {"com.devmatheus.bddwithcucumber.steps","com.devmatheus.bddwithcucumber.config"},
		tags = {"@unitários", "not @ignore"}, // permite executar cenários ou feature desejada, basta adicionar o identificador "@esse", "~@ignore" / {"@tipo1", "@tipo2"} / {"@tipo1, @tipo2"} / 
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = false, // junto com o plugin não exibe mais caracteres especiais, mais agradável
		snippets = SnippetType.CAMELCASE,  /* o método segue o padrão da linguagem java. Exemplo "abrirBrowser". Primeira letra de cada palavra em maiúsculo */
		dryRun = false,  // Validar se o mapeamento está correto, útil na montagem do cenário, se estiver ok voltar para exc. normal
		strict = false // Exibe erro ao identificar passos a mais no script
	)

public class RunnerTest {	
}	