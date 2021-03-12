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
		tags = {"@unit�rios", "not @ignore"}, // permite executar cen�rios ou feature desejada, basta adicionar o identificador "@esse", "~@ignore" / {"@tipo1", "@tipo2"} / {"@tipo1, @tipo2"} / 
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = false, // junto com o plugin n�o exibe mais caracteres especiais, mais agrad�vel
		snippets = SnippetType.CAMELCASE,  /* o m�todo segue o padr�o da linguagem java. Exemplo "abrirBrowser". Primeira letra de cada palavra em mai�sculo */
		dryRun = false,  // Validar se o mapeamento est� correto, �til na montagem do cen�rio, se estiver ok voltar para exc. normal
		strict = false // Exibe erro ao identificar passos a mais no script
	)

public class RunnerTest {	
}	